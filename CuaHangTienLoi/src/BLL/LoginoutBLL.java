
package BLL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import GUI.FrameLogin;
import DTO.user;
import DAL.DALuser;
import GUI.FrameLogin;
import GUI.TrangChu;
import javax.swing.JOptionPane;


public class LoginoutBLL{
    private FrameLogin logView;
    private DALuser daluser = new DALuser();
    
    public LoginoutBLL(FrameLogin logView) {
        this.logView = logView;
    }

    public int CheckStatusBLL(String username, String password) {
        switch (daluser.checkStatus(username, password)) {
            case 0 -> {
                JOptionPane.showMessageDialog(logView, "Đăng nhập thành công quyền quản lý");
                return 0;
            }
            case 1 -> {
                JOptionPane.showMessageDialog(logView, "Đăng nhập thành công quyền nhân viên thu ngân");
                return 1;
            }
            case 2 -> {
                JOptionPane.showMessageDialog(logView, "Tài khoản đã bị khóa");
                return 2;
            }
            default -> {
                JOptionPane.showMessageDialog(logView, "Đăng nhập thất bại");
                return -1;
            }
        }
    }
}

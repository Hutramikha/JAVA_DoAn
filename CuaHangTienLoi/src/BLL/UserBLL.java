package BLL;

import DTO.user;
import GUI.NhanVienView;
import DAL.DALuser;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UserBLL implements BLLinterface<user> {

    private NhanVienView nvView;
    private DALuser daluser = new DALuser();
    
    @Override
    public ArrayList<user> getALL() {
        return daluser.selectAll();
    }
    
    @Override
    public void add(user us) {
        try {
            if (daluser.insert(us) > 0) {
                JOptionPane.showMessageDialog(nvView, "Tạo tài khoản thành công");
            } else {
                JOptionPane.showMessageDialog(nvView, "Tạo tài khoản thất bại");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void delete(user us) {
   
    }
    
    public void delete(String ma) {
        try {
            if (daluser.delete(ma) > 0) {
                JOptionPane.showMessageDialog(nvView, "Xóa tài khoản thành công");
            } else {
                JOptionPane.showMessageDialog(nvView, "Xóa tài khoản thất bại");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void update(user t, String maOld) {
        try {
                if (daluser.updateALL(t, maOld) > 0) {
                    JOptionPane.showMessageDialog(nvView, "Sửa tài khoản thành công");
                } else {
                    JOptionPane.showMessageDialog(nvView, "Sửa tài khoản thất bại");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

    @Override
    public ArrayList<user> search(String keyword, String byWhat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}


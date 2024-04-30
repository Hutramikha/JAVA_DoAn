
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


public class LoginBLL implements ActionListener{
    private FrameLogin logView;
    private DALuser daluser = new DALuser();
    
    public LoginBLL(FrameLogin logView) {
        this.logView = logView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(e.getSource() == logView.btn_dn) {
            String username = logView.username_dn.getText().trim();
            String password = logView.pass_dn.getText().trim();
            if(username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(logView, "Vui lòng điền đầy đủ thông tin");
            }
            else {
                int status = daluser.checkStatus(username, password);
                switch (status) {
                    case 0 -> {
                        logView.username_dn.setText("");
                        logView.pass_dn.setText("");
                        logView.dispose();
                        new TrangChu().setVisible(true);
                    }
                    case 1 -> {
                        logView.username_dn.setText("");
                        logView.pass_dn.setText("");
                        logView.dispose();
                    }
                    default -> JOptionPane.showMessageDialog(logView, "Tên đăng nhập hoặc mật khẩu không chính xác !!!");
                }
            }
        }
        else {}    
    }
}

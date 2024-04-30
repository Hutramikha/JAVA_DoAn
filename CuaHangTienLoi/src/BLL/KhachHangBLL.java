package BLL;

import GUI.KhachHangView;
import DTO.khachHang;
import javax.swing.JOptionPane;
import DAL.DALkhachHang;
import java.util.ArrayList;

public class KhachHangBLL implements BLLinterface<khachHang>{

    private KhachHangView khView;
    private DALkhachHang dalkh = new DALkhachHang();
    private ArrayList<khachHang> list = new ArrayList<>();

    public KhachHangBLL(KhachHangView khView) {
        this.khView = khView;
    }
    
    public ArrayList<khachHang> getALL() {
        return dalkh.selectAll();
    }
   
    @Override
    public void add(khachHang kh) {
        list = dalkh.selectAll();
        boolean flag = false;
        for (khachHang tmp : list) {
            if (tmp.getMakh().equals(kh.getMakh())) {
                flag = true;
            }
        }
        if (flag) {
            JOptionPane.showMessageDialog(khView, "Mã khách hàng đã tồn tại");
            return;
        }
        try {
            if (dalkh.insert(kh) > 0) {
                JOptionPane.showMessageDialog(khView, "Thêm thành công");
            } else {
                JOptionPane.showMessageDialog(khView, "Thêm thất bại");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void delete(khachHang kh) {
         try {
             if (dalkh.delete(kh) > 0) {
                JOptionPane.showMessageDialog(khView, "Xóa thành công");
             } else {
                 JOptionPane.showMessageDialog(khView, "Xóa thất bại");
             }
         } catch (Exception ex) {
             System.out.println(ex);
         }
    }
    
    @Override
    public void update(khachHang kh, String maOld) {
         list = dalkh.selectAll();
        boolean found = false;
        if (!kh.getMakh().equals(maOld)) {
            for (khachHang tmp : list) {
                if (tmp.getMakh().equals(kh.getMakh())) {
                    found = true;
                    break;
                }
            }
        }
        if (found) {
            JOptionPane.showMessageDialog(khView, "Mã khách hàng đã tồn tại");
        } else {
            try {
                if (dalkh.updateALL(kh, maOld) > 0) {
                    JOptionPane.showMessageDialog(khView, "Sửa thành công");
                } else {
                    JOptionPane.showMessageDialog(khView, "Sửa thất bại");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}

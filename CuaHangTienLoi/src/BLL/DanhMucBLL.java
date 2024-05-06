/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;


import GUI.DanhMucView;
import DTO.DanhMuc;
import javax.swing.JOptionPane;
import DAL.DALdanhMuc;
import java.util.ArrayList;


public class DanhMucBLL implements BLLinterface<DanhMuc>{
    
    private DanhMucView dmView;
    private DALdanhMuc daldm = new DALdanhMuc();
    private ArrayList<DanhMuc> list = new ArrayList<>();

    public DanhMucBLL(DanhMucView dm) {
        this.dmView = dm;
    }

    public DanhMucBLL() {
     
    }
    
    @Override
    public ArrayList<DanhMuc> getALL() {
        return daldm.selectAll();
    }
   
    @Override
    public void add(DanhMuc dm) {
        list = daldm.selectAll();
        boolean flag = false;
        for (DanhMuc tmp : list) {
            if (tmp.getMaloai().equals(dm.getMaloai())) {
                flag = true;
            }
        }
        if (flag) {
            JOptionPane.showMessageDialog(dmView, "Mã loại đã tồn tại");
            return;
        }
        try {
            if (daldm.insert(dm) > 0) {
                JOptionPane.showMessageDialog(dmView, "Thêm thành công");
            } else {
                JOptionPane.showMessageDialog(dmView, "Thêm thất bại");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void delete(DanhMuc dm) {
         try {
             if (daldm.delete(dm) > 0) {
                JOptionPane.showMessageDialog(dmView, "Xóa thành công");
             } else {
                 JOptionPane.showMessageDialog(dmView, "Xóa thất bại");
             }
         } catch (Exception ex) {
             System.out.println(ex);
         }
    }
    
    @Override
    public void update(DanhMuc dm, String maOld) {
         list = daldm.selectAll();
        boolean found = false;
        if (!dm.getMaloai().equals(maOld)) {
            for (DanhMuc tmp : list) {
                if (tmp.getMaloai().equals(dm.getMaloai())) {
                    found = true;
                    break;
                }
            }
        }
        if (found) {
            JOptionPane.showMessageDialog(dmView, "Mã loại đã tồn tại");
        } else {
            try {
                if (daldm.updateALL(dm, maOld) > 0) {
                    JOptionPane.showMessageDialog(dmView, "Sửa thành công");
                } else {
                    JOptionPane.showMessageDialog(dmView, "Sửa thất bại");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    @Override
    public ArrayList<DanhMuc> search(String keyword, String byWhat) {
       return daldm.selectByCondition(keyword, byWhat);
    }

    
}

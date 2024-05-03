/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;


import GUI.DanhMuc;
import DTO.danhMuc;
import javax.swing.JOptionPane;
import DAL.DALdanhMuc;
import java.util.ArrayList;


public class DanhMucBLL implements BLLinterface<danhMuc>{
    
    private DanhMuc dmView;
    private DALdanhMuc daldm = new DALdanhMuc();
    private ArrayList<danhMuc> list = new ArrayList<>();

    public DanhMucBLL(DanhMuc dm) {
        this.dmView = dm;
    }

    public DanhMucBLL() {
     
    }
    
    public ArrayList<danhMuc> getALL() {
        return daldm.selectAll();
    }
   
    @Override
    public void add(danhMuc dm) {
        list = daldm.selectAll();
        boolean flag = false;
        for (danhMuc tmp : list) {
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
    public void delete(danhMuc dm) {
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
    public void update(danhMuc dm, String maOld) {
         list = daldm.selectAll();
        boolean found = false;
        if (!dm.getMaloai().equals(maOld)) {
            for (danhMuc tmp : list) {
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
    
}

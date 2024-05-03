/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;


import GUI.NhaCungCap;
import DTO.nhaCungCap;
import javax.swing.JOptionPane;
import DAL.DALnhaCungCap;
import java.util.ArrayList;


public class NhaCungCapBLL implements BLLinterface<nhaCungCap>{
    
    private NhaCungCap nccView;
    private DALnhaCungCap dalncc = new DALnhaCungCap();
    private ArrayList<nhaCungCap> list = new ArrayList<>();

    public NhaCungCapBLL(NhaCungCap ncc) {
        this.nccView = ncc;
    }
    
    public ArrayList<nhaCungCap> getALL() {
        return dalncc.selectAll();
    }
   
    @Override
    public void add(nhaCungCap ncc) {
        list = dalncc.selectAll();
        boolean flag = false;
        for (nhaCungCap tmp : list) {
            if (tmp.getMaNCC().equals(ncc.getMaNCC())) {
                flag = true;
            }
        }
        if (flag) {
            JOptionPane.showMessageDialog(nccView, "Mã nhà cung cấp đã tồn tại");
            return;
        }
        try {
            if (dalncc.insert(ncc) > 0) {
                JOptionPane.showMessageDialog(nccView, "Thêm thành công");
            } else {
                JOptionPane.showMessageDialog(nccView, "Thêm thất bại");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void delete(nhaCungCap ncc) {
         try {
             if (dalncc.delete(ncc) > 0) {
                JOptionPane.showMessageDialog(nccView, "Xóa thành công");
             } else {
                 JOptionPane.showMessageDialog(nccView, "Xóa thất bại");
             }
         } catch (Exception ex) {
             System.out.println(ex);
         }
    }
    
    @Override
    public void update(nhaCungCap ncc, String maOld) {
         list = dalncc.selectAll();
        boolean found = false;
        if (!ncc.getMaNCC().equals(maOld)) {
            for (nhaCungCap tmp : list) {
                if (tmp.getMaNCC().equals(ncc.getMaNCC())) {
                    found = true;
                    break;
                }
            }
        }
        if (found) {
            JOptionPane.showMessageDialog(nccView, "Mã nhà cung cấp đã tồn tại");
        } else {
            try {
                if (dalncc.updateALL(ncc, maOld) > 0) {
                    JOptionPane.showMessageDialog(nccView, "Sửa thành công");
                } else {
                    JOptionPane.showMessageDialog(nccView, "Sửa thất bại");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
    
}

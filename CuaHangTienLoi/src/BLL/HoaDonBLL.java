/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;


import GUI.HoaDonView;
import DTO.*;
import javax.swing.JOptionPane;
import DAL.HoaDonDAL;
import java.util.ArrayList;


public class HoaDonBLL implements BLLinterface<HoaDon>{
    
    private HoaDonView hdView;
    private HoaDonDAL dalhd = new HoaDonDAL();
    private ArrayList<HoaDon> list = new ArrayList<>();

    public HoaDonBLL(HoaDonView hd) {
        this.hdView = hd;
    }

    public HoaDonBLL() {
     
    }
    
    @Override
    public ArrayList<HoaDon> getALL() {
        return dalhd.selectAll();
    }
   
    @Override
    public void add(HoaDon hd) {
        list = dalhd.selectAll();
        try {
            if (dalhd.insert(hd) > 0) {
                JOptionPane.showMessageDialog(hdView, "Thêm thành công");
            } else {
                JOptionPane.showMessageDialog(hdView, "Thêm thất bại");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void delete(HoaDon hd) {
         try {
             if (dalhd.delete(hd) > 0) {
                JOptionPane.showMessageDialog(hdView, "Xóa thành công");
             } else {
                 JOptionPane.showMessageDialog(hdView, "Xóa thất bại");
             }
         } catch (Exception ex) {
             System.out.println(ex);
         }
    }
    
    @Override
    public void update(HoaDon hd, String maOld) {
        list = dalhd.selectAll();
            try {
                if (dalhd.updateALL(hd, maOld) > 0) {
                    JOptionPane.showMessageDialog(hdView, "Sửa thành công");
                } else {
                    JOptionPane.showMessageDialog(hdView, "Sửa thất bại");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
    }

    @Override
    public ArrayList<HoaDon> search(String keyword, String byWhat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

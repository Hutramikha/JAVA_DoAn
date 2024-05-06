/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;


import GUI.*;
import DTO.*;
import javax.swing.JOptionPane;
import DAL.*;
import java.util.ArrayList;


public class CTHoaDonBLL implements BLLinterface<CtHoaDon>{
    
    private CTHoaDonView cthdView;
    private HoaDonView hdView;
    private CtHoaDonDAL dalcthd = new CtHoaDonDAL();
    private ArrayList<CtHoaDon> list = new ArrayList<>();

    public CTHoaDonBLL(CTHoaDonView cthd) {
        this.cthdView = cthd;
    }

    public CTHoaDonBLL() {
    }
    
    @Override
    public ArrayList<CtHoaDon> getALL() {
        return dalcthd.selectAll();
    }
   
    @Override
    public void add(CtHoaDon cthd) {
        list = dalcthd.selectAll();
        try {
            if (dalcthd.insert(cthd) > 0) {
                System.err.println("Thêm thành công");
            } else {
                 System.err.println("Thêm thất bại");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void delete(CtHoaDon cthd) {
         try {
             if (dalcthd.delete(cthd) > 0) {
                JOptionPane.showMessageDialog(cthdView, "Xóa thành công");
             } else {
                 JOptionPane.showMessageDialog(cthdView, "Xóa thất bại");
             }
         } catch (Exception ex) {
             System.out.println(ex);
         }
    }
    
    @Override
    public void update(CtHoaDon cthd, String maOld) {
        
    }

    @Override
    public ArrayList<CtHoaDon> search(String keyword, String byWhat) {
        
        return null;
        
    }
    
}

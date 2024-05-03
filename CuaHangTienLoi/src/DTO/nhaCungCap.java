/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Quy
 */
public class nhaCungCap {
    private String mancc;
    private String tenncc;
    private String tenndd;
    private String diachi;
    private String sdt;

    
    public String getMaNCC() {
        return mancc;
    }

    public String getTenNCC() {
        return tenncc;
    }

    public String getSdt() {
        return sdt;
    }
    
    public String getTenNDD(){
        return tenndd;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setMaNCC(String mancc) {
        this.mancc = mancc;
    }

    public void setTenNCC(String ten) {
        this.tenncc = ten;
    }
    
    public void setTenNDD(String ten) {
        this.tenndd = ten;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setDiachi(String dchi) {
        this.diachi = dchi;
    }

    public nhaCungCap(String mancc, String tenncc, String tenndd, String sdt, String dchi) {
        this.mancc = mancc;
        this.tenncc = tenncc;
        this.tenndd = tenndd;
        this.sdt = sdt;
        this.diachi = dchi;
    }

    public nhaCungCap() {
    }
    
    
     @Override
    public String toString() {
        return "nhaCungCap{" + "mancc=" + mancc + ", ten NCC=" + tenncc + ",ten NDD= " + tenndd +", sdt=" + sdt + ", diachi=" + diachi + '}';
    }
}

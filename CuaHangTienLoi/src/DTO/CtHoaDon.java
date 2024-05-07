/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;


public class CtHoaDon {
    private String mahd;
    private String masp;
    private String tensp;
    private int soluong;
    private long dongia;
    private long thanhtien;
    
    public CtHoaDon() {
    }

    public CtHoaDon(String mahd, String masp, String tensp  ,int soluong, long dongia, long thanhtien) {
        this.mahd = mahd;
        this.masp = masp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
    }

    public CtHoaDon(String masp, int soluong, long thanhtien) {
        this.masp = masp;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
    }
    
    

    public String getMahd() {
        return mahd;
    }

    public String getMasp() {
        return masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public long getDongia() {
        return dongia;
    }

    public long getThanhtien() {
        return thanhtien;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setDongia(long dongia) {
        this.dongia = dongia;
    }

    public void setThanhtien(long thanhtien) {
        this.thanhtien = thanhtien;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    @Override
    public String toString() {
        return "CtHoaDon{" + "mahd=" + mahd + ", masp=" + masp + ", tensp=" + tensp + ", soluong=" + soluong + ", dongia=" + dongia + ", thanhtien=" + thanhtien + '}';
    }

    

}
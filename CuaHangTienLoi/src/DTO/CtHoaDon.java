/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author votru
 */
public class CtHoaDon {
    private int mahd;
    private int masp;
    private int soluong;
    private int dongia;
    private int thanhtien;

    public CtHoaDon(int mahd, int masp, int soluong, int dongia, int thanhtien) {
        this.mahd = mahd;
        this.masp = masp;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
    }

    public int getMahd() {
        return mahd;
    }

    public int getMasp() {
        return masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public int getDongia() {
        return dongia;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    @Override
    public String toString() {
        return "CtHoaDon{" + "mahd=" + mahd + ", masp=" + masp + ", soluong=" + soluong + ", dongia=" + dongia + ", thanhtien=" + thanhtien + '}';
    }
    
    
    
}

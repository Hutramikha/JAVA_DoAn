/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

public class HoaDon {
    private String mahd;
    private String makh;
    private String manv;
    private Date ngaytao;
    private long tongtien;
    

    public HoaDon() {
    }

    public HoaDon(String mahd, String makh, String manv, Date ngaytao, long tongtien) {
        this.mahd = mahd;
        this.makh = makh;
        this.manv = manv;
        this.ngaytao = ngaytao;
        this.tongtien = tongtien;
    }

    public String getMahd() {
        return mahd;
    }

    public String getMakh() {
        return makh;
    }

    public String getManv() {
        return manv;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public long getTongtien() {
        return tongtien;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public void setTongtien(long tongtien) {
        this.tongtien = tongtien;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "mahd=" + mahd + ", makh=" + makh + ", manv=" + manv + ", ngaytao=" + ngaytao + ", tongtien=" + tongtien + '}';
    }

   
}
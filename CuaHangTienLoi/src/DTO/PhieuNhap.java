/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

public class PhieuNhap {
    private String mapn;
    private String mancc;
    private String manv;
    private Date ngaytao;
    private long tongtien;
    

    public PhieuNhap() {
    }

    public PhieuNhap(String mapn, String mancc, String manv, Date ngaytao, long tongtien) {
        this.mapn = mapn;
        this.mancc = mancc;
        this.manv = manv;
        this.ngaytao = ngaytao;
        this.tongtien = tongtien;
    }

    public String getMapn() {
        return mapn;
    }

    public String getMancc() {
        return mancc;
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

    public void setMapn(String mapn) {
        this.mapn = mapn;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
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
        return "PhieuNhap{" + "mapn=" + mapn + ", mancc=" + mancc + ", manv=" + manv + ", ngaytao=" + ngaytao + ", tongtien=" + tongtien + '}';
    }

    
   
}
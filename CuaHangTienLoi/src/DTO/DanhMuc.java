/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author votru
 */
public class DanhMuc {
    private String maloaisp;
    private String tenloai;
    private String img;

    public DanhMuc(String maloaisp, String tenloai, String img) {
        this.maloaisp = maloaisp;
        this.tenloai = tenloai;
        this.img = img;
    }

    public String getMaloaisp() {
        return maloaisp;
    }

    public String getTenloai() {
        return tenloai;
    }

    public String getImg() {
        return img;
    }

    public void setMaloaisp(String maloaisp) {
        this.maloaisp = maloaisp;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "DanhMuc{" + "maloaisp=" + maloaisp + ", tenloai=" + tenloai + ", img=" + img + '}';
    }
    
    
    
}

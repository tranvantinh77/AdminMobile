package com.example.adminpage.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int ID;
    private String Ten;
    private String Hinhanh;
    private Integer Gia;
    private String Thongsokithuat;
    private String Mota;
    private int IDsanphamdienthoai;
    private int IDsanpham;

    public Product(int ID, String ten, String hinhanh, Integer gia, String thongsokithuat, String mota, int IDsanphamdienthoai, int IDsanpham) {
        this.ID = ID;
        Ten = ten;
        Hinhanh = hinhanh;
        Gia = gia;
        Thongsokithuat = thongsokithuat;
        Mota = mota;
        this.IDsanphamdienthoai = IDsanphamdienthoai;
        this.IDsanpham = IDsanpham;
    }

    public Product(int ID, String ten, String hinhanh, Integer gia, String thongsokithuat, String mota, int IDsanpham) {
        this.ID = ID;
        Ten = ten;
        Hinhanh = hinhanh;
        Gia = gia;
        Thongsokithuat = thongsokithuat;
        Mota = mota;
        this.IDsanpham = IDsanpham;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getHinhanh() {
        return Hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        Hinhanh = hinhanh;
    }

    public Integer getGia() {
        return Gia;
    }

    public void setGia(Integer gia) {
        Gia = gia;
    }

    public String getThongsokithuat() {
        return Thongsokithuat;
    }

    public void setThongsokithuat(String thongsokithuat) {
        Thongsokithuat = thongsokithuat;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public int getIDsanphamdienthoai() {
        return IDsanphamdienthoai;
    }

    public void setIDsanphamdienthoai(int IDsanphamdienthoai) {
        this.IDsanphamdienthoai = IDsanphamdienthoai;
    }

    public int getIDsanpham() {
        return IDsanpham;
    }

    public void setIDsanpham(int IDsanpham) {
        this.IDsanpham = IDsanpham;
    }
}

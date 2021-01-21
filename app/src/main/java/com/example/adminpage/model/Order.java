package com.example.adminpage.model;

import java.io.Serializable;

public class Order implements Serializable {
    int ID;
    String tenkhachhang;
    String email;
    String sodienthoai;
    String diachi;
    String ghichu;

    public Order() {

    }

    public Order(int ID, String tenkhachhang, String email, String sodienthoai, String diachi, String ghichu) {
        this.ID = ID;
        this.tenkhachhang = tenkhachhang;
        this.email = email;
        this.sodienthoai = sodienthoai;
        this.diachi = diachi;
        this.ghichu = ghichu;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}

package com.example.adminpage.model;

import java.io.Serializable;

public class OrderDetails implements Serializable {
    int ID;
    int madonhang;
    int masanpham;
    String tensanpham;
    String hinhanhsanpham;
    int giasanpham;
    int soluongsanpham;

    public OrderDetails() {

    }

    public OrderDetails(int ID, int madonhang, int masanpham, String tensanpham, String hinhanhsanpham, int giasanpham, int soluongsanpham) {
        this.ID = ID;
        this.madonhang = madonhang;
        this.masanpham = masanpham;
        this.tensanpham = tensanpham;
        this.hinhanhsanpham = hinhanhsanpham;
        this.giasanpham = giasanpham;
        this.soluongsanpham = soluongsanpham;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMadonhang() {
        return madonhang;
    }

    public void setMadonhang(int madonhang) {
        this.madonhang = madonhang;
    }

    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getHinhanhsanpham() {
        return hinhanhsanpham;
    }

    public void setHinhanhsanpham(String hinhanhsanpham) {
        this.hinhanhsanpham = hinhanhsanpham;
    }

    public int getGiasanpham() {
        return giasanpham;
    }

    public void setGiasanpham(int giasanpham) {
        this.giasanpham = giasanpham;
    }

    public int getSoluongsanpham() {
        return soluongsanpham;
    }

    public void setSoluongsanpham(int soluongsanpham) {
        this.soluongsanpham = soluongsanpham;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "ID=" + ID +
                ", madonhang=" + madonhang +
                ", masanpham=" + masanpham +
                ", tensanpham='" + tensanpham + '\'' +
                ", hinhanhsanpham='" + hinhanhsanpham + '\'' +
                ", giasanpham=" + giasanpham +
                ", soluongsanpham=" + soluongsanpham +
                '}';
    }
}

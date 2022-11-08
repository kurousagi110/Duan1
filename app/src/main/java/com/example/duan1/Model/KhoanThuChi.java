package com.example.duan1.Model;

public class KhoanThuChi {
    Integer maKhoan;
    Integer tenKhoan;
    String ngay;
    Integer maLoai;

    public KhoanThuChi() {
    }

    public KhoanThuChi(Integer maKhoan, Integer tenKhoan, String ngay, Integer maLoai) {
        this.maKhoan = maKhoan;
        this.tenKhoan = tenKhoan;
        this.ngay = ngay;
        this.maLoai = maLoai;
    }

    public Integer getMaKhoan() {
        return maKhoan;
    }

    public void setMaKhoan(Integer maKhoan) {
        this.maKhoan = maKhoan;
    }

    public Integer getTenKhoan() {
        return tenKhoan;
    }

    public void setTenKhoan(Integer tenKhoan) {
        this.tenKhoan = tenKhoan;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public Integer getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(Integer maLoai) {
        this.maLoai = maLoai;
    }
}

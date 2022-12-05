package com.example.duan1.Model;

public class QLno {
    private String TEN;
    private String SoTien;
    private String DaTra;
    private String trangThai;
    private Integer ConLai;

    public QLno(String string, String cursorString, String s, String string1, int anInt) {
    }
    public QLno(String ten, String trangThai) {
        this.TEN = ten;
        this.trangThai = trangThai;

    }
    public QLno(String TEN, String soTien,String daTra ,String trangThai, Integer conLai) {
        this.TEN = TEN;
        this.SoTien = soTien;
        this.DaTra = daTra;
        this.trangThai = trangThai;
        this.ConLai = conLai;
    }

    public QLno(int parseInt) {
        this.TEN = TEN;
    }

    public String getTEN() {
        return TEN;
    }

    public void setTEN(String TEN) {
        this.TEN = TEN;
    }

    public String getSoTien() {
        return SoTien;
    }

    public void setSoTien(String soTien) {
        SoTien = soTien;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public  String getTrangThai() {
        return trangThai;
    }

    public String getDaTra() {
        return DaTra;
    }

    public void setDaTra(String daTra) {
        DaTra = daTra;
    }

    public Integer getConLai() {
        return ConLai;
    }

    public void setConLai(Integer conLai) {
        ConLai = conLai;
    }

    }


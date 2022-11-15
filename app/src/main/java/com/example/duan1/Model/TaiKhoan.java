package com.example.duan1.Model;

public class TaiKhoan {
    private Integer soTK;
    private String taiKhoan;
    private String matKhau;

    public TaiKhoan() {
    }

    public TaiKhoan(Integer soTK, String taiKhoan, String matKhau) {
        this.soTK = soTK;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public Integer getSoTK() {
        return soTK;
    }

    public void setSoTK(Integer soTK) {
        this.soTK = soTK;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}

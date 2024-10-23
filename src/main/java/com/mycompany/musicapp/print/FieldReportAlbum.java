package com.mycompany.musicapp.print;

public class FieldReportAlbum {

    String tenBaiHat;
    String ngheSi;

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getNgheSi() {
        return ngheSi;
    }

    public void setNgheSi(String ngheSi) {
        this.ngheSi = ngheSi;
    }

    public FieldReportAlbum(String tenBaiHat, String ngheSi) {
        this.tenBaiHat = tenBaiHat;
        this.ngheSi = ngheSi;
    }

    public FieldReportAlbum() {
    }
}

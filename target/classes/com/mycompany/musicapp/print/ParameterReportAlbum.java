package com.mycompany.musicapp.print;

import java.util.List;

public class ParameterReportAlbum {

    String tenAlbum;
    String tongBaiHat;
    List<FieldReportAlbum> fields;

    public String getTenAlbum() {
        return tenAlbum;
    }

    public void setTenAlbum(String tenAlbum) {
        this.tenAlbum = tenAlbum;
    }

    public String getTongBaiHat() {
        return tongBaiHat;
    }

    public void setTongBaiHat(String tongBaiHat) {
        this.tongBaiHat = tongBaiHat;
    }

    public List<FieldReportAlbum> getFields() {
        return fields;
    }

    public void setFields(List<FieldReportAlbum> fields) {
        this.fields = fields;
    }

    public ParameterReportAlbum(String tenAlbum, String tongBaiHat, List<FieldReportAlbum> fields) {
        this.tenAlbum = tenAlbum;
        this.tongBaiHat = tongBaiHat;
        this.fields = fields;
    }

    public ParameterReportAlbum() {
    }
}

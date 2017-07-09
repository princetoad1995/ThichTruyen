package com.princetoad.thichtruyen.Common.Domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by PRINCETOAD on 10/07/2017.
 */

public class TruyenDTO extends BaseDTO implements Serializable{
    @SerializedName("id")
    private int id;
    @SerializedName("ten")
    private String ten;
    @SerializedName("tacgia")
    private String tacgia;
    @SerializedName("theloai")
    private int theloai;
    @SerializedName("sochuong")
    private int sochuong;
    @SerializedName("anhbia")
    private String anhbia;
    @SerializedName("yeuthich")
    private int yeuthich;

    public TruyenDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public int getTheloai() {
        return theloai;
    }

    public void setTheloai(int theloai) {
        this.theloai = theloai;
    }

    public int getSochuong() {
        return sochuong;
    }

    public void setSochuong(int sochuong) {
        this.sochuong = sochuong;
    }

    public String getAnhbia() {
        return anhbia;
    }

    public void setAnhbia(String anhbia) {
        this.anhbia = anhbia;
    }

    public int getYeuthich() {
        return yeuthich;
    }

    public void setYeuthich(int yeuthich) {
        this.yeuthich = yeuthich;
    }
}

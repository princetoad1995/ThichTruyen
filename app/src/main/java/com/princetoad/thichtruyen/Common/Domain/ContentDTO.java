package com.princetoad.thichtruyen.Common.Domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by PRINCETOAD on 11/07/2017.
 */

public class ContentDTO extends BaseDTO implements Serializable{
    @SerializedName("id")
    private int id;
    @SerializedName("idTruyen")
    private int idTruyen;
    @SerializedName("idChap")
    private int idChap;
    @SerializedName("tenChap")
    private String tenChap;
    @SerializedName("noidung")
    private String content;

    public ContentDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTruyen() {
        return idTruyen;
    }

    public void setIdTruyen(int idTruyen) {
        this.idTruyen = idTruyen;
    }

    public int getIdChap() {
        return idChap;
    }

    public void setIdChap(int idChap) {
        this.idChap = idChap;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTenChap() {
        return tenChap;
    }

    public void setTenChap(String tenChap) {
        this.tenChap = tenChap;
    }
}

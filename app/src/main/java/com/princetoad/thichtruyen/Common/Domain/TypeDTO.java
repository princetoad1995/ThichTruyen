package com.princetoad.thichtruyen.Common.Domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by PRINCE D. TOAD on 1/22/2018.
 */

public class TypeDTO extends BaseDTO implements Serializable{
    @SerializedName("id")
    private int id;
    @SerializedName("ten")
    private String ten;
    @SerializedName("avatar")
    private String avatar;

    public TypeDTO() {
    }

    public TypeDTO(int id, String ten, String avatar) {
        this.id = id;
        this.ten = ten;
        this.avatar = avatar;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}

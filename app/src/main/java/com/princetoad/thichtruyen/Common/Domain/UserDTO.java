package com.princetoad.thichtruyen.Common.Domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by PRINCETOAD on 13/10/2017.
 */

public class UserDTO extends BaseDTO implements Serializable{
    @SerializedName("id")
    private int id;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("linkAvatar")
    private String linkAvatar;

    public UserDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLinkAvatar() {
        return linkAvatar;
    }

    public void setLinkAvatar(String linkAvatar) {
        this.linkAvatar = linkAvatar;
    }
}

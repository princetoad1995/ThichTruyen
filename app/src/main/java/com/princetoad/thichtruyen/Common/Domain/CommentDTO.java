package com.princetoad.thichtruyen.Common.Domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by PRINCETOAD on 13/10/2017.
 */

public class CommentDTO extends BaseDTO implements Serializable{
    @SerializedName("id")
    private int id;
    @SerializedName("idTruyen")
    private TruyenDTO truyenDTO;
    @SerializedName("idUser")
    private UserDTO userDTO;
    @SerializedName("content")
    private String content;

    public CommentDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TruyenDTO getTruyenDTO() {
        return truyenDTO;
    }

    public void setTruyenDTO(TruyenDTO truyenDTO) {
        this.truyenDTO = truyenDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

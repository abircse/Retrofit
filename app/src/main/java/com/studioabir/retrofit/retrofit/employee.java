package com.studioabir.retrofit.retrofit;

import com.google.gson.annotations.SerializedName;

public class employee {

    @SerializedName("name")
    private String Name;

    @SerializedName("designation")
    private String Designation;

    @SerializedName("photo")
    private String Photo;

    public String getName() {
        return Name;
    }

    public String getDesignation() {
        return Designation;
    }

    public String getPhoto() {
        return Photo;
    }
}
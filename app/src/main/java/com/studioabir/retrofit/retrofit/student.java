package com.studioabir.retrofit.retrofit;

import com.google.gson.annotations.SerializedName;

public class student {

    @SerializedName("class")
    private String Classlevel;

    @SerializedName("name")
    private String Name;

    public String getClasslevel() {
        return Classlevel;
    }

    public String getName() {
        return Name;
    }
}
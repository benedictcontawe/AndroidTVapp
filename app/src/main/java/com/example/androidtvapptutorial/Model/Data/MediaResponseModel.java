package com.example.androidtvapptutorial.Model.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MediaResponseModel {

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("localImageResource")
    @Expose
    private String localImageResource;

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocalImageResource() {
        return localImageResource;
    }

}

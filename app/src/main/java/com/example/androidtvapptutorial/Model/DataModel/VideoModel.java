package com.example.androidtvapptutorial.Model.DataModel;

import androidx.room.ColumnInfo;

public class VideoModel {

    @ColumnInfo(name = "Title")
    private String title;

    @ColumnInfo(name = "Description")
    private String description;

    public VideoModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

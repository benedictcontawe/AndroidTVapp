package com.example.androidtvapptutorial.Model.DataModel;

public class VideoModel {

    private String title;
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

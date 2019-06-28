package com.example.androidtvapptutorial.Model.Data;

public class MusicModel {

    private String title;
    private String description;

    public MusicModel(String title, String description){
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

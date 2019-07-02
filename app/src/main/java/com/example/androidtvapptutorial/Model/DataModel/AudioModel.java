package com.example.androidtvapptutorial.Model.DataModel;

public class AudioModel {

    private String title;
    private String description;

    public AudioModel(String title, String description){
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

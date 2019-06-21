package com.example.androidtvapptutorial.DataModel;

public class MediaData {
    private String title;
    private String description;
    private Type type;

    public MediaData(String title, String description, Type type) {
        this.title = title;
        this.description = description;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        IMAGE,
        VIDEO,
        MUSIC,
        DOCUMENT
    }
}

package com.example.androidtvapptutorial.Model.Room.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "media_source")
public class MediaEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "localImageResource")
    private String localImageResource;

    public MediaEntity(String type, String title, String description, String localImageResource) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.localImageResource = localImageResource;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

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

package com.example.androidtvapptutorial.Model.Room.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "media_table")
public class MediaEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private int id;

    @ColumnInfo(name = "Name")
    private String flashDrive;

    @ColumnInfo(name = "Type")
    private String type;

    @ColumnInfo(name = "Title")
    private String title;

    @ColumnInfo(name = "Description")
    private String description;

    @ColumnInfo(name = "Local Image Resource")
    private String localImageResource;

    public MediaEntity(String flashDrive, String type, String title, String description, String localImageResource) {
        this.flashDrive = flashDrive;
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

    public String getFlashDrive() {
        return flashDrive;
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

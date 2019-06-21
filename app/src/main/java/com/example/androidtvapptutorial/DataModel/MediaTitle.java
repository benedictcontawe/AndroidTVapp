package com.example.androidtvapptutorial.DataModel;

import java.util.List;

public class MediaTitle {
    private String title;
    private List<MediaData> data;

    public MediaTitle(String title, List<MediaData> data) {
        this.title = title;
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MediaData> getData() {
        return data;
    }

    public void setData(List<MediaData> data) {
        this.data = data;
    }
}

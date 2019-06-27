package com.example.androidtvapptutorial.DataModel;

import java.util.List;

public class MediaTitle<T> {
    private String title;
    private List<T> datum;

    public MediaTitle(String title, List<T> data) {
        this.title = title;
        this.datum = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<T> getDatum() {
        return datum;
    }

    public void setDatum(List<T> datum) {
        this.datum = datum;
    }
}

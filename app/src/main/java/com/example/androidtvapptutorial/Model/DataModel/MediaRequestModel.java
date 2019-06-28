package com.example.androidtvapptutorial.Model.DataModel;

public class MediaRequestModel {

    private boolean isMounted;
    private String folderName;

    public MediaRequestModel(boolean isMounted, String folderName) {
        this.isMounted = isMounted;
        this.folderName = folderName;
    }

    public boolean isMounted() {
        return isMounted;
    }

    public String getFolderName() {
        return folderName;
    }
}

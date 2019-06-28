package com.example.androidtvapptutorial.DataModel;

public class MediaStateModel {

    private boolean isMounted;
    private String folderName;

    public MediaStateModel(boolean isMounted, String folderName) {
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

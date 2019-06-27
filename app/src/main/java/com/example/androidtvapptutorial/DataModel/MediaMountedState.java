package com.example.androidtvapptutorial.DataModel;

public class MediaMountedState {

    private boolean isMounted;
    private String folderName;

    public MediaMountedState(boolean isMounted, String folderName) {
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

package com.example.androidtvapptutorial.DataModel;

public class UsbFileCard {
    private String fileName;
    private String fileExt;

    public UsbFileCard(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public Type getType() {
        return Type.SINGLE;
    }

    public enum Type {
        SINGLE
    }
}

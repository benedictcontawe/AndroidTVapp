package com.example.androidtvapptutorial.DataModel;

import java.util.List;

public class UsbFileCardRow {
    private String title;
    private List<UsbFileCard> usbFileCards;

    public UsbFileCardRow(String title, List<UsbFileCard> usbFileCards) {
        this.title = title;
        this.usbFileCards = usbFileCards;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<UsbFileCard> getUsbFileCards() {
        return usbFileCards;
    }

    public void setUsbFileCards(List<UsbFileCard> usbFileCards) {
        this.usbFileCards = usbFileCards;
    }
}

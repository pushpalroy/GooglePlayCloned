package com.pushpal.googleplayclone.models;

public class PopularItemAppModel {
    private int itemImage;
    private String itemHeader;
    private String itemSubHeader;
    private String itemNumber;

    public PopularItemAppModel(String itemHeader, String itemSubHeader, int itemImage, String itemNumber) {
        this.itemHeader = itemHeader;
        this.itemSubHeader = itemSubHeader;
        this.itemNumber = itemNumber;
        this.itemImage = itemImage;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemHeader() {
        return itemHeader;
    }

    public void setItemHeader(String itemHeader) {
        this.itemHeader = itemHeader;
    }

    public String getItemSubHeader() {
        return itemSubHeader;
    }

    public void setItemSubHeader(String itemSubHeader) {
        this.itemSubHeader = itemSubHeader;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }
}

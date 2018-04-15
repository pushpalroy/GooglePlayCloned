package com.pushpal.googleplayclone.models;

public class MainItemAppModel {
    private String appName;
    private String appRating;
    private String isFree;
    private int appImage;

    public MainItemAppModel(String appName, String appRating, String isFree, int appImage) {
        this.appName = appName;
        this.appRating = appRating;
        this.isFree = isFree;
        this.appImage = appImage;
    }

    public int getAppImage() {
        return appImage;
    }

    public void setAppImage(int appImage) {
        this.appImage = appImage;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppRating() {
        return appRating;
    }

    public void setAppRating(String appRating) {
        this.appRating = appRating;
    }

    public String getIsFree() {
        return isFree;
    }

    public void setIsFree(String isFree) {
        this.isFree = isFree;
    }
}

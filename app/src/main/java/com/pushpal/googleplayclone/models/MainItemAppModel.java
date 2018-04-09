package com.pushpal.googleplayclone.models;

import android.graphics.drawable.Drawable;

public class MainItemAppModel {
    private String appName;
    private String appRating;
    private String isFree;
    private Drawable appImage;

    public MainItemAppModel(String appName, String appRating, String isFree, Drawable appImage) {
        this.appName = appName;
        this.appRating = appRating;
        this.isFree = isFree;
        this.appImage = appImage;
    }

    public Drawable getAppImage() {
        return appImage;
    }

    public void setAppImage(Drawable appImage) {
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

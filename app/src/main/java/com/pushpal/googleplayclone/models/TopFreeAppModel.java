package com.pushpal.googleplayclone.models;

public class TopFreeAppModel {

    private String appName;
    private String appDeveloper;
    private String appSize;
    private String appRating;
    private int appImage;

    public TopFreeAppModel(String appName, String appDeveloper, String appSize, String appRating, int appImage) {
        this.appName = appName;
        this.appDeveloper = appDeveloper;
        this.appSize = appSize;
        this.appRating = appRating;
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

    public String getAppDeveloper() {
        return appDeveloper;
    }

    public void setAppDeveloper(String appDeveloper) {
        this.appDeveloper = appDeveloper;
    }

    public String getAppSize() {
        return appSize;
    }

    public void setAppSize(String appSize) {
        this.appSize = appSize;
    }

    public String getAppRating() {
        return appRating;
    }

    public void setAppRating(String appRating) {
        this.appRating = appRating;
    }
}

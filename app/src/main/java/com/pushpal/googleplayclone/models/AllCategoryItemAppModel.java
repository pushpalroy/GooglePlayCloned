package com.pushpal.googleplayclone.models;

public class AllCategoryItemAppModel {
    private String appName;
    private int appImage;

    public AllCategoryItemAppModel(String appName, int appImage) {
        this.appName = appName;
        this.appImage = appImage;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getAppImage() {
        return appImage;
    }

    public void setAppImage(int appImage) {
        this.appImage = appImage;
    }
}

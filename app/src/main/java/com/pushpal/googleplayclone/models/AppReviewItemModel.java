package com.pushpal.googleplayclone.models;

public class AppReviewItemModel {
    private String userName;
    private String userReview;
    private int userReviewRatings;
    private String userReviewDate;
    private int userPicture;

    public AppReviewItemModel(String userName, String userReview, int userReviewRatings, String userReviewDate, int userPicture) {
        this.userName = userName;
        this.userReview = userReview;
        this.userReviewRatings = userReviewRatings;
        this.userReviewDate = userReviewDate;
        this.userPicture = userPicture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserReview() {
        return userReview;
    }

    public void setUserReview(String userReview) {
        this.userReview = userReview;
    }

    public int getUserReviewRatings() {
        return userReviewRatings;
    }

    public void setUserReviewRatings(int userReviewRatings) {
        this.userReviewRatings = userReviewRatings;
    }

    public String getUserReviewDate() {
        return userReviewDate;
    }

    public void setUserReviewDate(String userReviewDate) {
        this.userReviewDate = userReviewDate;
    }

    public int getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(int userPicture) {
        this.userPicture = userPicture;
    }
}

package com.pushpal.googleplayclone.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bumptech.glide.Glide;
import com.pushpal.googleplayclone.R;
import com.pushpal.googleplayclone.adapters.AppReviewsAdapter;
import com.pushpal.googleplayclone.adapters.AppScreenshotsAdapter;
import com.pushpal.googleplayclone.models.AppReviewItemModel;

import java.util.ArrayList;
import java.util.Objects;

public class AppActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView appScreenshotsRecyclerView, appReviewsRecyclerView;
    ArrayList<String> screenshotImages;
    ArrayList<AppReviewItemModel> appReviews;
    de.hdodenhof.circleimageview.CircleImageView profileImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        profileImageView = findViewById(R.id.profile_image);
        Glide.with(this)
                .load(R.drawable.profile_image)
                .into(profileImageView);

        appScreenshotsRecyclerView = findViewById(R.id.rv_app_screenshots);
        RecyclerView.LayoutManager horizontalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        appScreenshotsRecyclerView.setLayoutManager(horizontalLayoutManager);
        appScreenshotsRecyclerView.setHasFixedSize(true);
        loadScreenshotsDataAndSetAdapter();

        appReviewsRecyclerView = findViewById(R.id.rv_app_reviews);
        RecyclerView.LayoutManager verticalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        appReviewsRecyclerView.setLayoutManager(verticalLayoutManager);
        appReviewsRecyclerView.setHasFixedSize(true);
        loadAppReviewsDataAndSetAdapter();
    }

    private void loadScreenshotsDataAndSetAdapter() {
        screenshotImages = new ArrayList<>();
        screenshotImages.add("screenshot_1");
        screenshotImages.add("screenshot_2");
        screenshotImages.add("screenshot_3");
        screenshotImages.add("screenshot_4");
        screenshotImages.add("screenshot_5");
        screenshotImages.add("screenshot_6");

        appScreenshotsRecyclerView.setAdapter(new AppScreenshotsAdapter(screenshotImages, this));
    }

    private void loadAppReviewsDataAndSetAdapter() {
        appReviews = new ArrayList<>();
        appReviews.add(new AppReviewItemModel("John Butler", "This clone is one of the best and has good " +
                "ux/ui but it lacks on content downloads for pls add resume/pause support for the active " +
                "download", 4, "02/04/18", R.drawable.john_butler));

        appReviews.add(new AppReviewItemModel("David Gilmour", "Great app! Loved it as " +
                "much as I loved Pink Floyd.", 5, "09/04/18", R.drawable.david_gilmour));

        appReviews.add(new AppReviewItemModel("Steven Wilson", "", 5, "02/04/18", R.drawable.steven_wilson));

        appReviewsRecyclerView.setAdapter(new AppReviewsAdapter(appReviews, this));
    }
}

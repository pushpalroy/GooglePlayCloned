package com.pushpal.googleplayclone.activities;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.pushpal.googleplayclone.R;
import com.pushpal.googleplayclone.adapters.AppScreenshotsAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class AppActivity extends AppCompatActivity {

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbar;
    RecyclerView appScreenshotView;
    ArrayList<String> screenshotImages;

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

        appScreenshotView = findViewById(R.id.rv_app_screenshots);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        appScreenshotView.setLayoutManager(layoutManager);
        appScreenshotView.setHasFixedSize(true);
        loadDataAndSetAdapter();
    }

    private void loadDataAndSetAdapter() {
        screenshotImages = new ArrayList<>();
        screenshotImages.add("screenshot_1");
        screenshotImages.add("screenshot_2");
        screenshotImages.add("screenshot_3");
        screenshotImages.add("screenshot_4");
        screenshotImages.add("screenshot_5");
        screenshotImages.add("screenshot_6");

        appScreenshotView.setAdapter(new AppScreenshotsAdapter(screenshotImages, this));
    }
}

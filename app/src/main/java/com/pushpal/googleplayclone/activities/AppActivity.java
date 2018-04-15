package com.pushpal.googleplayclone.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.pushpal.googleplayclone.R;
import com.pushpal.googleplayclone.adapters.AppReviewsAdapter;
import com.pushpal.googleplayclone.adapters.AppScreenshotsAdapter;
import com.pushpal.googleplayclone.models.AppReviewItemModel;

import java.util.ArrayList;
import java.util.Objects;

public class AppActivity extends AppCompatActivity {

    private final Handler handler = new Handler();
    private RecyclerView appScreenshotsRecyclerView;
    private RecyclerView appReviewsRecyclerView;
    private int progressStatus = 0;
    private TextView downloadSize;
    private TextView downloadPercent;
    private ProgressBar downloadProgress;
    private RelativeLayout downloadLayout;
    private LinearLayout openAppLayout;
    private AppCompatButton installButton;

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

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        de.hdodenhof.circleimageview.CircleImageView profileImageView = findViewById(R.id.profile_image);
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

        downloadLayout = findViewById(R.id.rl_download);
        openAppLayout = findViewById(R.id.ll_open_app);
        installButton = findViewById(R.id.btn_install);
        downloadSize = findViewById(R.id.tv_download_size);
        downloadPercent = findViewById(R.id.tv_download_percent);
        downloadProgress = findViewById(R.id.pb_app_download);
        AppCompatButton openAppButton = findViewById(R.id.btn_open);

        installButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DownloadApp().execute("");
            }
        });

        openAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PackageManager pm = AppActivity.this.getPackageManager();
                Intent launchIntent = pm.getLaunchIntentForPackage("com.udacity.android");
                if (launchIntent != null) {
                    AppActivity.this.startActivity(launchIntent);
                } else {
                    Toast.makeText(AppActivity.this, "You forgot this is a clone! Udacity App is not installed in your device!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void loadScreenshotsDataAndSetAdapter() {
        ArrayList<String> screenshotImages = new ArrayList<>();
        screenshotImages.add("screenshot_1");
        screenshotImages.add("screenshot_2");
        screenshotImages.add("screenshot_3");
        screenshotImages.add("screenshot_4");
        screenshotImages.add("screenshot_5");
        screenshotImages.add("screenshot_6");

        appScreenshotsRecyclerView.setAdapter(new AppScreenshotsAdapter(screenshotImages, this));
    }

    private void loadAppReviewsDataAndSetAdapter() {
        ArrayList<AppReviewItemModel> appReviews = new ArrayList<>();
        appReviews.add(new AppReviewItemModel("John Butler", "This clone is one of the best and has good " +
                "ux/ui but it lacks on content downloads for pls add resume/pause support for the active " +
                "download", 4, "02/04/18", R.drawable.john_butler));

        appReviews.add(new AppReviewItemModel("David Gilmour", "Great app! Loved it as " +
                "much as I loved Pink Floyd.", 5, "09/04/18", R.drawable.david_gilmour));

        appReviews.add(new AppReviewItemModel("Steven Wilson", "", 5, "02/04/18", R.drawable.steven_wilson));

        appReviewsRecyclerView.setAdapter(new AppReviewsAdapter(appReviews, this));
    }

    private class DownloadApp extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            installButton.setVisibility(View.GONE);
            openAppLayout.setVisibility(View.GONE);
            downloadLayout.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {

            while (progressStatus < 100) {
                progressStatus += 1;

                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    @SuppressLint({"SetTextI18n", "DefaultLocale"})
                    @Override
                    public void run() {
                        downloadProgress.setProgress(progressStatus);
                        downloadPercent.setText(progressStatus + " %");
                        downloadSize.setText(String.format("%.2f", (progressStatus * (28.81 / 100))) + "MB/28.81MB");
                    }
                });
            }

            return "";
        }

        @Override
        protected void onPostExecute(String result) {
            downloadLayout.setVisibility(View.GONE);
            openAppLayout.setVisibility(View.VISIBLE);
        }
    }
}

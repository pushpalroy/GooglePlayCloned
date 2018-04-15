package com.pushpal.googleplayclone.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pushpal.googleplayclone.R;
import com.pushpal.googleplayclone.models.AppReviewItemModel;

import java.util.ArrayList;

public class AppReviewsAdapter extends RecyclerView.Adapter<AppReviewsAdapter.AppViewHolder> {

    private final ArrayList<AppReviewItemModel> appReviewsList;
    private final Context mContext;

    public AppReviewsAdapter(ArrayList<AppReviewItemModel> appReviewsList, Context context) {
        this.appReviewsList = appReviewsList;
        this.mContext = context;

    }

    @NonNull
    @Override
    public AppReviewsAdapter.AppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app_review, parent, false);
        return new AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppReviewsAdapter.AppViewHolder holder, int position) {
        holder.userName.setText(appReviewsList.get(position).getUserName());
        holder.userReview.setText(appReviewsList.get(position).getUserReview());
        holder.userReviewDate.setText(appReviewsList.get(position).getUserReviewDate());
        holder.userReviewRating.setRating(appReviewsList.get(position).getUserReviewRatings());
        Glide.with(mContext)
                .load(appReviewsList.get(position).getUserPicture())
                .into(holder.userImage);
    }

    @Override
    public int getItemCount() {
        return appReviewsList.size();
    }

    class AppViewHolder extends RecyclerView.ViewHolder {

        final ImageView userImage;
        final TextView userName;
        final TextView userReview;
        final TextView userReviewDate;
        final me.zhanghai.android.materialratingbar.MaterialRatingBar userReviewRating;

        AppViewHolder(View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.iv_user_image);
            userName = itemView.findViewById(R.id.tv_user_name);
            userReview = itemView.findViewById(R.id.tv_user_review);
            userReviewDate = itemView.findViewById(R.id.tv_user_review_date);
            userReviewRating = itemView.findViewById(R.id.rb_user_review);
        }
    }
}

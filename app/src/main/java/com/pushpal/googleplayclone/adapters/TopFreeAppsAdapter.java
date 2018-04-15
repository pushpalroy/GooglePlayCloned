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
import com.pushpal.googleplayclone.models.TopFreeAppModel;

import java.util.ArrayList;

public class TopFreeAppsAdapter extends RecyclerView.Adapter<TopFreeAppsAdapter.MyViewHolder> {

    private final ArrayList<TopFreeAppModel> mArrayList;
    private Context mContext;

    public TopFreeAppsAdapter(ArrayList<TopFreeAppModel> mArrayList) {
        this.mArrayList = mArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top_free_app, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Glide.with(mContext)
                .load(mArrayList.get(position).getAppImage())
                .into(holder.iv_app_item);

        holder.tv_app_item_number.setText(String.valueOf(position + 1));
        holder.tv_app_name.setText(mArrayList.get(position).getAppName());
        holder.tv_app_developer.setText(mArrayList.get(position).getAppDeveloper());
        holder.tv_app_size.setText(mArrayList.get(position).getAppSize());
        holder.tv_app_ratings.setText(mArrayList.get(position).getAppRating());

        if (mArrayList.get(position).getAppRating().equals("EDITOR'S CHOICE")) {
            holder.iv_app_rating.setVisibility(View.GONE);
            holder.tv_app_ratings.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_editors_choice, 0, 0, 0);
        }
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private final ImageView iv_app_item;
        private final ImageView iv_app_rating;
        private final TextView tv_app_item_number;
        private final TextView tv_app_name;
        private final TextView tv_app_developer;
        private final TextView tv_app_size;
        private final TextView tv_app_ratings;

        MyViewHolder(View view) {
            super(view);

            iv_app_item = view.findViewById(R.id.iv_app_item);
            iv_app_rating = view.findViewById(R.id.iv_app_rating);
            tv_app_item_number = view.findViewById(R.id.tv_app_item_number);
            tv_app_name = view.findViewById(R.id.tv_app_name);
            tv_app_developer = view.findViewById(R.id.tv_app_developer);
            tv_app_size = view.findViewById(R.id.tv_app_size);
            tv_app_ratings = view.findViewById(R.id.tv_app_ratings);
        }
    }
}

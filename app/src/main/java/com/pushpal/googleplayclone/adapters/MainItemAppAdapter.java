package com.pushpal.googleplayclone.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pushpal.googleplayclone.R;
import com.pushpal.googleplayclone.activities.AppActivity;
import com.pushpal.googleplayclone.models.MainItemAppModel;

import java.util.ArrayList;

public class MainItemAppAdapter extends RecyclerView.Adapter<MainItemAppAdapter.MyViewHolder> {

    private final ArrayList<MainItemAppModel> mArrayList;
    private Context mcontext;

    MainItemAppAdapter(ArrayList<MainItemAppModel> mArrayList) {
        this.mArrayList = mArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mcontext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_app, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(mcontext)
                .load(mArrayList.get(position).getAppImage())
                .into(holder.iv_app_image);

        holder.tv_app_name.setText(mArrayList.get(position).getAppName());
        holder.tv_app_rating.setText(mArrayList.get(position).getAppRating());

        Log.d("MyAdapter", "position: " + position);
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView iv_app_image;
        private final TextView tv_app_name;
        private final TextView tv_app_rating;
        private final LinearLayout cardViewLayout;

        MyViewHolder(View view) {
            super(view);

            iv_app_image = view.findViewById(R.id.iv_app_image);
            tv_app_name = view.findViewById(R.id.tv_app_name);
            tv_app_rating = view.findViewById(R.id.tv_app_rating);
            cardViewLayout = view.findViewById(R.id.cardViewLayout);
            cardViewLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mcontext, AppActivity.class);
            mcontext.startActivity(intent);
        }
    }
}

package com.pushpal.googleplayclone.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pushpal.googleplayclone.R;
import com.pushpal.googleplayclone.models.MainItemAppModel;

import java.util.ArrayList;

public class MainItemAppAdapter extends RecyclerView.Adapter<MainItemAppAdapter.MyViewHolder> {

    private ArrayList<MainItemAppModel> mArrayList;

    MainItemAppAdapter(ArrayList<MainItemAppModel> mArrayList) {
        this.mArrayList = mArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_app_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //holder.iv_app_image.setImageDrawable(mArrayList.get(position).getAppImage());
        holder.tv_app_name.setText(mArrayList.get(position).getAppName());
        holder.tv_app_rating.setText(mArrayList.get(position).getAppRating());

        Log.d("MyAdapter", "position: " + position);
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_app_image;
        private TextView tv_app_name, tv_app_rating;

        MyViewHolder(View view) {
            super(view);

            iv_app_image = view.findViewById(R.id.iv_app_image);
            tv_app_name = view.findViewById(R.id.tv_app_name);
            tv_app_rating = view.findViewById(R.id.tv_app_rating);
        }
    }
}

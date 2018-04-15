package com.pushpal.googleplayclone.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pushpal.googleplayclone.R;
import com.pushpal.googleplayclone.models.TopCategoryItemAppModel;

import java.util.ArrayList;

public class TopCategoryItemAppAdapter extends RecyclerView.Adapter<TopCategoryItemAppAdapter.MyViewHolder> {

    private final ArrayList<TopCategoryItemAppModel> mArrayList;

    public TopCategoryItemAppAdapter(ArrayList<TopCategoryItemAppModel> mArrayList) {
        this.mArrayList = mArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top_category, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_top_app_name.setText(mArrayList.get(position).getAppName());
        holder.iv_top_app_image.setImageResource(mArrayList.get(position).getAppImage());
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private final de.hdodenhof.circleimageview.CircleImageView iv_top_app_image;
        private final TextView tv_top_app_name;

        MyViewHolder(View view) {
            super(view);
            iv_top_app_image = view.findViewById(R.id.top_category_app_image);
            tv_top_app_name = view.findViewById(R.id.tv_top_category_app_name);
        }
    }
}

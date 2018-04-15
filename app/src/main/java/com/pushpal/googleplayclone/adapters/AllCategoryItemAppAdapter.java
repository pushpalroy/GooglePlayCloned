package com.pushpal.googleplayclone.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pushpal.googleplayclone.R;
import com.pushpal.googleplayclone.models.AllCategoryItemAppModel;

import java.util.ArrayList;

public class AllCategoryItemAppAdapter extends RecyclerView.Adapter<AllCategoryItemAppAdapter.MyViewHolder> {

    private final ArrayList<AllCategoryItemAppModel> mArrayList;

    public AllCategoryItemAppAdapter(ArrayList<AllCategoryItemAppModel> mArrayList) {
        this.mArrayList = mArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_category, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_all_app_name.setText(mArrayList.get(position).getAppName());
        holder.civ_all_app_image.setImageResource(mArrayList.get(position).getAppImage());
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private final de.hdodenhof.circleimageview.CircleImageView civ_all_app_image;
        private final TextView tv_all_app_name;

        MyViewHolder(View view) {
            super(view);
            civ_all_app_image = view.findViewById(R.id.civ_all_category_app_image);
            tv_all_app_name = view.findViewById(R.id.tv_all_category_app_name);
        }
    }
}

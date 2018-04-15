package com.pushpal.googleplayclone.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pushpal.googleplayclone.R;
import com.pushpal.googleplayclone.models.HomeItemModel;
import com.pushpal.googleplayclone.models.MainItemAppModel;
import com.pushpal.googleplayclone.models.PopularItemAppModel;

import java.util.ArrayList;

public class HomeItemAdapter extends RecyclerView.Adapter {

    private final ArrayList<HomeItemModel> mArrayList;
    private final Context context;

    public HomeItemAdapter(ArrayList<HomeItemModel> mArrayList, Context context) {
        this.mArrayList = mArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;

        switch (viewType) {
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popular, parent, false);
                return new PopularViewHolder(view);

            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
                return new NormalViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        HomeItemModel homeItemModel = mArrayList.get(position);

        if (homeItemModel != null) {
            switch (homeItemModel.getType()) {
                case "special":
                    ((PopularViewHolder) holder).popular_item_app_recycler_view.setHasFixedSize(true);
                    RecyclerView.LayoutManager popLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
                    ((PopularViewHolder) holder).popular_item_app_recycler_view.setLayoutManager(popLayoutManager);

                    ArrayList<PopularItemAppModel> popularList = loadPopularList();
                    PopularItemAppAdapter popularItemAppAdapter = new PopularItemAppAdapter(popularList);
                    ((PopularViewHolder) holder).popular_item_app_recycler_view.setAdapter(popularItemAppAdapter);

                    break;
                case "normal":
                    ((NormalViewHolder) holder).tv_card_header.setText(mArrayList.get(position).getHeader());

                    if (!mArrayList.get(position).getSubHeader().equals(""))
                        ((NormalViewHolder) holder).tv_card_sub_header.setText(mArrayList.get(position).getSubHeader());
                    else
                        ((NormalViewHolder) holder).tv_card_sub_header.setVisibility(View.GONE);

                    ((NormalViewHolder) holder).main_item_app_recycler_view.setHasFixedSize(true);
                    RecyclerView.LayoutManager normalLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
                    ((NormalViewHolder) holder).main_item_app_recycler_view.setLayoutManager(normalLayoutManager);

                    ArrayList<MainItemAppModel> list = loadNormalList();

                    MainItemAppAdapter mainItemAppAdapter = new MainItemAppAdapter(list);
                    ((NormalViewHolder) holder).main_item_app_recycler_view.setAdapter(mainItemAppAdapter);

                    break;
            }
        }


        Log.d("MyAdapter", "position: " + position);
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    private ArrayList<MainItemAppModel> loadNormalList() {
        ArrayList<MainItemAppModel> mArrayList = new ArrayList<>();

        if (context != null) {
            mArrayList.add(new MainItemAppModel("Udacity", "4.3", "FREE", R.drawable.ic_udacity));
            mArrayList.add(new MainItemAppModel("Facebook", "4.1", "FREE", R.drawable.logo_facebook));
            mArrayList.add(new MainItemAppModel("Slack", "4.4", "FREE", R.drawable.logo_slack));
            mArrayList.add(new MainItemAppModel("Gmail", "4.3", "FREE", R.drawable.logo_gmail));
            mArrayList.add(new MainItemAppModel("LinkedIn", "4.2", "FREE", R.drawable.logo_linkedin));
            mArrayList.add(new MainItemAppModel("Whatsapp", "4.4", "FREE", R.drawable.logo_whatsapp));
            mArrayList.add(new MainItemAppModel("To do", "4.0", "FREE", R.drawable.logo_to_do));
            mArrayList.add(new MainItemAppModel("Code Monk", "4.3", "FREE", R.drawable.logo_code_monk));
        }

        return mArrayList;
    }

    private ArrayList<PopularItemAppModel> loadPopularList() {
        ArrayList<PopularItemAppModel> mArrayList = new ArrayList<>();

        if (context != null) {
            mArrayList.add(new PopularItemAppModel("Awesome Cricket Games", "Enjoy seasonal clones and updates", R.drawable.card_image_1, "1/4"));
            mArrayList.add(new PopularItemAppModel("World Heath Day", "Discover clones for a healthy life", R.drawable.card_image_2, "2/4"));
            mArrayList.add(new PopularItemAppModel("Flat 50% off on clones", "Life stories of clone legends", R.drawable.card_image_3, "3/4"));
            mArrayList.add(new PopularItemAppModel("Clone on Big Screen", "Clones about the sport and players", R.drawable.card_image_4, "4/4"));
        }

        return mArrayList;
    }

    class NormalViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_card_header;
        private final TextView tv_card_sub_header;
        private final TextView btn_more;
        private final RecyclerView main_item_app_recycler_view;


        NormalViewHolder(View view) {
            super(view);

            tv_card_header = view.findViewById(R.id.header);
            tv_card_sub_header = view.findViewById(R.id.sub_header);
            btn_more = view.findViewById(R.id.more);
            main_item_app_recycler_view = view.findViewById(R.id.main_item_app_recycler_view);
        }
    }

    class PopularViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerView popular_item_app_recycler_view;

        PopularViewHolder(View view) {
            super(view);
            popular_item_app_recycler_view = view.findViewById(R.id.popular_item_app_recycler_view);
        }
    }

    @Override
    public int getItemViewType(int position) {

        switch (mArrayList.get(position).getType()) {
            case "special":
                return 1;
            case "normal":
                return 2;
            default:
                return -1;
        }
    }
}

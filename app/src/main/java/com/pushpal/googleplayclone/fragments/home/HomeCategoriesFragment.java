package com.pushpal.googleplayclone.fragments.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pushpal.googleplayclone.R;
import com.pushpal.googleplayclone.adapters.AllCategoryItemAppAdapter;
import com.pushpal.googleplayclone.adapters.TopCategoryItemAppAdapter;
import com.pushpal.googleplayclone.models.AllCategoryItemAppModel;
import com.pushpal.googleplayclone.models.TopCategoryItemAppModel;

import java.util.ArrayList;

public class HomeCategoriesFragment extends Fragment {

    private View view;
    private RecyclerView topCategoriesRecyclerView, allCategoriesRecyclerView;
    private ArrayList<TopCategoryItemAppModel> topCategoryItemAppModelsList;
    private ArrayList<AllCategoryItemAppModel> allCategoryItemAppModelsList;

    public HomeCategoriesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_categories, container, false);
        configureRecyclerViews();

        return view;
    }

    private void configureRecyclerViews() {
        topCategoriesRecyclerView = view.findViewById(R.id.rv_top_categories);
        topCategoriesRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        topCategoriesRecyclerView.setLayoutManager(horizontalLayoutManager);

        allCategoriesRecyclerView = view.findViewById(R.id.rv_all_categories);
        allCategoriesRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager verticalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        allCategoriesRecyclerView.setLayoutManager(verticalLayoutManager);

        loadDataAndSetAdapter();
    }

    private void loadDataAndSetAdapter() {
        topCategoryItemAppModelsList = new ArrayList<>();
        topCategoryItemAppModelsList.add(new TopCategoryItemAppModel("Photography", R.drawable.camera));
        topCategoryItemAppModelsList.add(new TopCategoryItemAppModel("Family", R.drawable.family));
        topCategoryItemAppModelsList.add(new TopCategoryItemAppModel("Airtel", R.drawable.access_point_network));
        topCategoryItemAppModelsList.add(new TopCategoryItemAppModel("Music & Audio", R.drawable.music));
        topCategoryItemAppModelsList.add(new TopCategoryItemAppModel("Entertainment", R.drawable.gamepad));

        topCategoriesRecyclerView.setAdapter(new TopCategoryItemAppAdapter(topCategoryItemAppModelsList));

        allCategoryItemAppModelsList = new ArrayList<>();
        allCategoryItemAppModelsList.add(new AllCategoryItemAppModel("Art & Design", R.drawable.brush));
        allCategoryItemAppModelsList.add(new AllCategoryItemAppModel("Auto & Vehicles", R.drawable.car));
        allCategoryItemAppModelsList.add(new AllCategoryItemAppModel("Beauty", R.drawable.spotlight_beam));
        allCategoryItemAppModelsList.add(new AllCategoryItemAppModel("Books & Reference", R.drawable.book_open));
        allCategoryItemAppModelsList.add(new AllCategoryItemAppModel("Business", R.drawable.domain));
        allCategoryItemAppModelsList.add(new AllCategoryItemAppModel("Comics", R.drawable.thought_bubble));
        allCategoryItemAppModelsList.add(new AllCategoryItemAppModel("Communication", R.drawable.forum));
        allCategoryItemAppModelsList.add(new AllCategoryItemAppModel("Dating", R.drawable.clover));
        allCategoryItemAppModelsList.add(new AllCategoryItemAppModel("Education", R.drawable.mailbox));
        allCategoryItemAppModelsList.add(new AllCategoryItemAppModel("Entertainment", R.drawable.gamepad));

        allCategoriesRecyclerView.setAdapter(new AllCategoryItemAppAdapter(allCategoryItemAppModelsList));
    }
}

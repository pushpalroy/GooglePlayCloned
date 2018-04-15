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
import com.pushpal.googleplayclone.adapters.HomeItemAdapter;
import com.pushpal.googleplayclone.models.HomeItemModel;

import java.util.ArrayList;

public class HomeForYouFragment extends Fragment {

    private View view;
    private RecyclerView mainRecyclerView;

    public HomeForYouFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_for_you, container, false);
        configureMainRecyclerView();

        return view;
    }

    private void configureMainRecyclerView() {
        mainRecyclerView = view.findViewById(R.id.for_you_recycler_view);
        mainRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mainRecyclerView.setLayoutManager(layoutManager);

        loadMainItemsData();
    }

    private void loadMainItemsData() {

        ArrayList<HomeItemModel> mArrayList = new ArrayList<>();

        if (getActivity() != null) {
            mArrayList.add(new HomeItemModel("", "", "special"));
            mArrayList.add(new HomeItemModel("New + Updated Games", "Selected games of the week", "normal"));
            mArrayList.add(new HomeItemModel("Recommended for you", "", "normal"));
            mArrayList.add(new HomeItemModel("Get Stuff Done", "", "normal"));
        }

        HomeItemAdapter homeItemAdapter = new HomeItemAdapter(mArrayList, getContext());
        mainRecyclerView.setAdapter(homeItemAdapter);

    }
}

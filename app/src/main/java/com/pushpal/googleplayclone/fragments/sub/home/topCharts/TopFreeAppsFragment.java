package com.pushpal.googleplayclone.fragments.sub.home.topCharts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pushpal.googleplayclone.R;
import com.pushpal.googleplayclone.adapters.TopFreeAppsAdapter;
import com.pushpal.googleplayclone.models.TopFreeAppModel;

import java.util.ArrayList;
import java.util.Objects;

public class TopFreeAppsFragment extends Fragment {

    View view;
    private RecyclerView mRecyclerView;

    public TopFreeAppsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_top_free_apps, container, false);
        configureMainRecyclerView();

        return view;
    }

    private void configureMainRecyclerView() {
        mRecyclerView = view.findViewById(R.id.rv_top_app_list);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration divider = new
                DividerItemDecoration(mRecyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        divider.setDrawable(Objects.requireNonNull(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()).getBaseContext(),
                R.drawable.line_divider)));
        mRecyclerView.addItemDecoration(divider);

        loadAdapterData();
    }

    private void loadAdapterData() {

        ArrayList<TopFreeAppModel> mArrayList = new ArrayList<>();

        if (getActivity() != null) {
            mArrayList.add(new TopFreeAppModel("Vigo Video - Formerly Hypstar", "BYTEMOD PTE.LTD.", "46 MB", "4.2"));
            mArrayList.add(new TopFreeAppModel("MyJio", "Reliance Industries Ltd.", "20 MB", "EDITOR'S CHOICE"));
            mArrayList.add(new TopFreeAppModel("Hotstar", "Novi Digital", "26 MB", "4.2"));
            mArrayList.add(new TopFreeAppModel("UC Browser - Fast Download  Private & Secure", "UCWeb Inc.", "37 MB", "4.5"));
            mArrayList.add(new TopFreeAppModel("Facebook Lite", "Facebook", "1.6 MB", "4.3"));
            mArrayList.add(new TopFreeAppModel("Cricbuzz - Live Cricket Scores & News", "Cricbuzz.com", "5.3 MB", "EDITOR'S CHOICE"));
            mArrayList.add(new TopFreeAppModel("MX Player", "J2 Interactive", "12 MB", "4.2"));
            mArrayList.add(new TopFreeAppModel("musical.ly", "musical.ly", "39 MB", "4.4"));
            mArrayList.add(new TopFreeAppModel("Xender - File Transfer & Share", "Xender Team", "6.8 MB", "4.4"));
        }

        TopFreeAppsAdapter topFreeAppsAdapter = new TopFreeAppsAdapter(mArrayList);
        mRecyclerView.setAdapter(topFreeAppsAdapter);
    }
}

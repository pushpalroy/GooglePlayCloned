package com.pushpal.googleplayclone.fragments.home.topCharts;

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

    private View view;
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
            mArrayList.add(new TopFreeAppModel("Udacity - Lifelong Learning", "Udacity, Inc.", "28 MB", "4.3", R.drawable.ic_udacity));
            mArrayList.add(new TopFreeAppModel("Gmail", "Google LLC", "20 MB", "EDITOR'S CHOICE", R.drawable.logo_gmail));
            mArrayList.add(new TopFreeAppModel("Slack", "Slack Technologies Inc.", "26 MB", "4.4", R.drawable.logo_slack));
            mArrayList.add(new TopFreeAppModel("LinkedIn", "LinkedIn", "37 MB", "4.2", R.drawable.logo_linkedin));
            mArrayList.add(new TopFreeAppModel("Microsoft To-Do", "Microsoft Corporation", "9.9 MB", "4.0", R.drawable.logo_to_do));
            mArrayList.add(new TopFreeAppModel("WhatsApp Messenger", "WhatsApp Inc.", "5.3 MB", "EDITOR'S CHOICE", R.drawable.logo_whatsapp));
            mArrayList.add(new TopFreeAppModel("Facebook", "Facebook", "12 MB", "4.1", R.drawable.logo_facebook));
            mArrayList.add(new TopFreeAppModel("Twitter", "Twitter, Inc", "39 MB", "4.3", R.drawable.logo_twitter));
            mArrayList.add(new TopFreeAppModel("Code Monk", "Hacker Earth", "6.8 MB", "4.3", R.drawable.logo_code_monk));
        }

        TopFreeAppsAdapter topFreeAppsAdapter = new TopFreeAppsAdapter(mArrayList);
        mRecyclerView.setAdapter(topFreeAppsAdapter);
    }
}

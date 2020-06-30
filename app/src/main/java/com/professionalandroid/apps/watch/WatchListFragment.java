package com.professionalandroid.apps.watch;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class WatchListFragment extends Fragment {

    private ArrayList<Watch> mWatches =
            new ArrayList<Watch>();

    public WatchListFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private RecyclerView mRecyclerView;
    private WatchRecyclerViewAdapter mWatchAdapter = new WatchRecyclerViewAdapter(mWatches);
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_watch_list, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.list);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Context context = view.getContext();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.setAdapter(mWatchAdapter);
    }

    public void setWatches(List<Watch> watches) {
        for (Watch watch: watches) {
            if (!mWatches.contains(watch)) {
                mWatches.add(watch);
                mWatchAdapter.notifyItemInserted(mWatches.indexOf(watch));
            }
        }
    }
}

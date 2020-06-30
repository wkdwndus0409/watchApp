package com.professionalandroid.apps.watch;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WatchMainActivity extends AppCompatActivity {

    private static final String TAG_LIST_FRAGMENT = "TAG_LIST_FRAGMENT";

    WatchListFragment mWatchListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_main);

        FragmentManager fm = getSupportFragmentManager();

        if (savedInstanceState == null) {
            FragmentTransaction ft = fm.beginTransaction();

            mWatchListFragment = new WatchListFragment();
            ft.add(R.id.main_activity_frame, mWatchListFragment, TAG_LIST_FRAGMENT);
            ft.commitNow();
        } else {
            mWatchListFragment = (WatchListFragment)fm.findFragmentByTag(TAG_LIST_FRAGMENT);
        }

        Date now = Calendar.getInstance().getTime();
        List<Watch> dummyWatches = new ArrayList<Watch>(0);
        dummyWatches.add(new Watch("0", now, "Korea", null, null));

        mWatchListFragment.setWatches(dummyWatches);
    }
}
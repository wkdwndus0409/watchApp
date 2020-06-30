package com.professionalandroid.apps.watch;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WatchRecyclerViewAdapter extends
        RecyclerView.Adapter<WatchRecyclerViewAdapter.ViewHolder> {

    private final List<Watch> mWatches;

    public WatchRecyclerViewAdapter(List<Watch> watches) {
        mWatches = watches;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_watch, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.watch = mWatches.get(position);
        holder.detailsView.setText(mWatches.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return mWatches.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View parentView;
        public final TextView detailsView;
        public Watch watch;

        public ViewHolder(View view) {
            super(view);
            parentView = view;
            detailsView = (TextView)view.findViewById(R.id.list_item_watch_details);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + detailsView.getText() + "'";
        }
    }

}

package com.ryanpotsander.mymaterialresume;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 11/17/16.
 */

public class ProjectFragment extends Fragment {

    private ProjectsRecyclerAdapter mAdapter;

    public ProjectFragment() {}

    public static ProjectFragment newInstance() {
        return new ProjectFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_projects, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.projects_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new ItemDecoration(32));
        mAdapter = new ProjectsRecyclerAdapter();
        recyclerView.setAdapter(mAdapter);

        return view;
    }

    public class Item {
        //TODO finish

        public String label;
    }

    public class ProjectsRecyclerAdapter extends RecyclerView.Adapter<ProjectsRecyclerAdapter.ViewHolder>{

        List<Item> mData;

        public ProjectsRecyclerAdapter() {
            populateData();
        }

        public void populateData() {
            if (mData == null) mData = new ArrayList<>();

            List<String> labels = new ArrayList<>();
            labels.add("Kung Fu Training App");
            labels.add("Voice Share App");
            labels.add("Chi Sau Me");
            labels.add("The Vapor Shop");

            for (int i = 0; i < labels.size(); i++) {
                Item item = new Item();
                item.label = labels.get(i);
                mData.add(item);
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.labelView.setText(mData.get(position).label);
        }

        @Override
        public int getItemCount() {
            if (mData == null) return 0;

            return mData.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            TextView labelView;

            public ViewHolder(View itemView) {
                super(itemView);

                labelView = (TextView) itemView.findViewById(R.id.project_item_title);
            }
        }

    }

    class ItemDecoration extends RecyclerView.ItemDecoration {
        private int mSpace;

        public ItemDecoration(int space) {
            mSpace = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            if (parent.getChildLayoutPosition(view) == 0) outRect.top = mSpace;

            outRect.bottom = mSpace;
            outRect.left = mSpace;
            outRect.right = mSpace;
        }
    }
}

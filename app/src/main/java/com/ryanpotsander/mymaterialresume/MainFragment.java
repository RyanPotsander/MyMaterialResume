package com.ryanpotsander.mymaterialresume;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.MenuPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 11/18/16.
 */

public class MainFragment extends Fragment{

    public MainFragment(){}

    public static MainFragment newInstance(int sectionId) {
       return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        RecyclerView skillsRecycler = (RecyclerView) view.findViewById(R.id.recycler_skills);
        skillsRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        skillsRecycler.setAdapter(new SkillsAdapter());

        RecyclerView employmentRecycler = (RecyclerView) view.findViewById(R.id.recycler_employment);
        employmentRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        employmentRecycler.setAdapter(new EmploymentAdapter());

        return view;
    }

    public class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.ViewHolder> {

        private List<String> mData;

        public SkillsAdapter() {
            populateData();
        }

        private void populateData() {
            if (mData == null) mData = new ArrayList<>();

            mData.add("Java");
            mData.add("Android SDK");
            mData.add("Android Studio");
            mData.add("SQLite");
            mData.add("Google App Engine");
            mData.add("Firebase");
            mData.add("Material Spec");
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_skills, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.skillTextView.setText(mData.get(position));
        }

        @Override
        public int getItemCount() {
            if (mData == null) return 0;
            return mData.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView skillTextView;

            public ViewHolder(View itemView) {
                super(itemView);

                skillTextView = (TextView) itemView.findViewById(R.id.skill_text);
            }
        }
    }

    public class EmploymentItem {
        String employer, date, details;

        public EmploymentItem(String employer, String date, String details) {
            this.employer = employer;
            this.date = date;
            this.details = details;
        }
    }

    public class EmploymentAdapter extends RecyclerView.Adapter<EmploymentAdapter.ViewHolder> {

        private List<EmploymentItem> mData;

        public EmploymentAdapter() {
            populateData();
        }

        private void populateData() {
            if (mData == null) mData = new ArrayList<>();
            mData.add(new EmploymentItem(
                    "Support.com, Redwood City, CA (Remote) — Solutions Engineer",
                    "Fall 2015 - Summer 2016",
                    "Solved software problems on Windows and OSX systems. Typical issues included malware infection, Windows registry issues, folder permission issues, ….. "));
            mData.add(new EmploymentItem("Support.com, Redwood City, CA (Remote) — Solutions Engineer",
                    "Summer 2013 - Winter 2014",
                    "Assisted residential ISP customers with home network configurations. Solved connection problems not related to ISP service (configuration)."));
            mData.add(new EmploymentItem(
                    "Mercedes Benz, Multiple Locations — Assistant Service Manager",
                    "Summer 2006 - Winter 2012",
                    "Abstracted data from technical repair documentation to locate and assign operation/damage codes fully describing repair operations and cause of failure for electronic transmission to manufacturer \n" +
                            "Interpreted client repair complaints to efficiently communicate issues to the shop"
            ));
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employment, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            EmploymentItem item = mData.get(position);
            holder.nameView.setText(item.employer);
            holder.dateView.setText(item.date);
            holder.detailView.setText(item.details);
        }

        @Override
        public int getItemCount() {
            if (mData == null) return 0;
            return mData.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView nameView, dateView, detailView;

            public ViewHolder(View itemView) {
                super(itemView);

                nameView = (TextView) itemView.findViewById(R.id.employment_item_name);
                dateView = (TextView) itemView.findViewById(R.id.employment_item_date);
                detailView = (TextView) itemView.findViewById(R.id.employment_item_detail);

            }
        }
    }

}

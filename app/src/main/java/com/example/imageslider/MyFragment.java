package com.example.imageslider;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 규열 on 2018-02-08.
 */

public class MyFragment extends Fragment {

    RecyclerView recyclerView;
    PagerSnapHelper pagerSnapHelper;
    LinearLayoutManager layoutManager;
    Handler handler;
    Runnable runnable;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.slide_recyclerview);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        pagerSnapHelper = new PagerSnapHelper();
        if(handler == null) {
            handler = new Handler();
            runnable = new Runnable() {
                @Override
                public void run() {
                    if (layoutManager.findFirstVisibleItemPosition() != 2) {
                        recyclerView.smoothScrollToPosition(layoutManager.findFirstVisibleItemPosition() + 1);
                    } else {
                        recyclerView.smoothScrollToPosition(0);
                    }
                    handler.postDelayed(this, 3000);
                }
            };
        }
        handler.postDelayed(runnable, 3000);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerViewAdapter(getContext()));
        pagerSnapHelper.attachToRecyclerView(recyclerView);
        return view;
    }

}

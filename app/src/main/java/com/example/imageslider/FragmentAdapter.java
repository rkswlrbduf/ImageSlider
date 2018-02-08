package com.example.imageslider;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by 규열 on 2018-02-08.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public FragmentAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                return new MyFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

}

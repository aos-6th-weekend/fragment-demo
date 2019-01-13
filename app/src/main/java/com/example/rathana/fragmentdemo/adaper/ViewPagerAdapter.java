package com.example.rathana.fragmentdemo.adaper;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragments;
    String[] tabTitles;
    public ViewPagerAdapter(FragmentManager fm,List<Fragment> fragments,String[] tabTitles) {
        super(fm);
        this.fragments=fragments;
        this.tabTitles=tabTitles;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}

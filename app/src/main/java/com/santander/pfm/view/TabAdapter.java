package com.santander.pfm.view;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.santander.pfm.view.fragments.MainFragment;

import java.util.ArrayList;

public class TabAdapter extends FragmentPagerAdapter {

    private ArrayList<String> titles;
    private ArrayList<Fragment> arrayList = new ArrayList<>();

    public TabAdapter(Context ctx, FragmentManager fm, ArrayList<String> arrayMonths) {
        super(fm);
        titles = arrayMonths;

        /*
        arrayList.add(MonthFragment.newInstance());
        arrayList.add(HistoricFragment.newInstance());

        */

        arrayList.add(MainFragment.newInstance());

    }

    @Override
    public Fragment getItem(int position) {
        return MainFragment.newInstance();
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }


}
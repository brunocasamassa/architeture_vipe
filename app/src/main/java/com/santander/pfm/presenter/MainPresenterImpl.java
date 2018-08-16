package com.santander.pfm.presenter;

import com.santander.pfm.model.Datum;
import com.santander.pfm.view.activity.MainActivity;
import com.santander.pfm.view.activity.MainView;

public class MainPresenterImpl implements MainPresenter {

    private MainView mainActivity;


    public MainPresenterImpl(MainView mainActivity) {
        this.mainActivity = mainActivity;


    }

    public void onResume() {
       // this.mainActivity.setChartView(new Datum());
    }


    @Override
    public void setMonthClick(String s) {
    }

}

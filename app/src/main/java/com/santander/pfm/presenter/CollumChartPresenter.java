package com.santander.pfm.presenter;

import android.support.v7.widget.CardView;

import com.santander.pfm.interactor.CollumChartInteractor;
import com.santander.pfm.interactor.HistoricInteractor;
import com.santander.pfm.view.activity.CollumChartView;
import com.santander.pfm.view.fragments.HistoricView;

public interface CollumChartPresenter {

    void setView(CollumChartView view);

    void setInteractor(CollumChartInteractor interacator);



}

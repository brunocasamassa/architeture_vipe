package com.santander.pfm.interactor;

import android.view.View;

import com.santander.pfm.ColumnChartModule;
import com.santander.pfm.model.Data;
import com.santander.pfm.model.Datum;
import com.santander.pfm.presenter.ColumnChartPresenter;

public class ColumnChartInteractor implements ColumnChartModule.Interactor, View.OnClickListener {

    private ColumnChartModule.View view;
    private ColumnChartModule.Presenter presenter;
    private String TAG = "CollumChartInteractorImpl_DEBUG";

    @Override
    public void setView(ColumnChartModule.View view) {
        this.view = view;
        //presenter.getCallbackResponse();

    }

    @Override
    public void setPresenter(ColumnChartModule.Presenter presenter) {
        presenter = new ColumnChartPresenter(new Datum());
        presenter.setView(view);

    }

    @Override
    public void onClick(View v) {

    }

}


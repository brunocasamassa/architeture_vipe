package com.santander.pfm.presenter;

import android.support.v7.widget.CardView;
import android.view.View;
import com.santander.pfm.interactor.HistoricInteractor;
import com.santander.pfm.view.fragments.HistoricView;

public class HistoricPresenterImpl implements HistoricPresenter, View.OnClickListener {

    private HistoricView view;
    private HistoricInteractor interactor;

    private CardView results;
    private CardView receipts;
    private CardView spending;


    @Override
    public void onClick(View v) {
        if (v == results) {
            view.selectGraphButton(1);
        } else if (v == receipts) {
            view.selectGraphButton(2);
        } else if (v == spending) {
            view.selectGraphButton(3);
        }
    }


    @Override
    public void setInteractor(HistoricInteractor interactor) {
        this.interactor = interactor;
    }


    @Override
    public void onResultClicked() {

    }

    @Override
    public void setView(HistoricView view) {
        this.view = view;
    }

    @Override
    public void selectGraphButton(CardView results, CardView receipts, CardView spending) {
        this.receipts = receipts;
        this.results = results;
        this.spending = spending;
        results.setOnClickListener(this);
        spending.setOnClickListener(this);
        receipts.setOnClickListener(this);
    }
}

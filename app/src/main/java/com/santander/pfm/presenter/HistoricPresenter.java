package com.santander.pfm.presenter;

import android.support.v7.widget.CardView;
import android.view.View;

import com.santander.pfm.interactor.HistoricInteractor;
import com.santander.pfm.view.fragments.HistoricView;

public interface HistoricPresenter {

    void onResultClicked();

    void setView(HistoricView view);

    void setInteractor(HistoricInteractor interacator);

    void selectGraphButton(CardView results, CardView receipts, CardView spending);

}

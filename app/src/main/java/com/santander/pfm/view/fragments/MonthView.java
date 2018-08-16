package com.santander.pfm.view.fragments;

import com.santander.pfm.model.AlertModel;

public interface MonthView {

    void setTargetMonth(String month);

    void showAlert(boolean isShown, AlertModel alertModel);

    void updateListRecycler();

    void selectGraphButton(int button);

    void updateItemRecycler(int posicao);

    void setFundName(String fundName);

    void setDefinition(String definition);

}

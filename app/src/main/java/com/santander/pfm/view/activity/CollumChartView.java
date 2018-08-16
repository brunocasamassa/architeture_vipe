package com.santander.pfm.view.activity;

import android.content.Context;

import com.santander.pfm.model.AlertModel;

public interface CollumChartView {


    void setFullValueReceivesCollum(String value, int valueSize);

    void setExtrasValueReceives(String value, int valueSize);

    void setRealizedValueReceives(String value, int valueSize);

    void setFullValueCostsCollum(String value, int valueSize);

    void setExtrasValueCosts(String value, int valueSize);

    void setFullRealizedValueCostBlock(String value, int valueSize);

    void setFullRealizedValueCostScheduled(String value, int valueSize);

    void setFullRealizedValueCostActual(String value, int valueSize);

    void showAlert(boolean isShown, AlertModel alertModel);

    Context getViewContext();

    void setFundName(String fundName);


}

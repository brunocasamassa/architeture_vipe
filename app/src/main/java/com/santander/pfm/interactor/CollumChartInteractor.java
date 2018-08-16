package com.santander.pfm.interactor;

import com.santander.pfm.presenter.CollumChartPresenter;
import com.santander.pfm.presenter.HistoricPresenter;
import com.santander.pfm.view.activity.CollumChartView;
import com.santander.pfm.view.fragments.HistoricFragment;
import com.santander.pfm.view.fragments.HistoricView;

public interface CollumChartInteractor {

    void setView( CollumChartView view);

    void setPresenter( CollumChartPresenter presenter);
    
}

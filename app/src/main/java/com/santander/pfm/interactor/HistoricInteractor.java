package com.santander.pfm.interactor;

import com.santander.pfm.presenter.HistoricPresenter;
import com.santander.pfm.view.fragments.HistoricFragment;
import com.santander.pfm.view.fragments.HistoricView;

public interface HistoricInteractor {

    void setView(HistoricPresenter presenter, HistoricView view);

    void getResponse(HistoricFragment historicFragment);

}

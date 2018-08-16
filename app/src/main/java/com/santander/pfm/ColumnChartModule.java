package com.santander.pfm;

import android.content.Context;

import com.santander.pfm.model.AlertModel;
import com.santander.pfm.presenter.CollumChartPresenter;
import com.santander.pfm.view.activity.CollumChartView;

public interface ColumnChartModule {

    interface Interactor {

        void setView(View view);

        void setPresenter(Presenter presenter);
    }

    interface Presenter {
        void setView(View view);

        void setInteractor(Interactor interacator);
    }

    interface View {
        void setFullValueReceivesColumn(String value, int valueSize);

        void setExtrasValueReceives(String value, int valueSize);

        void setRealizedValueReceives(String value, int valueSize);

        void setFullValueCostsColumn(String value, int valueSize);

        void setExtrasValueCosts(String value, int valueSize);

        void setFullRealizedValueCostBlock(String value, int valueSize);

        void setFullRealizedValueCostScheduled(String value, int valueSize);

        void setFullRealizedValueCostActual(String value, int valueSize);

        void showAlert(boolean isShown, AlertModel alertModel);

        Context getViewContext();

        void setFundName(String fundName);
    }
}

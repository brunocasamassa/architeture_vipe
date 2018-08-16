package com.santander.pfm.presenter;

import android.util.Log;

import com.santander.pfm.ColumnChartModule;
import com.santander.pfm.R;
import com.santander.pfm.model.Datum;

public class ColumnChartPresenter implements ColumnChartModule.Presenter {

    private ColumnChartModule.View view;
    private ColumnChartModule.Interactor interactor;
    private String TAG = "CollumChartInteractorImpl_DEBUG";
    private String totalReceives;
    private String alreadyReceive;

    private String totalCosts;
    private String scheduledCosts;
    private String currentlyCosts;

    public ColumnChartPresenter(Datum data) {
        if (data.getIncomes() != null) {
            this.totalReceives = data.getIncomes().getTotal();
            this.alreadyReceive = data.getIncomes().getCurrent();
        }

        if (data.getOutcomes() != null) {
            this.totalCosts = data.getOutcomes().getTotal();
            this.scheduledCosts = data.getOutcomes().getScheduled();
            this.currentlyCosts = data.getOutcomes().getCurrent();
        }
    }


    @Override
    public void setView(ColumnChartModule.View view) {
        this.view = view;

        if (totalReceives == null) {

            totalReceives = "R$ 25.560,00";
            alreadyReceive = "R$ 18.000,00";

            totalCosts = "R$ 18.500,98";
            scheduledCosts = "R$ 591,00";
            currentlyCosts = "R$ 9.709,00";
        }

        view.showAlert(false, null);

        int fullCollumCostHeight = getFullCollumHeight(concateStringValue(totalCosts), concateStringValue(totalReceives), 0);
        int fullCollumReceiveHeight = getFullCollumHeight(concateStringValue(totalCosts), concateStringValue(totalReceives), 1);

        int fullRealizedCostBlockHeight = getViewHeight(concateStringValue(scheduledCosts) + concateStringValue(currentlyCosts), fullCollumCostHeight, concateStringValue(totalCosts), 0);
        int fullRealizedCostBlockValue = concateStringValue(scheduledCosts) + concateStringValue(currentlyCosts);

        int fullRealizedReceiveheight = getViewHeight(concateStringValue(alreadyReceive), fullCollumReceiveHeight, concateStringValue(totalReceives), 0);

        view.setFullValueCostsColumn(totalCosts, fullCollumCostHeight);
        view.setFullValueReceivesColumn(totalReceives, fullCollumReceiveHeight);

        view.setFullRealizedValueCostBlock("R$ " + String.valueOf(fullRealizedCostBlockValue), fullRealizedCostBlockHeight);
        view.setFullRealizedValueCostActual(currentlyCosts, getViewHeight(concateStringValue(currentlyCosts), fullRealizedCostBlockHeight, fullRealizedCostBlockValue, 0));
        view.setFullRealizedValueCostScheduled(scheduledCosts, getViewHeight(concateStringValue(scheduledCosts), fullRealizedCostBlockHeight, fullRealizedCostBlockValue, 0));

        view.setRealizedValueReceives(alreadyReceive, fullRealizedReceiveheight);

        view.setExtrasValueCosts(totalCosts, getViewHeight(concateStringValue(totalCosts) - (concateStringValue(scheduledCosts) + concateStringValue(currentlyCosts)), fullCollumCostHeight, concateStringValue(totalCosts), fullRealizedCostBlockHeight));
        view.setExtrasValueReceives(totalReceives, getViewHeight(concateStringValue(totalReceives) - concateStringValue(alreadyReceive), fullCollumReceiveHeight, concateStringValue(totalReceives), fullRealizedReceiveheight));


    }

    //PATTERN "R$ X.XXX,XX"
    private int concateStringValue(String totalCosts) {
        int value = 0;
        String preConcated = totalCosts.contains("$") ? totalCosts.split(" ")[1] : totalCosts;

        try {

            Log.d(TAG, String.valueOf(preConcated));

            value = Integer.valueOf(String.valueOf(preConcated.replace(".", "").split(",")[0]));
            Log.d(TAG, String.valueOf(value));

            return value;
        } catch (NumberFormatException n) {
            Log.d(TAG, n.getMessage().toString());
            value = Integer.valueOf(String.valueOf(preConcated.replace(".", "").substring(0, preConcated.length() - 4).split(".")[0]));
            return value;
        } catch (Exception e) {
            Log.d(TAG, e.getMessage().toString());
        }

        return 0;
    }

    private int getFullCollumHeight(int totalCosts, int totalReceives, int triggerReceiveCosts) {
        int maxHeight = 0;
        int minHeight = 0;
        int proportionalHeight = 0;

        try {

            maxHeight = (int) (view.getViewContext().getResources().getDimension(R.dimen.collum_chart_max_height) / view.getViewContext().getResources().getDisplayMetrics().density);
            minHeight = (int) (view.getViewContext().getResources().getDimension(R.dimen.collum_chart_min_height) / view.getViewContext().getResources().getDisplayMetrics().density);
            Log.d(TAG, String.format("MAX_HEIGHT %d", maxHeight));

            if (totalCosts <= totalReceives) {
                proportionalHeight = getViewHeight(totalCosts, maxHeight, totalReceives, 0);
                if (triggerReceiveCosts == 0) {
                    return (proportionalHeight >= minHeight ? proportionalHeight : minHeight);
                } else {
                    return maxHeight;
                }

            } else {
                proportionalHeight = getViewHeight(totalReceives, maxHeight, totalCosts, 0);
                if (triggerReceiveCosts == 1) {
                    return (proportionalHeight >= minHeight ? proportionalHeight : minHeight);
                } else {
                    return maxHeight;
                }

            }


        } catch (Exception e) {
            Log.d(TAG, String.valueOf(e.getMessage()));

        }

        return maxHeight;
    }

    //viewHeight = viewValue * externalCollumHeight / externalCollumValue
    private int getViewHeight(int elementValue, int collumHeight, int collumValue, int anchorSize) {

        int minViewHeight = (int) (view.getViewContext().getResources().getDimension(R.dimen.collum_chart_view_min_height) / view.getViewContext().getResources().getDisplayMetrics().density);
        int viewHeight = ((elementValue * collumHeight) / collumValue);

        //if viewHeight is smaller than the minViewHeight
        if (anchorSize > collumHeight - minViewHeight) {
            return collumHeight - anchorSize;
        } else
            return (viewHeight > minViewHeight ? viewHeight : (viewHeight < minViewHeight ? viewHeight : minViewHeight));

    }

    @Override
    public void setInteractor(ColumnChartModule.Interactor interactor) {
        this.interactor = interactor;

    }


}
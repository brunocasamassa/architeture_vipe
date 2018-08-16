package com.santander.pfm.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.santander.pfm.ColumnChartModule;
import com.santander.pfm.R;
import com.santander.pfm.interactor.ColumnChartInteractor;
import com.santander.pfm.model.AlertModel;
import com.santander.pfm.model.Data;
import com.santander.pfm.model.Datum;
import com.santander.pfm.presenter.ColumnChartPresenter;

public class CollumChart extends LinearLayout implements ColumnChartModule.View , View.OnClickListener{

    private LinearLayout fullValueCostsSize;
    private LinearLayout fullValueReceivesSize;
    private TextView extrasValueReceiveText;
    private TextView extrasValueCostsText;
    private TextView realizedValueReceiveText;
    private TextView receivesText;
    private TextView costsText;
    private TextView realizedValueCostsScheduledText;
    private TextView realizedValueCostsActualText;
    private ColumnChartModule.Presenter presenter;
    private LinearLayout realizedValueCostsFullText;
    private ColumnChartModule.Interactor interactor;
    private String TAG = "CollumChart_DEBUG";

    private SpannableString ss1;

    public CollumChart(Context context) {
        super(context);

        findViewById();
    }

    public CollumChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        findViewById();
    }

    public CollumChart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        findViewById();
    }

    /*
    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);

    }*/


    private void findViewById() {

        //GASTOS
        fullValueCostsSize = (LinearLayout) findViewById(R.id.full_value_costs);
        extrasValueCostsText = (TextView) findViewById(R.id.extras_costs);
        realizedValueCostsFullText = (LinearLayout) findViewById(R.id.realized_costs);
        realizedValueCostsScheduledText = (TextView) findViewById(R.id.realized_costs_scheduled);
        realizedValueCostsActualText = (TextView) findViewById(R.id.realized_costs_actual);
        receivesText = (TextView) findViewById(R.id.receives_text);

        //RECEBIMENTOS
        costsText = (TextView) findViewById(R.id.costs_text);
        fullValueReceivesSize = (LinearLayout) findViewById(R.id.full_value_receives);
        extrasValueReceiveText = (TextView) findViewById(R.id.extras_results);
        realizedValueReceiveText = (TextView) findViewById(R.id.realized_results);

    }

    @Override
    public void setFullValueReceivesColumn(String value, int valueSize) {
        fullValueReceivesSize.getLayoutParams().height = valueSize;

    }

    @Override
    public void setExtrasValueReceives(String value, int valueSize) {
        extrasValueReceiveText.setText(getValueTextResized(getResources().getString(R.string.extras_collum_receives_chart), value, valueSize));
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) extrasValueReceiveText.getLayoutParams();
        params.height = valueSize;
        Log.d(TAG, String.format("EXTRAS_RECEIVE_HEIGHT %d", valueSize));
        extrasValueReceiveText.setLayoutParams(params);

    }

    @Override
    public void setRealizedValueReceives(String value, int valueSize) {
        realizedValueReceiveText.setText(getValueTextResized(getResources().getString(R.string.realized_collum_receives_chart), value, valueSize));
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) realizedValueReceiveText.getLayoutParams();
        params.height = valueSize;
        Log.d(TAG, String.format("REALIZED_RECEIVE_HEIGHT %d", valueSize));
        realizedValueReceiveText.setLayoutParams(params);
    }

    @Override
    public void setFullValueCostsColumn(String value, int valueSize) {
        if (fullValueCostsSize == null) {
            Log.e("Blah", "LL nulo!!!!");
            return;
        }
        if (fullValueCostsSize.getLayoutParams() == null) {
            Log.e("Blah", "LP nulo!!!!");
            return;
        }
        fullValueCostsSize.getLayoutParams().height = valueSize;
    }

    @Override
    public void setExtrasValueCosts(String value, int valueSize) {
        extrasValueCostsText.setText(getValueTextResized(getResources().getString(R.string.extras_collum_costs_chart), value, valueSize));
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) extrasValueCostsText.getLayoutParams();
        params.height = valueSize;
        Log.d(TAG, String.format("EXTRAS_COSTS_HEIGHT %d", valueSize));
        extrasValueCostsText.setLayoutParams(params);
    }

    @Override
    public void setFullRealizedValueCostBlock(String value, int valueSize) {
        realizedValueCostsFullText.getLayoutParams().height = valueSize;
    }

    @Override
    public void setFullRealizedValueCostScheduled(String value, int valueSize) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) realizedValueCostsScheduledText.getLayoutParams();
        params.height = valueSize;

        Log.d(TAG, String.format("REALIZED_COST_SCHEDULED %d", valueSize));

        realizedValueCostsScheduledText.setLayoutParams(params);
        realizedValueCostsScheduledText.setText(getValueTextResized("  " + getResources().getString(R.string.realized_scheduled_collum_costs_chart), " " + value, valueSize));

    }

    @Override
    public void setFullRealizedValueCostActual(String value, int valueSize) {
        realizedValueCostsActualText.setText(getValueTextResized("  " + getResources().getString(R.string.realized_actual_collum_costs_chart), " " + value, valueSize));
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) realizedValueCostsActualText.getLayoutParams();
        params.height = valueSize;
        Log.d(TAG, String.format("REALIZED_COST_ACTUAL %d", valueSize));
        realizedValueCostsActualText.setLayoutParams(params);

    }

    @Override
    public void showAlert(boolean isShown, AlertModel alertModel) {

    }

    @Override
    public Context getViewContext() {
        return getContext();
    }


    @Override
    public void setFundName(String fundName) {

    }


    private SpannableString getValueTextResized(String text, String value, int valueSize) {

        int minViewHeight = (int) (getResources().getDimension(R.dimen.collum_chart_view_min_height) / getResources().getDisplayMetrics().density);
        SpannableString ss = new SpannableString(text + "\n" + value);

        Log.d(TAG, String.valueOf("REALIZED_COST_SCHEDULED" + ss.length() + ss));
        ss.setSpan(new RelativeSizeSpan(0.6f), 0, ss.length(), 0); // set size
        ss.setSpan(new RelativeSizeSpan(1.8f), ss.length() - value.length(), ss.length(), 0); // set size

        if (valueSize < minViewHeight) {
            return new SpannableString("");
        }

        return ss;
    }


    @Override
    public void onClick(View v) {

    }


    ///receive DATUM from MainActivity view -- which will receive from presenter
    public void setData(Datum data){
        findViewById();
        presenter = new ColumnChartPresenter(data);
        presenter.setView(this);

        /*interactor = new ColumnChartInteractor();
        interactor.setView(this);
        interactor.setPresenter(presenter);*/

    }
}

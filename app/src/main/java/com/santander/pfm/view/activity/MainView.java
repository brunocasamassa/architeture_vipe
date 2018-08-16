package com.santander.pfm.view.activity;

import com.santander.pfm.model.Datum;
import com.santander.pfm.view.fragments.MainFragment;


import java.util.ArrayList;

public interface MainView {

    void setMonths(ArrayList<String> month);

    void setMonthRange(String month);

    void setChartView(Datum data);




}

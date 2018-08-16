package com.santander.pfm.view.activity;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.santander.pfm.ColumnChartModule;
import com.santander.pfm.R;
import com.santander.pfm.interactor.MainInteractor;
import com.santander.pfm.interactor.MainInteractorImpl;
import com.santander.pfm.model.AlertModel;
import com.santander.pfm.model.Datum;
import com.santander.pfm.presenter.MainPresenter;
import com.santander.pfm.presenter.MainPresenterImpl;
import com.santander.pfm.view.CentralizedTabLayout;
import com.santander.pfm.view.adapters.MonthsAdapter;
import com.santander.pfm.view.fragments.HistoricFragment;
import com.santander.pfm.view.fragments.MainFragment;
import com.santander.pfm.view.fragments.MonthFragment;
import com.santander.pfm.view.fragments.MonthView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements MainView {

    public static final String EXTRA_INIT_MONTH = "initial_month";

    private MainPresenter presenter;
    private MainInteractor interactor;
    private LinearLayout mainLayout;
    private CollumChart collumChart;

    private android.support.v7.widget.Toolbar toolbar;
    private RecyclerView monthsList;
    private MonthsAdapter monthsAdapter;

    private CentralizedTabLayout stl_tabs;
    private int initialMonth = 0; // variable will be used to set initial month

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent().getExtras() != null) {
            initialMonth = getIntent().getExtras().getInt(EXTRA_INIT_MONTH, 0);
        }

        findViewById();

        interactor = new MainInteractorImpl();
        interactor.setView(this);

        presenter = new MainPresenterImpl(this);
        interactor.setPresenter(presenter);

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_left_arrow));
        toolbar.setTitle(getResources().getString(R.string.app_title));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Date currentTime = Calendar.getInstance().getTime();

    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.onResume();
    }

    private ArrayList<String> getArrayMonths(Date currentTime) {
        ArrayList<String> newMonthArrayConcated = new ArrayList<String>();

        SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
        String currentDateandTime = sdf.format(currentTime);
        Calendar cal = Calendar.getInstance();

        for (int i = 1; i < 4; i++) {
            cal.add(Calendar.MONTH, -1);
            newMonthArrayConcated.add(sdf.format(cal.getTime()));
        }

        newMonthArrayConcated.add(sdf.format(currentTime));

        cal.add(Calendar.MONTH, +1);

        newMonthArrayConcated.add(sdf.format(cal.getTime()));

        return newMonthArrayConcated;
    }

    @SuppressLint("ResourceType")
    private void findViewById() {

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);

        //monthsList = (RecyclerView) findViewById(R.id.months_list);

        mainLayout = (LinearLayout) findViewById(R.id.main_layout);

        stl_tabs = (CentralizedTabLayout) findViewById(R.id.stl_tabs);

       // View tab = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_tabs, this.stl_tabs);
        stl_tabs.addTab(stl_tabs.newTab().setText("Janeiro/18"));
        stl_tabs.addTab(stl_tabs.newTab().setText("Fevereiro/18"));
        stl_tabs.addTab(stl_tabs.newTab().setText("Março/18"));

        stl_tabs.setMinimumWidth(getResources().getDisplayMetrics().widthPixels / 3);
        stl_tabs.setTabMode(TabLayout.MODE_SCROLLABLE);

        collumChart = (CollumChart) findViewById(R.id.collum_chart);

    }

    @Override
    public void setMonths(ArrayList<String> months) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        monthsList.setLayoutManager(layoutManager);

        monthsAdapter = new MonthsAdapter(getApplicationContext(), months, presenter);
        monthsList.setAdapter(monthsAdapter);
    }

    @Override
    public void setMonthRange(String month) {

    }

    @Override
    public void setChartView(Datum data) {
        collumChart.setData(data);
        //LayoutInflater.from(getApplicationContext()).inflate(fragment,this);

    }

}

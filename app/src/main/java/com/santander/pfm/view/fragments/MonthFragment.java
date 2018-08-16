package com.santander.pfm.view.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.santander.pfm.R;
import com.santander.pfm.model.AlertModel;
import com.santander.pfm.presenter.MonthPresenter;
import com.santander.pfm.presenter.MonthPresenterImpl;

@SuppressLint("ValidFragment")
public class MonthFragment extends android.support.v4.app.Fragment implements MonthView {
    private MonthPresenter presenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_month, container, false);


        return v;
    }

    public static MonthFragment newInstance() {
        MonthFragment fragment = new MonthFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new MonthPresenterImpl();

    }

    @Override
    public void setTargetMonth(String month) {

    }

    @Override
    public void showAlert(boolean isShown, AlertModel alertModel) {

    }

    @Override
    public void updateListRecycler() {

    }


    @Override
    public void selectGraphButton(int button) {

    }

    @Override
    public void updateItemRecycler(int posicao) {

    }

    @Override
    public void setFundName(String fundName) {

    }

    @Override
    public void setDefinition(String definition) {

    }
}

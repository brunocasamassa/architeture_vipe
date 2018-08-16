package com.santander.pfm.view.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.santander.pfm.R;
import com.santander.pfm.model.AlertModel;

@SuppressLint("ValidFragment")
public class MainFragment extends android.support.v4.app.Fragment implements MainFragmentView {

    private NestedScrollView nes;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        View x = inflater.inflate(R.layout.item_chart_column, container, false);

        nes = (NestedScrollView) v.findViewById(R.id.main_nested_view);

        nes.addView((LinearLayout) x.findViewById(R.id.chart_layout));

/*
        presenter = new HistoricPresenterImpl();
        presenter.setView(this);
        presenter.selectGraphButton(cardButtonResults,cardButtonReceipts,cardButtonSpending);

        interactor = new HistoricInteractorImpl();
        interactor.setView(presenter, this);
*/

        return v;

    }

    @Override
    public void setTargetMonth(String month) {

    }

    @Override
    public void showAlert(boolean isShown, AlertModel alertModel) {

    }

    @Override
    public void updateListaRecycler() {

    }

    @Override
    public void selectGraphButton(int button) {

    }

 /*   @Override
    public void selectGraphButton(int button) {

        refreshButtons();

        switch (button){
            case 1: cardButtonResults.setCardElevation(getResources().getDimension(R.dimen.card_button_clicked));
                    cardButtonResultsIcon.setColorFilter(getResources().getColor(R.color.colorPrimary));
                    cardButtonResultsText.setTextColor(getResources().getColor(R.color.colorPrimary));
                    break;
            case 2: cardButtonReceipts.setCardElevation(getResources().getDimension(R.dimen.card_button_clicked));
                cardButtonReceiptsIcon.setColorFilter(getResources().getColor(R.color.colorPrimary));
                cardButtonReceiptsText.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            case 3: cardButtonSpending.setCardElevation(getResources().getDimension(R.dimen.card_button_clicked));
                cardButtonSpendingIcon.setColorFilter(getResources().getColor(R.color.colorPrimary));
                cardButtonSpendingText.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
        }
    }


    private void refreshButtons() {

        //SET ALL BUTTONS AS NOT CLICKED
        cardButtonReceipts.setCardElevation(getResources().getDimension(R.dimen.card_button_not_clicked));
        cardButtonReceiptsIcon.setColorFilter(getResources().getColor(R.color.colorBlack));
        cardButtonReceiptsText.setTextColor(getResources().getColor(R.color.colorBlack));
        cardButtonResults.setCardElevation(getResources().getDimension(R.dimen.card_button_not_clicked));
        cardButtonResultsIcon.setColorFilter(getResources().getColor(R.color.colorBlack));
        cardButtonResultsText.setTextColor(getResources().getColor(R.color.colorBlack));
        cardButtonSpending.setCardElevation(getResources().getDimension(R.dimen.card_button_not_clicked));
        cardButtonSpendingIcon.setColorFilter(getResources().getColor(R.color.colorBlack));
        cardButtonSpendingText.setTextColor(getResources().getColor(R.color.colorBlack));

    }*/

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

package com.santander.pfm.view.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.santander.pfm.R;
import com.santander.pfm.interactor.HistoricInteractor;
import com.santander.pfm.interactor.HistoricInteractorImpl;
import com.santander.pfm.model.AlertModel;
import com.santander.pfm.presenter.HistoricPresenter;
import com.santander.pfm.presenter.HistoricPresenterImpl;

@SuppressLint("ValidFragment")
public class HistoricFragment extends android.support.v4.app.Fragment implements HistoricView {

    public static HistoricFragment newInstance() {
        HistoricFragment fragment = new HistoricFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);

    }


    private HistoricInteractor interactor;
    private NestedScrollView nes;
    private HistoricPresenter presenter;
    private TextView monthStatusTag;
    private TextView cardButtonResultsText;
    private TextView cardButtonReceiptsText;
    private TextView cardButtonSpendingText;
    private ImageView cardButtonResultsIcon;
    private ImageView cardButtonReceiptsIcon;
    private ImageView cardButtonSpendingIcon;
    private CardView cardButtonResults;
    private CardView cardButtonReceipts;
    private CardView cardButtonSpending;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_historic, container, false);
        View x = inflater.inflate(R.layout.item_graphs_selector, container, false);

        monthStatusTag = x.findViewById(R.id.month_status_tag);
        cardButtonResultsText = x.findViewById(R.id.results_card_text);
        cardButtonReceiptsText = x.findViewById(R.id.receipts_card_text);
        cardButtonSpendingText = x.findViewById(R.id.spending_card_text);
        cardButtonResultsIcon = x.findViewById(R.id.results_card_icon);
        cardButtonReceiptsIcon = x.findViewById(R.id.receipts_card_icon);
        cardButtonSpendingIcon = x.findViewById(R.id.spending_card_icon);
        cardButtonResults = x.findViewById(R.id.card_button_results);
        cardButtonReceipts = x.findViewById(R.id.card_button_receipts);
        cardButtonSpending = x.findViewById(R.id.card_button_spending);

        nes = (NestedScrollView) v.findViewById(R.id.nestedHistoricView);
        nes.addView((LinearLayout) x.findViewById(R.id.historic_linear_layout));

        presenter = new HistoricPresenterImpl();
        presenter.setView(this);
        presenter.selectGraphButton(cardButtonResults,cardButtonReceipts,cardButtonSpending);

        interactor = new HistoricInteractorImpl();
        interactor.setView(presenter, this);

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

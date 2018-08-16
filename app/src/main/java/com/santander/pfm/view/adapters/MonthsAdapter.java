package com.santander.pfm.view.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.santander.pfm.R;
import com.santander.pfm.presenter.MainPresenter;

import java.util.ArrayList;

public class MonthsAdapter extends RecyclerView.Adapter<MonthHolder>{

    private Context context;
    private ArrayList<String> months;
    private MainPresenter presenter;

    public MonthsAdapter(Context c, ArrayList<String> months, MainPresenter presenter) {
        this.context = c;
        this.months = months;
        this.presenter = presenter;
    }

    @Override
    public MonthHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MonthHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tabs, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MonthHolder holder, final int position) {
        holder.monthText.setText(months.get(position));
        holder.monthText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setMonthClick(months.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

}



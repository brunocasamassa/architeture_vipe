package com.santander.pfm.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.santander.pfm.R;

public class MonthHolder extends RecyclerView.ViewHolder {

    public TextView monthText;

    public MonthHolder(View itemView) {
        super(itemView);

        monthText = (TextView) itemView.findViewById(R.id.tab_month);

    }
}

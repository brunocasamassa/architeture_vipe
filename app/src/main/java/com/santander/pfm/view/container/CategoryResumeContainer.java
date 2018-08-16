package com.santander.pfm.view.container;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.santander.pfm.R;
import com.santander.pfm.model.CategoryModel;

import java.util.ArrayList;

public class CategoryResumeContainer extends LinearLayout {

    protected LinearLayout flDetails;
    protected ToggleButton tbLeft;
    protected ToggleButton tbRight;

    public CategoryResumeContainer(Context context) {
        super(context);

        View v = LayoutInflater.from(context).inflate(R.layout.container_category_resume, this);
        findViews(v);
    }

    public CategoryResumeContainer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        View v = LayoutInflater.from(context).inflate(R.layout.container_category_resume, this);
        findViews(v);
    }

    public void setData(ArrayList<CategoryModel> categories) {
        for (int i = 0; i < categories.size(); i++) {
            View v = LayoutInflater.from(getContext()).inflate(R.layout.item_details, null);
            ((TextView) v.findViewById(R.id.tv_label)).setText(categories.get(i).getLabel());
            ((TextView) v.findViewById(R.id.tv_value)).setText(categories.get(i).getValue());
            flDetails.addView(v);
        }
    }

    public void setLeftToggle(String textOn, String textOff, CompoundButton.OnCheckedChangeListener listener) {
        tbLeft.setTextOn(textOn);
        tbLeft.setTextOff(textOff);
        tbLeft.setText(textOn);
        if (listener != null) {
            listener.onCheckedChanged(tbLeft, tbLeft.isChecked());
        }
    }

    public void setRightToggle(String textOn, String textOff, CompoundButton.OnCheckedChangeListener listener) {
        tbRight.setTextOn(textOn);
        tbRight.setTextOff(textOff);
        tbRight.setText(textOn);
        if (listener != null) {
            listener.onCheckedChanged(tbRight, tbRight.isChecked());
        }
    }

    private void findViews(View view) {
        flDetails = view.findViewById(R.id.ll_details);
        tbLeft = view.findViewById(R.id.tb_left);
        tbRight = view.findViewById(R.id.tb_right);
    }
}

package com.santander.pfm.view.activity.placeholder;

import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;

import com.santander.pfm.R;
import com.santander.pfm.model.CategoryModel;
import com.santander.pfm.view.activity.BaseActivity;
import com.santander.pfm.view.container.CategoryResumeContainer;

import java.util.ArrayList;

public class CategoryResumeActivity extends BaseActivity {

    protected CategoryResumeContainer container;
    private ArrayList<CategoryModel> categories = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.placeholder_act_category);

        int total = 0;
        for (int i = 0; i < 4; i++) {
            CategoryModel c = new CategoryModel();
            c.setLabel(String.format("Item %d", (i + 1)));
            c.setValue(String.format("R$ %d", ((i+1)*1250)));
            Log.d("Main", c.getLabel() + " " + c.getValue());
            c.setIcon("http%3A%2F%2Ficons.iconarchive.com%2Ficons%2Fsensibleworld%2Fstarwars%2F1024%2FR2D2-icon.png&imgrefurl=http%3A%2F%2Fwww.iconarchive.com%2Fshow%2Fstarwars-icons-by-sensibleworld%2FR2D2-icon.html&docid=b8t-H4biiXUfQM&tbnid=fIaSMqLTnCLRRM%3A&vet=10ahUKEwjAv7qf_5vbAhWGvZAKHRcrBhMQMwg2KAAwAA..i&w=1024&h=1024&bih=662&biw=1366&q=starwars%20icon&ved=0ahUKEwjAv7qf_5vbAhWGvZAKHRcrBhMQMwg2KAAwAA&iact=mrc&uact=8");
            total = total + (i * 1250);
            categories.add(c);
        }

        CategoryModel c_ = new CategoryModel();
        c_.setLabel("Total gasto:");
        c_.setValue(String.format("R$ %d", total));
        categories.add(c_);

        container.setLeftToggle(getString(R.string.toggle_income), getString(R.string.toggle_income), new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        container.setRightToggle(getString(R.string.toggle_spend), getString(R.string.toggle_spend), new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        container.setData(categories);
    }

    private void findViews() {
        container = findViewById(R.id.container);
    }
}

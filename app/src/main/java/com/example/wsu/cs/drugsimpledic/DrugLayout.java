package com.example.wsu.cs.drugsimpledic;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DrugLayout extends LinearLayout {
    private TextView drugLayoutName;

    public DrugLayout(Context context) {
        super(context);

        drugLayoutName = findViewById(R.id.DrugLayoutName);
    }

    void inflateName(String name){
        drugLayoutName.setText(name);
        }
}

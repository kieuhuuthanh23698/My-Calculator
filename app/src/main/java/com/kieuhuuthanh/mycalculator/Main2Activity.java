package com.kieuhuuthanh.mycalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        final ListView lv=findViewById(R.id.listview);
        Intent act2 = getIntent();
        final ArrayList<String> historycalculator = act2.getStringArrayListExtra("history");
        final ArrayAdapter<String> al= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, historycalculator);
        lv.setAdapter(al);
        Button clear = findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                historycalculator.clear();
                lv.setAdapter(al);
            }
        });
    }
}

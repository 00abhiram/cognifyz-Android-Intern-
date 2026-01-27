package com.example.task4_basic_ui_layout;

import android.os.Bundle;

import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Button btnBack=findViewById(R.id.btnBack);
        btnBack.setOnClickListener(view->{
            finish();
        });
    }
}
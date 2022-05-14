package com.example.thirdweekapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Yandex extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yandex);
        getSupportActionBar().hide();
    }
}
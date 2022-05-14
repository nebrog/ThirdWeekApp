package com.example.thirdweekapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button yandex;
    private Button telegram;
    private Button calc;
    private Button facebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        yandex = findViewById(R.id.yandex);
        telegram = findViewById(R.id.telegram);
        calc = findViewById(R.id.calc);
        facebook = findViewById(R.id.facebook);
        click();
    }
    private void click(){
        View.OnClickListener yaClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Yandex.class);
                MainActivity.this.startActivity(intent);
            }
        };
        yandex.setOnClickListener(yaClick);
        View.OnClickListener tgClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Telegram.class);
                MainActivity.this.startActivity(intent);
            }
        };
        telegram.setOnClickListener(tgClick);

        View.OnClickListener calcClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Calculator.class);
                MainActivity.this.startActivity(intent);
            }
        };
        calc.setOnClickListener(calcClick);

        View.OnClickListener fbClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Facebook.class);
                MainActivity.this.startActivity(intent);
            }
        };
        facebook.setOnClickListener(fbClick);
    }
}
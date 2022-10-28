package com.example.formregistrasi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //actionbar title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Second Activity");

        //intent to get data
        Intent intent = getIntent();
        String nama = intent.getStringExtra("NAMA");
        String tempat = intent.getStringExtra("TEMPAT");
        String tanggal = intent.getStringExtra("TANGGAL");

        //TextView
        TextView mViewResult = findViewById(R.id.ViewResult);

        //setText
        mViewResult.setText("Nama: "+nama+"\nTempat Lahir: "+tempat+"\nTanggal Lahir: "+tanggal);

    }
}
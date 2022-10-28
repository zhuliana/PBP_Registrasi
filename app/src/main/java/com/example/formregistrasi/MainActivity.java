package com.example.formregistrasi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.formregistrasi.R.id;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //actionbar title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("First Activity");

        //Custom edit text
        TextInputLayout layoutNama = findViewById(R.id.layoutNama);
        TextInputEditText mnamaTiet = findViewById(R.id.NamaTiet);
        TextInputLayout layoutTempat = findViewById(R.id.layoutTempat);
        TextInputEditText mtempatTiet = findViewById(R.id.TempatTiet);
        TextInputLayout layoutTanggal = findViewById(R.id.layoutTanggal);
        TextInputEditText mtanggalTiet = findViewById(R.id.TanggalTiet);

        //Button
        Button mSubmitBtn = findViewById(id.SubmitBtn);

        mtanggalTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                mtanggalTiet.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });



        //Button click listener
        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get data from edit text
                String nama = mnamaTiet.getText().toString();
                String tempat = mtempatTiet.getText().toString();
                String tanggal = mtanggalTiet.getText().toString();

                //activity intent
                Intent intent =new  Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("NAMA", nama);
                intent.putExtra("TEMPAT", tempat);
                intent.putExtra("TANGGAL", tanggal);
                startActivity(intent);

            }
        });
    }
}
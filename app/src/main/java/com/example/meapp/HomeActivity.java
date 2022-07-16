package com.example.meapp;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.os.Bundle;

import android.widget.TextView;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity {
    private TextView  txtNik,txtNama,txtTempat,txtDate, txtAlamat, txtGender,txtPekerjaan, txtStatus;

    void initUI() {

        txtNik = findViewById(R.id.txt_nik);
        txtNama = findViewById(R.id.txt_nama);
        txtTempat = findViewById(R.id.txt_tempat);
        txtDate = findViewById(R.id.txt_date);
        txtAlamat = findViewById(R.id.txt_alamat);
        txtGender = findViewById(R.id.txt_jk);
        txtPekerjaan = findViewById(R.id.txt_pekerjaan);
        txtStatus = findViewById(R.id.txt_status);


    }
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initUI();


        if(getIntent().getStringExtra("nik") != null){
            txtNik.setText("NIK                     :"+getIntent().getStringExtra("nik"));
        }
        if(getIntent().getStringExtra("nama") != null){
            txtNama.setText("Nama Lengkap : "+getIntent().getStringExtra("nama"));
        }

        if(getIntent().getStringExtra("tempat") != null){
            txtTempat.setText("Tempat Lahir : "+getIntent().getStringExtra("tempat"));
        }

        if(getIntent().getStringExtra("date") != null){
            txtDate.setText("Tanggal Lahir :"+getIntent().getStringExtra("date"));
        }

        if(getIntent().getStringExtra("alamat") != null){
            txtAlamat.setText("Alamat            : "+getIntent().getStringExtra("alamat"));
        }

        if(getIntent().getStringExtra("gender") != null){
            txtGender.setText("Jenis Kelamin : "+getIntent().getStringExtra("gender"));
        }

        if(getIntent().getStringExtra("pekerjaan") != null){
            txtPekerjaan.setText("Pekerjaan :"+getIntent().getStringExtra("pekerjaan"));
        }

        if(getIntent().getStringExtra("status") != null){
            txtStatus.setText("Status Perkawinan : "+getIntent().getStringExtra("status"));
        }

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


    }
}
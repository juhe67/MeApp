package com.example.meapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class  MainActivity extends AppCompatActivity {
    private TextView txtCb;
    private EditText editNik,editNama,editTempat,editDate, editAlamat;
    private CheckBox cbTerm;
    private RadioGroup groupGender;
    private RadioButton btnL,btnP;
    private Button btnDate, btnSubmit;
    private Spinner spinKerja,spinStatus;
    private SimpleDateFormat dateFormat;
    String nik,nama,date,tempat,alamat,gender,pekerjaan,status;


    @SuppressLint("NonConstantResourceId")
    void initUI() {

        editNik = findViewById(R.id.edit_nik);
        editNama = findViewById(R.id.edit_nama);
        editTempat = findViewById(R.id.edit_tempat);
        editDate = findViewById(R.id.edit_date);
        editAlamat = findViewById(R.id.edit_alamat);
        groupGender = findViewById(R.id.group_gender);
        btnL = findViewById(R.id.radio_btnl);
        btnP = findViewById(R.id.radio_btnp);
        cbTerm = findViewById(R.id.cb_term);
        txtCb = findViewById(R.id.txt_cb);
        btnDate = findViewById(R.id.btn_date);
        btnSubmit = findViewById(R.id.btn_submit);
        spinKerja = findViewById(R.id.spin_kerja);
        spinStatus = findViewById(R.id.spin_status);


        dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);



    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();


        txtCb.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://www.termsfeed.com/");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
            

        });

        btnDate.setOnClickListener(view -> showDialog());

        btnSubmit.setOnClickListener(view -> {

            nik = editNik.getText().toString();
            nama = editNama.getText().toString();
            tempat = editTempat.getText().toString();
            date = editDate.getText().toString();
            alamat = editAlamat.getText().toString();
            pekerjaan = spinKerja.getSelectedItem().toString();
            status = spinStatus.getSelectedItem().toString();

            int selectedGender = groupGender.getCheckedRadioButtonId();
            if (selectedGender == btnL.getId()) {
                gender = "Laki-laki";
            } else if (selectedGender == btnP.getId()) {
                gender = "Perempuan";
            }



            if (!nik.equals("") && nik.length()==16 &&
                    !nama.equals("") &&
                    !tempat.equals("") &&
                    !date.equals("") &&
                    !alamat.equals("") &&
            cbTerm.isChecked()) {

                Intent intent = new Intent(MainActivity.this, HomeActivity.class);

                intent.putExtra("nik",nik);
                intent.putExtra("nama",nama);
                intent.putExtra("tempat",tempat);
                intent.putExtra("date",date);
                intent.putExtra("alamat",alamat);
                intent.putExtra("gender", gender);
                intent.putExtra("pekerjaan",pekerjaan);
                intent.putExtra("status",status);

                startActivity(intent);
            } else if (nik.length() < 16) {
                Toast.makeText(MainActivity.this, "NIK Kurang Dari 16 Digit !", Toast.LENGTH_LONG).show();
            }

            else  {
                Toast.makeText(MainActivity.this, " Failed !", Toast.LENGTH_LONG).show();

            }
        });
    }

    private void showDialog() {
        Calendar newCalendar = Calendar.getInstance();
        @SuppressLint("SetTextI18n") DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year, monthOfYear, dayOfMonth) -> {

            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            editDate.setText(" "+ dateFormat.format(newDate.getTime()));
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }


    }

package com.example.owner.momcare;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.Calendar;

public class Register extends AppCompatActivity {
    Calendar cal = Calendar.getInstance();
    DBHandler db = new DBHandler(Register.this);

    int mobile;
    String password, name, email;
    DateFormat fmtdt= DateFormat.getDateTimeInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Intent intent = getIntent();
        Button sub = (Button) findViewById(R.id.sub);
        Button res = (Button) findViewById(R.id.res);
        final EditText nam = (EditText) findViewById(R.id.nam);
        final EditText mob1 = (EditText) findViewById(R.id.mob1);
       // final EditText ema = (EditText) findViewById(R.id.ema);
        final EditText pas1 = (EditText) findViewById(R.id.pas1);


        sub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mobile = Integer.parseInt(mob1.getText().toString());
                password = pas1.getText().toString();
                name = nam.getText().toString();
               // email = ema.getText().toString();

                SharedPreferences.Editor editor = getSharedPreferences("myPref", MODE_PRIVATE).edit();
                editor.putString("pas", password);
                editor.putString("nam", name);
              //  editor.putString("ema", email);
                editor.putInt("mob", mobile);
                editor.commit();
                Intent myIntent = new Intent(Register.this, NavigationActivity.class);
                startActivity(myIntent);


            }
        });

        res.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                nam.setText("");
                mob1.setText("");
               // ema.setText("");
                pas1.setText("");


            }
        });


    }

    public void choosedate(View v) {
        new DatePickerDialog(Register.this, d, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show();
    }

    /* private void updatelabel()
     {
         tvdate.setText(fmtdt.format(cal.getTime()));
     }*/
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            cal.set(Calendar.YEAR, i);
            cal.set(Calendar.MONTH, i2);
            cal.set(Calendar.DAY_OF_MONTH, i3);
            Log.i("check",""+fmtdt.format(cal.getTime()));
           /* updatelabel();*//*
            year=i;
            month=i2;
            day=i3;*/
        }
    };


}

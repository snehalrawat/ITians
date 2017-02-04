package com.example.owner.momcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    int mobile,m;
    String password;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button sig = (Button) findViewById(R.id.sig);
        Button reg= (Button) findViewById(R.id.reg);
        final EditText mob= (EditText) findViewById(R.id.mob);
        final EditText pas= (EditText) findViewById(R.id.pas);
        final TextView textView= (TextView) findViewById(R.id.tv1);

        SharedPreferences spf=getSharedPreferences("myPref",MODE_PRIVATE);
        s=spf.getString("pas","abc");
        m=spf.getInt("mob",0);


        reg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {


                Intent myIntent = new Intent(Login.this,Register.class);
                startActivity(myIntent);

            }
        });


        sig.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if((mob.getText().toString()).equals(m+"") &&(pas.getText().toString()).equals(s)) {

                    Intent myIntent = new Intent(Login.this, NavigationActivity.class);
                    startActivity(myIntent);
                }
                else
                    textView.setText("wrong password");


            }
        });



    }
}



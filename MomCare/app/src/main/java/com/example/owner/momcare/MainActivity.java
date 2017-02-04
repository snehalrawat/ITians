package com.example.owner.momcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        requestWindowFeature(Window.FEATURE_NO_TITLE);
*/
        Thread t = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent imsg = new Intent(MainActivity.this,Login.class);
                    startActivity(imsg);
                }
            }
        };
        t.start();

    }
}


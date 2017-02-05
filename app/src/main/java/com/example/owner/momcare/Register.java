package com.example.owner.momcare;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Register extends AppCompatActivity {
    public int qw;
    private PendingIntent pendingIntent;
    Calendar cal = Calendar.getInstance();
    DBHandler db = new DBHandler(Register.this);


    int mobile;
    String password, name, email;
    DateFormat fmtdt= DateFormat.getDateTimeInstance();
    int dat,mon,year;
    String s1;
    long a[] = new long[15];
  //  DBHandler ob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        Intent intent = getIntent();
       // ob=new DBHandler(this);
        Button sub = (Button) findViewById(R.id.sub);
        Button res = (Button) findViewById(R.id.res);
        final EditText nam = (EditText) findViewById(R.id.nam);
        final EditText mob1 = (EditText) findViewById(R.id.mob1);
       // final EditText ema = (EditText) findViewById(R.id.ema);
        final EditText pas1 = (EditText) findViewById(R.id.pas1);


        sub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
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



                String s=fmtdt.format(cal.getTime()).toString();
                long m=cal.getTimeInMillis();

                Intent alarmIntent = new Intent(Register.this, AlarmReciever.class);
                pendingIntent = PendingIntent.getBroadcast(Register.this, 0, alarmIntent, 0);

                Long m1=m+4233600000l;
                db.insertContact(m1," ultrasound test this week","No");
                long m2=m1+1814400000l;
                long m3=m2+604800000l;
                long m4=m3+604800000l;
                long m5=m4+1814400000l;
                long m6=m5+1209600000l;
                long m7=m6+2419200000l;
                long m8=m7+2419200000l;
                long m9=m8+1209600000l;
                long m10=m9+604800000l;
                long m11=m10+1209600000l;
                long m12=m11+2419200000l;
                long m13=m12+604800000l;
                long m14=m13+604800000l;
                db.insertContact(m2,"Blood count, fasting glucose, urine culture, blood type (and RH antibodies level if negative), rubella antibodies, VDRL, CMV, antibodies, HIV test","No");
                db.insertContact(m3," chromosomal genetic diagnostic testing, placental structure (chorionic placenta)","No");
                db.insertContact(m4,"ultrasound, nuchal translucency or fetal development test ","No");


                db.insertContact(m5,"early ultrasound screening exam","No");
                db.insertContact(m6,"triple screen test, fetoprotein or amniocentesis and blood count","No");
                db.insertContact(m7,"late ultrasound anomaly scan","No");
                db.insertContact(m8,"glucose tolerance test, 50-100 grams (based on risk factors), blood count and RH antibody levels for those with negative blood type and urine culture","No");
                db.insertContact(m9,"a visit to the physician to discuss glucose test results and talk about receiving RH immune globulin if RH negative","No");
                db.insertContact(m10,"review of fetal growth","No");
                db.insertContact(m11,"follow-up visit","No");
                db.insertContact(m12,"weekly tracking of fetal growth weight","No");
                db.insertContact(m13,"follow-up with doctor, ultrasound, monitoring biophysical profile every 2-4 days","No");
                db.insertContact(m14,"referral to the delivery room to perform a stress test or induce labor","No");
                Log.i("insert","abc");
                Log.i("datecheck",""+m);



                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
                String today = dateFormat.format(Calendar.getInstance().getTimeInMillis());
                long today2=Calendar.getInstance().getTimeInMillis();
                Log.i("check10",""+today);
                Log.i("today2",""+today2);

                int a=1,b=1;
               if(today2==m1)
               {
                   s1="ultrasound test this week";
                   start();
               }
                if(today2==m2)
                {
                    s1="\"Blood count, fasting glucose, urine culture, blood type (and RH antibodies level if negative), rubella antibodies, VDRL, CMV, antibodies, HIV test\"";
                    start();
                }
                if(today2==m3)
                {
                    s1="chromosomal genetic diagnostic testing, placental structure (chorionic placenta)";
                    start();
                }

                if(today2==m4)
                {
                    s1="ultrasound, nuchal translucency or fetal development test";
                    start();
                }

                if(today2==m5)
                {
                    s1="early ultrasound screening exam";
                    start();
                }

                if(today2==m6)
                {
                    s1="triple screen test, fetoprotein or amniocentesis and blood count";
                    start();
                }

                if(today2==m7)
                {
                    s1="late ultrasound anomaly scan";
                    start();
                }

                if(today2==m8)
                {
                    s1="glucose tolerance test, 50-100 grams (based on risk factors), blood count and RH antibody levels for those with negative blood type and urine culture";
                    start();
                }

                if(today2==m9)
                {
                    s1="a visit to the physician to discuss glucose test results and talk about receiving RH immune globulin if RH negative";
                    start();
                }

                if(today2==m10)
                {
                    s1="review of fetal growth";
                    start();
                }

                if(today2==m11)
                {
                    s1="follow-up visit";
                    start();
                }

                if(today2==m12)
                {
                    s1="weekly tracking of fetal growth weight";
                    start();
                }

                if(today2==m13)
                {
                    s1="follow-up with doctor, ultrasound, monitoring biophysical profile every 2-4 days";
                    start();
                }

                if(today2==m14)
                {
                    s1="referral to the delivery room to perform a stress test or induce labor";
                    start();
                }




                if(a==b)
                {
                    start();
                    s1="referral to the delivery room to perform a stress test or induce labor";
                }
                Intent myIntent = new Intent(Register.this, NavigationActivity.class);
                myIntent.putExtra("text", s1);
                startActivity(myIntent);


              /*  Cursor c=db.get();
                c.moveToFirst();

                int i = 1;
                while(c.moveToNext())
                {
                   a[i]= c.getLong(c.getColumnIndex("date"));
                    i++;
                    Log.i("check2","j");

                }
                for(int j=1;j<15;j++)
                {
                    Log.i("check20",""+a[j]);
                }*/

            //Cursor c=db.rawQuery("select * from TABLE_NAME",null);

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

    private void start() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        long interval=8000;
        manager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent);
        Toast.makeText(this, "Alarm Set", Toast.LENGTH_LONG).show();
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
            year=i;
            mon=i2;
            dat=i3;

            Log.i("check",""+fmtdt.format(cal.getTime()));


        }
    };


}

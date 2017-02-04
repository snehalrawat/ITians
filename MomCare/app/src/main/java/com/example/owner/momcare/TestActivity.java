package com.example.owner.momcare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {
    final ArrayList<TestItem> dataList = new ArrayList<TestItem>();
    static int[] images={R.drawable.ic_menu_camera,R.drawable.ic_menu_camera,R.drawable.ic_menu_camera};
    ViewFlipper flipper;
ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        lv= (ListView) findViewById(R.id.lis2);
        flipper= (ViewFlipper)findViewById(R.id.vf1);
        flipper.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.animpushleftin));
        flipper.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.animpushleftout));
        for(int image:images)
        {
            ImageView iv=new ImageView(this);
            iv.setBackgroundResource(image);
            flipper.addView(iv,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        }
        flipper.setFlipInterval(5000);
        flipper.startFlipping();

        TestItem a = new TestItem("Genetic Test(Blood test)",  "1st week ");
        TestItem b = new TestItem("Ultrasound", "3rd week");
        TestItem c =new TestItem("MSAFP and Multiple marker screening(ultrasound)",  "week 20");
        TestItem d =new TestItem("Glucose Screening",   "week 24-28");
        TestItem e =new TestItem("Amniocentesis","week 15-18");
        dataList.add(a);
        dataList.add(b);
        dataList.add(e);
        dataList.add(c);
        dataList.add(d);
        CustAdaptar adapter= new CustAdaptar(TestActivity.this, R.layout.listview_item, dataList);
        lv.setAdapter(adapter);

    }
}

package com.example.owner.momcare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CareActivity extends AppCompatActivity {
    ListView lv;
    final ArrayList<Item> dataList = new ArrayList<Item>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care);

        lv= (ListView) findViewById(R.id.lv2);

        Item a = new Item(R.mipmap.tm, "Threatened Miscarraige", "If a miscarriage should occur, it is important to realise that couples cannot influence the chance of miscarriage. Much is unknown about miscarriage and a cause can often not be found. Miscarriage occurs in about one in five pregnancies.");
        Item b = new Item(R.mipmap.ectopic, "Ectopic Pregnancy", " ");
        Item c = new Item(R.mipmap.genetics, "Genetic or medical termination of pregnancy", " ");
        Item d = new Item(R.mipmap.stillbirth, "Stillbirth and neonatal death", " ");
        Item e = new Item(R.mipmap.premature, "Premature", " ");
        dataList.add(a);
        dataList.add(b);
        dataList.add(c);
        dataList.add(d);
        dataList.add(e);


        CustAdapter2 adapter= new CustAdapter2(CareActivity.this, R.layout.cardview_item, dataList);
        lv.setAdapter(adapter);

    }
}

package com.example.owner.momcare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Owner on 04-02-2017.
 */

public class CustAdaptar extends ArrayAdapter<TestItem> {
    ArrayList<TestItem> datalist = new ArrayList<TestItem>();
    Context context;


    public CustAdaptar(Context context, int resource, ArrayList<TestItem> arrayList)
    {
        super(context, resource, arrayList);
        this.datalist = arrayList;
        this.context=context;

    }
    @Override
    public int getCount(){
        return super.getCount();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v= inflater.inflate(R.layout.listview_item, null);


        TextView tv1= (TextView) v.findViewById(R.id.tv1);
        TextView tv2 = (TextView) v.findViewById(R.id.tv2);

        //.setImageResource(datalist.get(position).getImg());
        tv1.setText(datalist.get(position).getMainText());
        tv2.setText(datalist.get(position).getSubText());







        return v;

    }
}

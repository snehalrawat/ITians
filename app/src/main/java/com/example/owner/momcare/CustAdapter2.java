package com.example.owner.momcare;

/**
 * Created by Owner on 04-02-2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Owner on 13-01-2017.
 */

public class CustAdapter2  extends ArrayAdapter<Item> {
    ArrayList<Item> datalist = new ArrayList<Item>();
    Context context;


    public CustAdapter2(Context context, int resource, ArrayList<Item> arrayList)
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
        v= inflater.inflate(R.layout.cardview_item, null);

        ImageView imageView= (ImageView) v.findViewById(R.id.img);
        TextView tv1= (TextView) v.findViewById(R.id.tv1);
        TextView tv2 = (TextView) v.findViewById(R.id.tv2);

        imageView.setImageResource(datalist.get(position).getImg());
        tv1.setText(datalist.get(position).getMainText());
        tv2.setText(datalist.get(position).getSubText());


        return v;

    }
}

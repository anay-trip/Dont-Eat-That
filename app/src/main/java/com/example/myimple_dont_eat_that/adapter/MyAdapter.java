package com.example.myimple_dont_eat_that.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myimple_dont_eat_that.R;
import com.example.myimple_dont_eat_that.model.FoodItem;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<FoodItem> arrayList;

    public MyAdapter(Context context, ArrayList<FoodItem> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.nfact_listview, null);
        TextView t1_name = convertView.findViewById(R.id.name_txt);
        TextView t2_calories = convertView.findViewById(R.id.calories_txt);
        TextView t3_carbs = convertView.findViewById(R.id.carbs_txt);
        TextView t4_protein = convertView.findViewById(R.id.protein_txt);
        TextView t5_fat = convertView.findViewById(R.id.fat_txt);
        TextView t6_cholestrol = convertView.findViewById(R.id.cholestrol_txt);

        FoodItem foodItem = arrayList.get(position);

        t1_name.setText(foodItem.getName());
        t2_calories.setText(Double.toString(foodItem.getCalories()));
        t3_carbs.setText(Double.toString(foodItem.getCarbs()));
        t4_protein.setText(Double.toString(foodItem.getProtein()));
        t5_fat.setText(Double.toString(foodItem.getFat()));
        t6_cholestrol.setText(Double.toString(foodItem.getCholestrol()));
        return convertView;
    }
}

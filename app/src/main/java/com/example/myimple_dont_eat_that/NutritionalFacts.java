package com.example.myimple_dont_eat_that;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myimple_dont_eat_that.adapter.MyAdapter;
import com.example.myimple_dont_eat_that.model.FoodItem;

import java.util.*;

public class NutritionalFacts extends AppCompatActivity {

    ImageView image;
    String label;
    TextView food_label;
    ListView Nfacts;
    NfactsDatabasehelper mydb;
    ArrayList<FoodItem> arrayList;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutritional_facts);
        image = (ImageView)findViewById(R.id.iv_image);
        Nfacts = (ListView)findViewById(R.id.lv_Nfacts);
        Intent i2=getIntent();

        //display image taken by user
        Bitmap bitmap = (Bitmap) i2.getParcelableExtra("img");
        image.setImageBitmap(bitmap);

        //display the label of image taken by the user i.e identification of food item
        food_label = (TextView)findViewById(R.id.tv_label);
        label = LabelStub();
        food_label.setText(label);

        //create and object of database class NfactsDatabasehelper
        mydb = new NfactsDatabasehelper(this);

        loadDataInListView(label);
    }

    public void loadDataInListView(String label)
    {
        /*
        call method associated with NfactDatabasehelper class that returns an array list of
        FoodItem objects. FoodItem object contains attributes of nutritional facts.
        */
        arrayList = mydb.getAllFacts(label);

        myAdapter = new MyAdapter(this, arrayList);
        Nfacts.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    //stub to simulate the API that returns the label (string) of the picture taken
    public String LabelStub()
    {
        String[] arr = {"apple pie", "hamburger", "pizza", "waffles"};
        Random r = new Random();
        int randomNumber = r.nextInt(arr.length);
        String item = arr[randomNumber];
        return item;
    }

}

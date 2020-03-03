package com.example.project_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class nutrifacts extends AppCompatActivity {
    ImageView i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrifacts);
        i1=findViewById(R.id.imageview2);
        Intent i2=getIntent();


        Bitmap bitmap = (Bitmap) i2.getParcelableExtra("img");
        i1.setImageBitmap(bitmap);


    }
}

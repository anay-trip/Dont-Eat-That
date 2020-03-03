package com.example.project_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mimageView;
    private static final int REQUEST_IMAGE_CAPTURE=101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mimageView=findViewById(R.id.imageview);
    }

    public void take_picture(View view)
    {
        Intent imageTakeIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(imageTakeIntent.resolveActivity(getPackageManager())!=null)
        {
            startActivityForResult(imageTakeIntent,REQUEST_IMAGE_CAPTURE);
        }
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        if(requestCode==REQUEST_IMAGE_CAPTURE&& resultCode==RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            //mimageView.setImageBitmap(imageBitmap);
            Intent intent=new Intent(MainActivity.this,nutrifacts.class);
            intent.putExtra("img",imageBitmap);
            startActivity(intent);
        }
    }

}


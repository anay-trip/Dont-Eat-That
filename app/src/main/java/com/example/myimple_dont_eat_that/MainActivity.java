package com.example.myimple_dont_eat_that;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnTakePic;
    NfactsDatabasehelper nfdb;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTakePic = (Button)findViewById(R.id.btn_takePic);
        btnTakePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchPictureTakerAction();
            }
        });

        //insert nutritional facts of food items
       // nfdb = new NfactsDatabasehelper(this); //call the contructor
        //nfdb.insertData("apple pie", 237, 34, 1.9, 11,  0);
//        nfdb.insertData("hamburger", 295, 24, 17, 14,  47);
//        nfdb.insertData("pizza", 266,  33, 11, 10,  17);
//        nfdb.insertData("waffles", 291, 33, 8, 14,  69);

    }
    //method to open camera from the app
    public void dispatchPictureTakerAction()
    {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getPackageManager()) != null)
        {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    //passes on the image taken by user to page that displays the nutritional facts.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            Intent intent = new Intent(MainActivity.this, NutritionalFacts.class);
            intent.putExtra("img", imageBitmap);
            startActivity(intent);
        }
    }


}

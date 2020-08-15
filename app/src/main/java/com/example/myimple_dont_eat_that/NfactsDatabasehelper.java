package com.example.myimple_dont_eat_that;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import com.example.myimple_dont_eat_that.model.FoodItem;

import java.util.ArrayList;

public class NfactsDatabasehelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "NutritionalFacts.db";
    public static final String TABLE_NAME = "food_table";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "CALORIES";
    public static final String COL_4 = "CARBS";
    public static final String COL_5 = "PROTEIN";
    public static final String COL_6 = "FAT";
    public static final String COL_7 = "CHOLESTROL";

    //database is created when the constructor is called
    public NfactsDatabasehelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " NAME TEXT, CALORIES REAL, CARBS REAL, PROTEIN REAL, " +
                "FAT REAL, CHOLESTROL REAL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, double calories, double carbs, double protein, double fat, double cholestrol)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, calories);
        contentValues.put(COL_4, carbs);
        contentValues.put(COL_5, protein);
        contentValues.put(COL_6, fat);
        contentValues.put(COL_7, cholestrol);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public ArrayList<FoodItem> getAllFacts(String label)
    {
        ArrayList<FoodItem> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE NAME = '" + label + "'", null);

        while(cursor.moveToNext())
        {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            double calories = cursor.getDouble(2);
            double carbs = cursor.getDouble(3);
            double proteins = cursor.getDouble(4);
            double fat = cursor.getDouble(5);
            double cholestrol = cursor.getDouble(6);

            FoodItem food = new FoodItem(id, name, calories, carbs, proteins, fat, cholestrol);
            arrayList.add(food);
        }
        return  arrayList;

    }
}

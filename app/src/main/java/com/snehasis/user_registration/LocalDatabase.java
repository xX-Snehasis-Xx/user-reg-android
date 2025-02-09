package com.snehasis.user_registration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class LocalDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user_db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Users";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "NAME";
    private static final String COL_3 = "OCCUPATION";
    private static final String COL_4 = "DEGREE";
    private static final String COL_5 = "SCORE";
    private static final String COL_6 = "COUNTRY";
    private static final String Create_Table_User = "CREATE TABLE " + TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " TEXT," + COL_3 + " TEXT," + COL_4 + " TEXT," + COL_5 + " INTEGER," + COL_6 + " TEXT)";
    String name , occupation , degree ,country;
    int score = 0;

    public LocalDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create tables
        db.execSQL(Create_Table_User);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void add_to_db(UserModel user){
        name = user.getName();
        occupation = user.getOccupation();
        degree = user.getDegree();
        score = user.getScore();
        country = user.getCountry();

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2, name);
        values.put(COL_3, occupation);
        values.put(COL_4, degree);
        values.put(COL_5, score);
        values.put(COL_6, country);

        db.insert(TABLE_NAME, null, values);
    }
    public ArrayList<UserModel> getData() {
        ArrayList<UserModel> data = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {

            do {
                //fetching each column data from database
                String name = cursor.getString(cursor.getColumnIndexOrThrow(COL_2));
                String occupation = cursor.getString(cursor.getColumnIndexOrThrow(COL_3));
                String degree = cursor.getString(cursor.getColumnIndexOrThrow(COL_4));
                int score = cursor.getInt(cursor.getColumnIndexOrThrow(COL_5));
                String country = cursor.getString(cursor.getColumnIndexOrThrow(COL_6));

                //add to arraylist
                data.add(new UserModel(name, occupation, degree, score, country));
            }while (cursor.moveToNext());

        }cursor.close();
        return data;
    }
}


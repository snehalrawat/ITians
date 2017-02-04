package com.example.owner.momcare;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owner on 29-12-2016.
 */

public class DBHandler extends SQLiteOpenHelper {
    Context context;
    private static final String DATABASE_NAME = "Contacts";
    private static final String id = "id";
    private static final String date = "date";
    private static final String test = "test";
    private static final String check = "check";


    private static final String TABLE_NAME = "Tests";


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_CREATE = "create table "
            + TABLE_NAME + "( " + id
            + " integer primary key autoincrement, " + date
            + " text ," + test + "text , " + check + " text);";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
        Log.i("table","a");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
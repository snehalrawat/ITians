package com.example.owner.momcare;

import android.content.Context;
import android.database.SQLException;
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
    private static final String date = "date1";
    private static final String test = "test1";
    private static final String check = "check1";


    private static final String TABLE_NAME = "Tests";



    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_CREATE = "CREATE TABLE "
            + TABLE_NAME + "(" + id
            + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + date
            + " TEXT ," + test + " TEXT ," + check + " TEXT)";
    SQLiteDatabase sql;


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Log.i("query", DATABASE_CREATE);
            db.execSQL(DATABASE_CREATE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Log.i("table","a");

    }
    public void insertContact(long date,String test,String check) {
        SQLiteDatabase dbObj= getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DBHandler.date , date);
        values.put(DBHandler.test ,test );
        values.put(DBHandler.check ,check );

        Log.i("query2", "INSERT INTO "+TABLE_NAME+"("+date+","+test+","+check+") VALUES('abc','abc1','No')");

       /* long insertId = dbObj.insert(DBHandler.TABLE_NAME, null,
                values);*/
        dbObj.execSQL("INSERT INTO "+TABLE_NAME+"("+DBHandler.date+","+DBHandler.test+","+DBHandler.check+") VALUES('abc','abc1','No')");

    }

    public List<String> getAllContacts() {
        SQLiteDatabase dbObj = getReadableDatabase();
        String[] allColumns = {DBHandler.id,DBHandler.date,DBHandler.test,DBHandler.check};


        List<String> dataList = new ArrayList<String>();

        Cursor cursor = dbObj.query(DBHandler.TABLE_NAME,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String number = cursor.getString(1);
            String code = cursor.getString(0);
            dataList.add(code+"-"+number);
            cursor.moveToNext();
        }
        return dataList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
   public Cursor get()
    {
        return sql.query(TABLE_NAME,new String[]{id,date,test,check},null,null,null,null,null);
    }


}
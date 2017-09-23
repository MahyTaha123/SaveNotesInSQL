package com.example.maha.savenotesinsql;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Maha on 22/09/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "notes.db";
    public static final String TABLE_NAME = "notes_table";
    public static final int DATABASE_VERSION = 1;
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NOTE_MESSAGE";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE" + TABLE_NAME + "(" + COL_1 + "INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + "TEXT" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS");
        onCreate(db);

    }

    public boolean insertData(String Msg) {

      SQLiteDatabase database= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2, Msg);
      long result = database.insert(TABLE_NAME, null, values);

        if(result== -1)
            return false;
        else

            return true;



    }



}

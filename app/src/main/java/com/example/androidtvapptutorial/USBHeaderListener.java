package com.example.androidtvapptutorial;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class USBHeaderListener extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "FSB.db";
    private static int DATABASE_VERSION = 1;
    private String Create_Table_USBHeaderListener = "CREATE TABLE USBHeaderListener (\"ID\" INTEGER PRIMARY KEY NOT NULL, \"VALUE\" STRING NOT NULL);";
    private String Insert_USBHeaderListener = "INSERT INTO USBHeaderListener (ID, VALUE) VALUES(1,\"\");";

    SQLiteDatabase Db = this.getWritableDatabase();

    public USBHeaderListener(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e(USBHeaderListener.class.getSimpleName(),"onCreate()");
        if (db != null){
            db.execSQL(Create_Table_USBHeaderListener);
            db.execSQL(Insert_USBHeaderListener);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e(USBHeaderListener.class.getSimpleName(),"onUpgrade()");
        if (db != null){
            db.execSQL("DROP TABLE IF EXIST USBHeaderListener");
            onCreate(db);
        }
    }

    public void setUSBSelected(String value){
        Log.e(USBHeaderListener.class.getSimpleName(),"setUSBSelected()");
        Db.execSQL("UPDATE USBHeaderListener SET VALUE = \""+value+"\" WHERE ID = 1");
    }

    public String getUSBSelected(){
        Log.e(USBHeaderListener.class.getSimpleName(),"getUSBSelected()");
        Cursor cursor = null;
        String Data = null;

        try {
            cursor = Db.rawQuery("SELECT VALUE FROM USBHeaderListener WHERE ID=?", new String[]{1 + ""});
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                Data = cursor.getString(cursor.getColumnIndex("VALUE"));
            }
        }
        catch (Exception ex){
            Log.e("Error", ex.toString());
        }
        finally {
            cursor.close();
        }
        Log.e(USBHeaderListener.class.getSimpleName(),"getUSBSelected() " + Data);
        return Data;
    }
}

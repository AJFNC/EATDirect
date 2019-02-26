package com.example.eatdirect;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TDataBase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "td_database";
    private Context context;


    public TDataBase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        try {

            db.execSQL("CREATE TABLE TAXAS (ID_TAXA NUMBER, MES TEXT, SELIC NUMBER, IPCA NUMBER)");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try{
            System.out.println("On Upgrade!");
            db.execSQL("DROP TABLE IF EXISTS TAXAS");
            onCreate(db);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }



}

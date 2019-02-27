package com.example.eatdirect;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TDDBOperacao {

    TDataBase myDB;
    //private TDataBase;

    public TDDBOperacao(Context context){

        myDB = new TDataBase(context);

    }

    // Método para inserir dados no BD

    public long insertIntoDB(String mes, float taxa, float inflacao){

        SQLiteDatabase bd = myDB.getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put("_id", id);
        values.put("MES", mes);
        values.put("SELIC", taxa);
        values.put("IPCA", inflacao);

        long result = bd.insert("TAXAS", null, values);

        System.out.println("[TDDB] Retorno do insert: " + result);

        bd.close();
        return result;
    }

    // Método para obter dados do BD

    public String selectFromDB(){
        SQLiteDatabase bd = myDB.getWritableDatabase();
        String[] colunas = {"_id", "MES", "SELIC", "IPCA"};
        Cursor cursor = bd.query("TAXAS", colunas, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();


        int i;
       for (i = 0; i < 5; i++){
        //while(cursor.moveToNext()){
            cursor.moveToNext();
            int id = cursor.getInt(cursor.getColumnIndex("_id"));
            String mes = cursor.getString(cursor.getColumnIndex("MES"));
            float selic = cursor.getFloat(cursor.getColumnIndex("SELIC"));
            float ipca = cursor.getFloat(cursor.getColumnIndex("IPCA"));

            buffer.append(id + "," + mes + "," + selic + "," + ipca + "\n");

        }

        return buffer.toString();
    }


}

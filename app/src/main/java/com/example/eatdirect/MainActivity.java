package com.example.eatdirect;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    TDataBase tdCEF;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);



                    Intent graphicIntent = new Intent(MainActivity.this,GraphicActivity.class);
                    startActivity(graphicIntent);


                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);

                    Intent strategyIntent = new Intent(MainActivity.this,StrategyActivity.class);
                    startActivity(strategyIntent);

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

       // if (mTextMessage.getText().equals(R.string.title_dashboard)){

        tdCEF = new TDataBase(this);
        insert();


       // }



    }

    public void insert(){
        SQLiteDatabase db = tdCEF.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("ID_TAXA",1);
        values.put("MES", "AGO");
        values.put("SELIC", 6.50);
        db.insert("TAXAS",null, values);

        values.put("ID_TAXA",2);
        values.put("MES", "SET");
        values.put("SELIC", 6.50);
        db.insert("TAXAS",null, values);

        values.put("ID_TAXA",1);
        values.put("MES", "OUT");
        values.put("SELIC", 6.50);
        db.insert("TAXAS",null, values);

        values.put("ID_TAXA",1);
        values.put("MES", "NOV");
        values.put("SELIC", 6.50);
        db.insert("TAXAS",null, values);

        values.put("ID_TAXA",1);
        values.put("MES", "DEZ");
        values.put("SELIC", 6.50);
        db.insert("TAXAS",null, values);

        values.put("ID_TAXA",1);
        values.put("MES", "JAN");
        values.put("SELIC", 6.50);
        db.insert("TAXAS",null, values);

        db.close();

        System.out.println("[MA] DB fechado!");


    }


}

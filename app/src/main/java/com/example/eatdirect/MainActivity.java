package com.example.eatdirect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    public TDDBOperacao tdCEF;


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



        tdCEF = new TDDBOperacao(this);
        tdCEF.insertIntoDB(1, "AGO", 6.50f, 4.30f);
        tdCEF.insertIntoDB(1, "SET", 6.50f, 4.28f);
        tdCEF.insertIntoDB(1, "OUT", 6.50f, 4.53f);
        tdCEF.insertIntoDB(1, "NOV", 6.50f, 4.39f);
        tdCEF.insertIntoDB(1, "DEZ", 6.50f, 3.86f);
        tdCEF.insertIntoDB(1, "JAN", 6.50f, 3.77f);


        System.out.println("[MA] DB fechado!");


    }

}

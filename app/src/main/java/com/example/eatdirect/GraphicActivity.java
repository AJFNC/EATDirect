package com.example.eatdirect;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.StringTokenizer;

public class GraphicActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private EditText editText6;
    private EditText editText7;


    public TDDBOperacao tdCEF;

    public double MyAxeD = 0;
    public  double MyAxeID = 0;
    public double lyAxeD;
    public double lyAxeID;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    return true;

                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);

                    Intent mainIntent = new Intent(GraphicActivity.this,MainActivity.class);
                    startActivity(mainIntent);
                    //getIntent();
                    return true;


                case R.id.navigation_notifications:
                   // mTextMessage.setText(R.string.title_notifications);

                    Intent strategyIntent = new Intent(GraphicActivity.this,StrategyActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putDouble("mSELIC", MyAxeD);
                    bundle.putDouble("mIPCA", MyAxeID);
                    bundle.putDouble("lSELIC", lyAxeD);
                    bundle.putDouble("lIPCA", lyAxeID);
                    strategyIntent.putExtras(bundle);

                    startActivity(strategyIntent);

                    return true;
            }
            return false;
        }
    };
    private String selectSTR;
    public StringTokenizer strSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        editText6 = findViewById(R.id.editText6);
        editText7 = findViewById(R.id.editText7);

        tdCEF = new TDDBOperacao(this);

        selectSTR = tdCEF.selectFromDB();


        System.out.println(this.selectSTR);


        int i=0;
        double xAxeD[] = new double[12];
        double yAxeD[] = new double[12];
        double yAxeIPCAD[] = new double[12];



        strSelected = new  StringTokenizer(selectSTR,"\n");

       // while(strSelected.hasMoreTokens()){
        for (i = 0; i < 5; i++ ){


            String line = strSelected.nextToken();

            System.out.println(line);
            //strSegment = line.substring(line.indexOf(","));



            String xAxe = line.substring(2, 5);
            System.out.println(xAxe);

            String yAxe = line.substring(6, 9);
            System.out.println(yAxe);

            String yAxeI = line.substring(10, 13);
            System.out.println(yAxeI);

            xAxeD[i] = this.converteStringToDouble(xAxe);
            yAxeD[i] = Double.parseDouble(yAxe);
            yAxeIPCAD[i] = Double.parseDouble(yAxeI);

            MyAxeD += yAxeD[i];

            MyAxeID += yAxeIPCAD[i];


            lyAxeD = yAxeD[i];
            lyAxeID = yAxeIPCAD[i];


        }

        MyAxeD = MyAxeD / 5;
        MyAxeID = MyAxeID / 5;




        System.out.println("[GA] " + MyAxeD);
        System.out.println("[GA] " + MyAxeID);


        editText6.setText(String.valueOf(MyAxeD));
        editText7.setText(String.valueOf(MyAxeID));

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> serieSelic = new LineGraphSeries<>(new DataPoint[] {



                /**
                new DataPoint( xAxeD[0], yAxeD[0]),
                new DataPoint( xAxeD[1], yAxeD[1]),
                new DataPoint( xAxeD[2], yAxeD[2]),
                new DataPoint( xAxeD[3], yAxeD[3]),
                new DataPoint( xAxeD[4], yAxeD[4])

                */

                new DataPoint(1, 7.0),
                new DataPoint(2, 6.81),
                new DataPoint(3, 6.67),
                new DataPoint(4, 6.5),
                new DataPoint(5, 6.5),
                new DataPoint(6, 6.5),
                new DataPoint(7, 6.5),
                new DataPoint(8, 6.5),
                new DataPoint(9, 6.5),
                new DataPoint(10, 6.5),
                new DataPoint(11, 6.5),
                new DataPoint(12, 6.5)
        });

       // serieSelic.setColor(Color.RED);
        serieSelic.setTitle("SELIC");

        graph.addSeries(serieSelic);

        LineGraphSeries<DataPoint> serieIpca = new LineGraphSeries<>(new DataPoint[] {

                new DataPoint(1, 3.02),
                new DataPoint(2, 2.86),
                new DataPoint(3, 2.80),
                new DataPoint(4, 2.80),
                new DataPoint(5, 2.70),
                new DataPoint(6, 3.68),
                new DataPoint(7, 4.53),
                new DataPoint(8, 4.30),
                new DataPoint(9, 4.28),
                new DataPoint(10, 4.53),
                new DataPoint(11, 4.39),
                new DataPoint(12, 3.86)
        });

        serieIpca.setColor(Color.RED);
        serieIpca.setTitle("IPCA");

        graph.addSeries(serieIpca);

        System.out.println("[GA] Gráfico plotado!");

    }

    public double converteStringToDouble(String strMes){
        switch (strMes) {

            case "JAN":
                return 1;
            case "FEV":
                return 2;
            case "JMAR":
                return 3;
            case "ABR":
                return 4;
            case "MAI":
                return 5;
            case "JUN":
                return 6;
            case "JUL":
                return 7;
            case "AGO":
                return 8;
            case "SET":
                return 9;
            case "OUT":
                return 10;
            case "NOV":
                return 11;
            case "DEZ":
                return 12;

        }
        return 0;
    }


}

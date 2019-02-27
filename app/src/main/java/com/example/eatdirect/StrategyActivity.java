package com.example.eatdirect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class StrategyActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private EditText editText2;

    double mSelicEst;
    double lSelic;

    double mIpcaEst;
    double lIpca;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {


                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);

                    Intent mainIntent = new Intent(StrategyActivity.this,MainActivity.class);
                    startActivity(mainIntent);
                    //getIntent();

                    return true;

                case R.id.navigation_dashboard:
                   // mTextMessage.setText(R.string.title_dashboard);
                    Intent graphicIntent = new Intent(StrategyActivity.this,GraphicActivity.class);
                    startActivity(graphicIntent);
                    //getIntent();

                    return true;

                case R.id.navigation_notifications:
                   // mTextMessage.setText(R.string.title_notifications);
                    return true;


            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy);

        mTextMessage = (TextView) findViewById(R.id.message);
        editText2 = findViewById(R.id.editText2);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){

            mSelicEst = bundle.getDouble("mSELIC");
            lSelic = bundle.getDouble("lSELIC");
            mIpcaEst = bundle.getDouble("mIPCA");
            lIpca = bundle.getDouble("lIPCA");


        }


        // Configurar para os últimos  14 anos


        System.out.println("[SA] " + mSelicEst);
        System.out.println("[SA] " + mIpcaEst);


        // Estratégia a ser adotada em função da média dos 5 meses das taxas

        if ((mSelicEst < 20.00) & (mSelicEst >= 15.00) & (mIpcaEst < 9.00) & (mIpcaEst >= 6.00)) {
            editText2.setText("Comprar  Tesour Pré-Fixado/ Vender Tesouro SELIC");
        }
        if ((mSelicEst < 20.00) & (mSelicEst >= 15.00) & (mIpcaEst < 6.00) & (mIpcaEst >= 2.00)) {
            editText2.setText("Comprar  Tesour Pré-Fixado/ Manter Tesouro SELIC ");
        }

        if ((mSelicEst < 15.00) & (mSelicEst >= 10.00) & (mIpcaEst < 9.00) & (mIpcaEst >= 6.00)) {
            editText2.setText("Comprar  Tesour Pré-Fixado/ Vender Tesouro SELIC");
        }
        if ((mSelicEst < 15.00) & (mSelicEst >= 10.00) & (mIpcaEst < 6.00) & (mIpcaEst >= 2.00)) {
            editText2.setText("Comprar  Tesour Pré-Fixado/ Manter Tesouro SELIC ");
        }

        if ((mSelicEst < 10.00) & (mSelicEst >= 6.00) & (mIpcaEst < 9.00) & (mIpcaEst >= 6.00)) {
            editText2.setText("Comprar Tesouro SELIC / Manter Tesouro Pré-Fixado");
        }
        if ((mSelicEst < 10.00) & (mSelicEst >= 6.00) & (mIpcaEst < 6.00) & (mIpcaEst >= 2.00)) {
            editText2.setText("Comprar Tesouro SELIC / Vender Tesouro Pré-Fixado");
        }

        if ((mSelicEst < 6.00) & (mSelicEst >= 2.00) & (mIpcaEst < 9.00) & (mIpcaEst >= 6.00)) {
            editText2.setText("Comprar Tesouro SELIC / Manter Tesouro Pré-Fixado");
        }
        if ((mSelicEst < 6.00) & (mSelicEst >= 2.00) & (mIpcaEst < 6.00) & (mIpcaEst >= 2.00)) {
            editText2.setText("Comprar Tesouro SELIC / Vender Tesouro Pré-Fixado");
        }

        if ((mSelicEst < 2.00) & (mIpcaEst < 2.00)) {
            editText2.setText("Investir em um negócio");
        }


    /**
        if ((mIpcaEst < lIpca) & (mIpcaEst < lIpca)){
             editText2.setText("Comprar  / Vender ");
        }

      */


        System.out.println("[SA] Estratégia apresentada!");

    }


}

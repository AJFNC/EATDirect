package com.example.eatdirect;

import com.example.eatdirect.StrategyActivity;

public class ClearBroker extends Broker{


    @Override
    public  String estrategia(){

        return "estrategia";
    }

    @Override
    public double getTIPCA(){

        double ipca = 0.00;

        return ipca;
    }

    @Override
    public double getTPREF(){

        double tpref = 0.00;

        return tpref;
    }

    @Override
    public double getTSELIC(){

        double selic = 0.00;

        return selic;
    }

    @Override
    public void setTIPCA(double I){

        this.TIPCA = I;
    }

    @Override
    public void setTPREF(double P){

        super.TPREF = P;
    }

    @Override
    public void setTSELIC(double S){

        super.TSELIC = S;
    }

}

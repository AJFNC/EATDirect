package com.example.eatdirect;

public abstract class Broker {

    protected double TIPCA;
    protected double TPREF;
    protected double TSELIC;

    public abstract double getTIPCA();
    public abstract double getTPREF();
    public abstract double getTSELIC();

    public void setTIPCA(double d) {
        this.TIPCA = d;
    }

    public void setTPREF(double d) {
        this.TPREF = d;
    }

    public void setTSELIC(double d) {
        this.TSELIC = d;
    }

    public abstract String estrategia();


}

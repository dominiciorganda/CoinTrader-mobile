package com.example.bitcointrader.Activities;

public interface ICoinActivity {
    void getActualValue();

    void getValues();

    void fillStats();

    void drawChart();

    void setLoadingScreen();

    void setChartDays();
}

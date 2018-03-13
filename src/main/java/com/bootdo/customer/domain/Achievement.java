package com.bootdo.customer.domain;

import com.bootdo.common.domain.DailyRankings;

import java.util.List;

public class Achievement {
    private  Float a;
    private  Float b;
    private  Integer c;
    private  String sales;
    private  String commission;
    private  String total;
    private List<DailyRankings> dailyRankingsList;
    public Float getA() {
        return a;
    }

    public void setA(Float a) {
        this.a = a/100;
    }

    public Float getB() {
        return b;
    }

    public void setB(Float b) {
        this.b = b/100;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public List<DailyRankings> getDailyRankingsList() {
        return dailyRankingsList;
    }

    public void setDailyRankingsList(List<DailyRankings> dailyRankingsList) {
        this.dailyRankingsList = dailyRankingsList;
    }


    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}

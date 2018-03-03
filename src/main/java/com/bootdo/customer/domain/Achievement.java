package com.bootdo.customer.domain;

import com.bootdo.common.domain.DailyRankings;

import java.util.List;

public class Achievement {
    private  Float a;
    private  Float b;
    private  Integer c;
    private List<DailyRankings> dailyRankingsList;
    public Float getA() {
        return a;
    }

    public void setA(Float a) {
        this.a = a;
    }

    public Float getB() {
        return b;
    }

    public void setB(Float b) {
        this.b = b;
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
}

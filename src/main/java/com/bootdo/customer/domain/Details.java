package com.bootdo.customer.domain;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class  Details{
    //   方案Id
    private String pId;

    //    金额
    private Float money;
    //  过关方式
    private String subName;
     // 赛事
    private String list;
    private List<Match> dList;


    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public List<Match> getdList() {
        return dList;
    }

    public void setdList(List<Match> dList) {
        this.dList = dList;
    }
}

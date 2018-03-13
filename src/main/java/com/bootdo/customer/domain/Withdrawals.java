package com.bootdo.customer.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Withdrawals {
//    ACT.TB_ORDER_WITHDRAW
//    流水号  ORDER_ID
    private  String orderId;
// 用户名 USER_ID
private  String uname;
// 真实姓名
private  String rname;
// 付款账号 ACCOUNT_NO
private  String accountNo;
// 开户 BANK_NAME
private  String bank;
// 支行BRANCH
private  String branch;
// 提现金额 ORDER_AMOUNT
private  Float amout;
//
// 手续费  FEE_AMOUNT
private  Float fee;
// 时间  CREATE_DAY
private  String day;
// 状态  ORDER_STATUS
private  String status;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Float getAmout() {
        return amout;
    }

    public void setAmout(Float amout) {
        this.amout = amout/100;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date dd= null;
        try {
            dd = sdf.parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd");
        day= time.format(dd);
        this.day = day;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
//        提现状态（1-进行中 2-已完成 3-已撤销 4-待审核 5-审核未通过）
        if(status.equals("1")){
            status="进行中";
        }else if(status.equals("2")){
            status="已完成";
        }else if(status.equals("3")){
            status="已撤销";
        }else if(status.equals("4")){
            status="待审核";
        }else if(status.equals("5")){
            status="审核未通过";
        }

        this.status = status;
    }
}

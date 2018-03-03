package com.bootdo.customer.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class  Recharge{

//    流水号  ORDER_ID
    private  String orderId;

//    用户ID USER_ID
    private  String uname;
//    CREATE_TIMESTAMP
private  Date time;
//    PAY_TYPE

    private  String type;
//    ORDER_STATUS
private  String staus;

//    FEE_AMOUNT
private  Float amout;
    //    ORDER_AMOUNT
    private  Float fee;

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStaus() {
        return staus;
    }

    public void setStaus(String staus) {
//        订单状态（1-待支付 2-已支付 3-支付失败）
        if(staus.equals("1")){
            staus="待支付";
        }else if(staus.equals("2")){
            staus="已支付";
        }else if(staus.equals("3")){
            staus="支付失败";
        }
        this.staus = staus;
    }

    public Float getAmout() {
        return amout;
    }

    public void setAmout(Float amout) {
        this.amout = amout;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }
}

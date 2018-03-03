package com.bootdo.customer.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Match {
//    LOTTERY_ID 玩法编号（JCZQ-竞彩足球 JCLQ-竞彩篮球）
    private  String lotteryId;
    //    PLAY_TIME  比赛时间
private String payTime;
//    HOST_TEAM 主队名  GUEST_TEAM 客队名
private  String zname;
private  String kname;
//    HOST_FULL_SCORE 主队全场得分
private  String zqf;
//    HOST_HALF_SCORE 主队半场得分
private  String zbf;
//    GUEST_FULL_SCORE  客队全场得分
private  String kqf;
//    GUEST_HALF_SCORE  客队半场得分
private  String kbf;

    private  String wanfen;
    private  String touzhu;
    private  String zId;
    public String getLotteryId() {
        return lotteryId;
    }

    public void setLotteryId(String lotteryId) {
        this.lotteryId = lotteryId;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date dd= null;
        try {
            dd = sdf.parse(payTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        payTime= time.format(dd);
        this.payTime = payTime;
    }

    public String getZname() {
        return zname;
    }

    public void setZname(String zname) {
        this.zname = zname;
    }

    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname;
    }

    public String getZqf() {
        return zqf;
    }

    public void setZqf(String zqf) {
        this.zqf = zqf;
    }

    public String getZbf() {
        return zbf;
    }

    public void setZbf(String zbf) {
        this.zbf = zbf;
    }

    public String getKqf() {
        return kqf;
    }

    public void setKqf(String kqf) {
        this.kqf = kqf;
    }

    public String getKbf() {
        return kbf;
    }

    public void setKbf(String kbf) {
        this.kbf = kbf;
    }

    public String getWanfen() {
        return wanfen;
    }

    public void setWanfen(String wanfen) {
        this.wanfen = wanfen;
    }

    public String getTouzhu() {
        return touzhu;
    }

    public void setTouzhu(String touzhu) {
        this.touzhu = touzhu;
    }

    public String getzId() {
        return zId;
    }

    public void setzId(String zId) {
        this.zId = zId;
    }
}

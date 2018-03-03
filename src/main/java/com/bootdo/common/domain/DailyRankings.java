package com.bootdo.common.domain;

import java.util.Date;

public class DailyRankings {
   //    销售Id
   private  Integer saleid;
   //    销售名称
private  String sale;
// 上级主管
private  String manager;
// 自购量
private  Float own;
// 跟单量
private  Float follow;
// 总销售
private  Float   total;
// 被跟单量
   private  Integer befollowed;
// 开户数
private  Integer openaccount;
// 消费数
private  Integer consumption;
// 入职时间
private Date timeentry;
// 入库时间
   private Date newtime;
   // 时间排序
   private String sort;

   public String getSale() {
      return sale;
   }

   public void setSale(String sale) {
      this.sale = sale;
   }

   public String getManager() {
      return manager;
   }

   public void setManager(String manager) {
      this.manager = manager;
   }

   public Float getOwn() {
      return own;
   }

   public void setOwn(Float own) {
      this.own = own;
   }

   public Float getFollow() {
      return follow;
   }

   public void setFollow(Float follow) {
      this.follow = follow;
   }

   public Float getTotal() {
      return total;
   }

   public void setTotal(Float total) {
      this.total = total;
   }

   public Integer getBefollowed() {
      return befollowed;
   }

   public void setBefollowed(Integer befollowed) {
      this.befollowed = befollowed;
   }


   public Integer getOpenaccount() {
      return openaccount;
   }

   public void setOpenaccount(Integer openaccount) {
      this.openaccount = openaccount;
   }

   public Integer getConsumption() {
      return consumption;
   }

   public void setConsumption(Integer consumption) {
      this.consumption = consumption;
   }

   public Date getTimeentry() {
      return timeentry;
   }

   public void setTimeentry(Date timeentry) {
      this.timeentry = timeentry;
   }

   public Date getNewtime() {
      return newtime;
   }

   public void setNewtime(Date newtime) {
      this.newtime = newtime;
   }

   public Integer getSaleid() {
      return saleid;
   }

   public void setSaleid(Integer saleid) {
      this.saleid = saleid;
   }

   public String getSort() {
      return sort;
   }

   public void setSort(String sort) {
      this.sort = sort;
   }
}

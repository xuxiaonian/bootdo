package com.bootdo.customer.domain;


import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class  Order{
	//   用户昵称
	private String userName;
//	订单id
    private String orderId;
//	下单时间
	private Date buyTime;
//	期号 PROGRAM_ID
private String prId;
// 订单金额 order_amount
private Float orderAmount;
// 订单类型 ISFOLLOW
private String isFollow;
// 订单状态 ORDER_STATUS
private String orderStatus;
// 是否中奖 BONUS_FLAG
private String bonus;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}

	public String getPrId() {
		return prId;
	}

	public void setPrId(String prId) {
		this.prId = prId;
	}

	public Float getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Float orderAmount) {
		this.orderAmount = orderAmount/100;
	}

	public String getIsFollow() {
		return isFollow;
	}

	public void setIsFollow(String isFollow) {
//		是否跟单（1跟单0非跟单）
		if(isFollow.equals("0")){
			isFollow="自购";
		}else {
			isFollow="跟单";
		}

		this.isFollow = isFollow;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
//		订单状态（0-未付款  1-已付款 2-过期关闭）
		if(orderStatus.equals("0")){
			orderStatus="未付款";
		}else if(orderStatus.equals("1")) {
			orderStatus="已付款";
		}else if(orderStatus.equals("2")) {
			orderStatus="过期关闭";
		}
		this.orderStatus = orderStatus;
	}

	public String getBonus() {
		return bonus;
	}

	public void setBonus(String bonus) {
//		中奖状态（0-未中奖 1-已中奖）
		if(bonus.equals("0")){
			bonus="未中奖";
		}else if(bonus.equals("1")) {
			bonus="已中奖";
		}
		this.bonus = bonus;
	}

//	public void setUserType(String userType) {
//		if(userType.equals("0")){
//			userType="渠道用户";
//		}else {
//			userType="销售用户";
//		}
//		this.userType = userType;
//	}



}

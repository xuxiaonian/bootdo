package com.bootdo.customer.service.impl;


import com.bootdo.common.domain.DailyRankings;
import com.bootdo.customer.dao.CustomerMapper;
import com.bootdo.customer.domain.*;
import com.bootdo.customer.service.CustomerService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Transactional
@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	CustomerMapper customerMapper;


	@Override
	public List<Order> list(int i, Map<String, Object> params) {
		List<Order> list=customerMapper.list(i);
	      Integer limit= Integer.parseInt(params.get("limit").toString());
		Integer offset=  Integer.parseInt(params.get("offset").toString());
		list=list.subList(offset,((list.size()> (limit+offset)) ? (limit+offset) : list.size()));
		return  list;
	}

	@Override
	public Integer total(int i) {
		return customerMapper.count(i);
	}

	@Override
	public Details details(String id) {
		Details details=customerMapper.details(id);
		String list=details.getList();
		/*20171212_2_001|
				RQ-1:3#2.11;
		        BF:42#45.00,01#15.00
		20171211_1_005|SPF:3#2.90;BF:10#7.50,42#80.00,01#6.50|0^*/
		List <Match> matchList=new ArrayList<Match>();
		String dd="|0^";
		String[] lists=details.getList().split("\\^");
		System.out.println(lists.length);
		for (String ls:lists){
			String[] a=ls.split("\\|");
			String sId=a[0];
			String[] b=a[1].split("#");
			String wan=b[0];
			String fen=b[1];
			Match match=customerMapper.match(sId);
            match.setzId(sId);
			match.setWanfen(wan);
			match.setTouzhu(fen);
			matchList.add(match);
		}
		details.setdList(matchList);
		return details;
	}

    @Override
    public List<Withdrawals> wlist(int i, Map<String, Object> params) {
        List<Withdrawals> list=customerMapper.wlist(i);
        Integer limit= Integer.parseInt(params.get("limit").toString());
        Integer offset=  Integer.parseInt(params.get("offset").toString());
        list=list.subList(offset,((list.size()> (limit+offset)) ? (limit+offset) : list.size()));
        return list;
    }

    @Override
    public int wtotal(int i) {
        return customerMapper.wcount(i);
    }

    @Override
    public List<Recharge> clist(Map<String, Object> params) {
        String phone= params.get("phone").toString();
	    List<Recharge> list=customerMapper.clist(phone);
        Integer limit= Integer.parseInt(params.get("limit").toString());
        Integer offset=  Integer.parseInt(params.get("offset").toString());
        list=list.subList(offset,((list.size()> (limit+offset)) ? (limit+offset) : list.size()));
        return list;
    }

    @Override
    public int ctotal(Map<String, Object> params ) {
        String phone= params.get("phone").toString();
        return customerMapper.ccount(phone);
    }

	@Override
	public Achievement achievement(int i) {
		Achievement aa= new Achievement();
		DecimalFormat    df   = new DecimalFormat("######0.00");
		String sort = new SimpleDateFormat("yyyyMM").format(new Date());
		String odey=sort+"00";
		String nady=sort+"32";
        Float a1=0.0F;
		Float b1=0.0F;
		Integer c1=0;
		List<DailyRankings> userList= customerMapper.userList(i);
		for(DailyRankings user:userList){
			Integer userId=user.getSaleid();
			Float own= customerMapper.own(userId,odey,nady);
			if (own==null){
				own=0.0f;
			}
			a1=a1+own;
			user.setOwn(own);
			Float follow=customerMapper.follow(userId,odey,nady);
			if (follow==null){
				follow=0.0f;
			}

			b1=b1+follow;
			user.setFollow(follow);
			Integer befollowed=customerMapper.befollowed(userId);
			if (befollowed==null){
				befollowed=0;
			}
			c1=c1+befollowed;
			user.setBefollowed(befollowed);
			String a = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			String b = new SimpleDateFormat("yyyy-MM").format(new Date());
			user.setSort(b+"-01"+"至"+a);
		}
		aa.setA(a1);
		aa.setB(b1);
		aa.setC(c1);



		Integer levels=customerMapper.selectSale(i);
		if(levels==3){
			Double  sales= (a1*0.03*0.85*0.01);
			Double commission=(b1*0.035*0.85);
			aa.setCommission(df.format(commission));
			aa.setSales(df.format(sales));
			aa.setTotal(df.format(sales+commission));
		}else if(levels==2){
			Float owns= customerMapper.owns(i,odey,nady);
			if (owns==null){
				owns=0.0f;
			}


			Float follows=customerMapper.follows(i,odey,nady);
			if (follows==null){
				follows=0.0f;
			}

			Double  sales= (a1*0.03*0.85*0.01+owns*0.03*0.12);
			Double commission=(b1*0.035*0.85+follows*0.035*0.12);
			aa.setCommission(df.format(commission));
			aa.setSales(df.format(sales));
			aa.setTotal(df.format(sales+commission));
		}else if(levels==1 || levels==0 ){
			Float owns= customerMapper.owns(i,odey,nady);
			if (owns==null){
				owns=0.0f;
			}

			Float follows=customerMapper.follows(i,odey,nady);
			if (follows==null){
				follows=0.0f;
			}
			Float owns1= customerMapper.owns1(i,odey,nady);
			if (owns1==null){
				owns1=0.0f;
			}

			Float follows1=customerMapper.follows1(i,odey,nady);
			if (follows1==null){
				follows1=0.0f;
			}
			Double  sales= (a1*0.03*0.85*0.01+owns*0.03*0.12+owns1*0.03*0.03);
			Double commission=(b1*0.035*0.85+follows*0.035*0.12+follows1*0.035*0.03);
			aa.setCommission(df.format(commission));
			aa.setSales(df.format(sales));
			aa.setTotal(df.format(sales+commission));
		}
		aa.setDailyRankingsList(userList);
		return aa;
	}


}

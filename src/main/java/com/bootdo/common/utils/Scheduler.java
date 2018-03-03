package com.bootdo.common.utils;

import com.bootdo.common.dao.TimedTaskMapper;
import com.bootdo.common.domain.DailyRankings;
import com.bootdo.users.domain.SaleUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class Scheduler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    TimedTaskMapper timedTaskMapper;
    @Scheduled(cron="0 0/1 * * * ?") //每分钟执行一次
    public void aaaa() {
        logger.info("每分钟执行一次。开始……");



        logger.info("每分钟执行一次。结束。");
    }
     //每日的销售排行
    @Scheduled(cron="0 44 20 * * ?")
    //  @Scheduled(cron="0 0/1 * * * ?") //每分钟执行一次
    public void testTasks() {

        List<SaleUser> saleList=timedTaskMapper.saleList();
        for (SaleUser user :saleList){
            DailyRankings dailyRankings =new DailyRankings();
            dailyRankings.setSale(user.getPhone());
            dailyRankings.setManager(user.getUserName());
            Integer id=user.getUserId();
            String data="20171208";
            // 自购量 private  Float own;
            Float own=timedTaskMapper.own(id,data);
            if (own==null){
                own=0.0F;
            }
            dailyRankings.setSaleid(id);
            dailyRankings.setOwn(own);
            // 跟单量 private  Float follow;
            Float follow=timedTaskMapper.follow(id,data);
            if (follow==null){
                follow=0.0F;
            }
            dailyRankings.setFollow(follow);
            // 总销售  private  Float   total;
            Float   total=(own+follow);
            // 开户数 private  Integer openaccount;
            dailyRankings.setTotal(total);
            Integer openaccount= timedTaskMapper.openaccount(id);
            dailyRankings.setOpenaccount(openaccount);
            // 消费数 private  Integer consumption;
            Integer consumption= timedTaskMapper.consumption(id);
            dailyRankings.setConsumption(consumption);
            // 被跟单量 private  Float befollowed;
            Integer befollowed= timedTaskMapper.befollowed(id);
            dailyRankings.setBefollowed(befollowed);
            dailyRankings.setTimeentry(user.getTime());
            dailyRankings.setNewtime(new Date());
            String sort = new SimpleDateFormat("yyyyMMdd").format(new Date());
            dailyRankings.setSort(sort);
            timedTaskMapper.insert(dailyRankings);
        }




    }
    //每月的销售排行
    @Scheduled(cron="0 44 20 * * ?")
    public void month() {
        logger.info("每啊啊啊分钟执行一次。开始……");
        List<SaleUser> saleList=timedTaskMapper.saleList();
        for (SaleUser user :saleList){
            DailyRankings dailyRankings =new DailyRankings();
            dailyRankings.setSale(user.getPhone());
            dailyRankings.setManager(user.getUserName());
            Integer id=user.getUserId();
//            String sort = new SimpleDateFormat("yyyyMM").format(new Date());
//            System.out.println(sort+"00");
//            System.out.println(sort+"32");
            String odata="20171200";
            String ndata="20171232";
            // 自购量 private  Float own;
            Float own=timedTaskMapper.monthown(id,odata,ndata);
            if (own==null){
                own=0.0F;
            }
            dailyRankings.setSaleid(id);
            dailyRankings.setOwn(own);
            // 跟单量 private  Float follow;
            Float follow=timedTaskMapper.monthfollow(id,odata,ndata);
            if (follow==null){
                follow=0.0F;
            }
            dailyRankings.setFollow(follow);
            // 总销售  private  Float   total;
            Float   total=(own+follow);
            // 开户数 private  Integer openaccount;
            dailyRankings.setTotal(total);
            Integer openaccount= timedTaskMapper.openaccount(id);
            dailyRankings.setOpenaccount(openaccount);
            // 消费数 private  Integer consumption;
            Integer consumption= timedTaskMapper.consumption(id);
            dailyRankings.setConsumption(consumption);
            // 被跟单量 private  Float befollowed;
            Integer befollowed= timedTaskMapper.befollowed(id);
            dailyRankings.setBefollowed(befollowed);
            dailyRankings.setTimeentry(user.getTime());
            dailyRankings.setNewtime(new Date());
            String sort = new SimpleDateFormat("yyyyMMdd").format(new Date());
            dailyRankings.setSort(sort);
            timedTaskMapper.monthInsert(dailyRankings);
        }

        logger.info("每啊啊啊分钟执行一次。开始……");


    }

//    public static void main(String[] args){
//        String sort = new SimpleDateFormat("yyyyMM").format(new Date());
//        System.out.println(sort+"00");
//        System.out.println(sort+"32");
//    }

}
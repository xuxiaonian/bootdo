package com.bootdo.customer.dao;

import com.bootdo.common.domain.DailyRankings;
import com.bootdo.customer.domain.*;

import org.apache.ibatis.annotations.*;

import java.util.List;
;

public interface CustomerMapper {


	
	@Select("<script>" +
			" select a.ORDER_ID as orderId ,  a.order_amount as orderAmount ,a.PROGRAM_ID as prId,a.ORDER_STATUS as orderStatus ,a.BONUS_FLAG as bonus " +
			" ,a.BUY_TIMESTAMP as buyTime ,a.ISFOLLOW as isFollow, b.USER_NAME as userName " +
			" from GPC.TB_ORDER_INFO a  LEFT JOIN act.tb_user_info b on a.USER_ID=b.USER_ID " +
			" where a.user_id in (select user_id from act.tb_user_info where sale_id =#{id}) "+
			"</script>")
	List<Order> list(Integer id);

	@Select(
	" select COUNT(a.ORDER_ID ) from GPC.TB_ORDER_INFO a  where a.user_id in (select user_id from act.tb_user_info where sale_id =#{id}) "
			)
	int count(Integer id);

	@Select("<script>" +
			" SELECT a.PROGRAM_ID as pId ,a.ORDER_AMOUNT  as money ,b.SUB_LOTTERY_NAME as subName ,b.GAME_LIST as list " +
			" FROM GPC.TB_ORDER_INFO a  " +
			" LEFT JOIN GPC.TB_PROGRAM_INFO b ON a.PROGRAM_ID=b.PROGRAM_ID " +
			" WHERE a.ORDER_ID=#{id} " +
			"</script>")
	Details details (String  id);
	@Select("<script>" +
			" SELECT a.LOTTERY_ID as lotteryId,a.PLAY_TIME as payTime,a.HOST_TEAM as zname,a.GUEST_TEAM as kname, a.HOST_FULL_SCORE as zqf " +
			" ,a.HOST_HALF_SCORE as zbf, " +
			" a.GUEST_FULL_SCORE as kqf , " +
			" a.GUEST_HALF_SCORE as kbf " +
			" FROM GPC.TB_JC_GAME_INFO a  WHERE a.GAME_ID=#{id} " +

			"</script>")
	Match match (String  id);


//	体现
	@Select(" select COUNT(a.ORDER_ID ) from ACT.TB_ORDER_WITHDRAW a  where a.user_id in (select user_id from act.tb_user_info where sale_id =#{id}) ")
	int wcount(int i);
	@Select("<script>" +
			" select a.ORDER_ID as orderId ,a.ACCOUNT_NO as accountNo ,a.BANK_NAME as bank, a.BRANCH as branch ,a.ORDER_AMOUNT as amout ,a.FEE_AMOUNT as fee " +
			", a.CREATE_DAY as day ,a.ORDER_STATUS as status , b.USER_NAME as uname ,b.REAL_NAME as rname " +
			"  from ACT.TB_ORDER_WITHDRAW a " +
			"  LEFT JOIN act.tb_user_info b on a.USER_ID=b.USER_ID " +
			"  where a.user_id in (select user_id from act.tb_user_info where sale_id =#{id}) "+
			"</script>")
	List<Withdrawals> wlist(int i);


	@Select(" select COUNT(a.ORDER_ID ) FROM ACT.TB_ORDER_RECHARGE a LEFT JOIN act.tb_user_info b on a.USER_ID=b.USER_ID  WHERE b.PHONE=#{id} ")
	int ccount(String id);

	@Select("<script>" +
			" select a.ORDER_ID as orderId, a.CREATE_TIMESTAMP as time , a.ORDER_DESC as type ,a.ORDER_STATUS as staus ,a.ORDER_AMOUNT as amout, " +
			" a.FEE_AMOUNT as fee ,b.USER_NAME as uname " +
			" FROM ACT.TB_ORDER_RECHARGE a " +
			" LEFT JOIN act.tb_user_info b on a.USER_ID=b.USER_ID " +
			" WHERE b.PHONE=#{id} "+
			"</script>")
	List<Recharge> clist(String  id);


	@Select(" select a.USER_ID as saleid , a.USER_NAME as sale FROM  act.TB_USER_INFO a WHERE a.SALE_ID =#{id} ")
	List<DailyRankings> userList(int i);
	@Select(" select sum(a.ORDER_AMOUNT) from GPC.TB_ORDER_INFO a  where a.user_id =#{id}  and a.ORDER_STATUS=1 and a.ISFOLLOW=0 and a.START_DAY>#{oday} and #{nday}> a.START_DAY")
	  Float own(@Param("id")int i, @Param("oday")String oday, @Param("nday")String nday);


	@Select(" select sum(a.ORDER_AMOUNT) from GPC.TB_ORDER_INFO a  where a.user_id =#{id}  and a.ORDER_STATUS=1 and a.ISFOLLOW=1 and a.START_DAY>#{oday} and #{nday}> a.START_DAY")
	Float  follow(@Param("id")int i,@Param("oday")String oday, @Param("nday")String nday);

	@Select(" select sum(b.FOLLOW_COUNT)   from GPC.TB_ORDER_INFO a  LEFT JOIN GPC.TB_PROGRAM_RELEASE b on a.PROGRAM_ID=b.PROGRAM_ID where a.user_id in (select user_id from act.tb_user_info where sale_id =#{id}) and a.ORDER_STATUS=1 and a.ISFOLLOW=1 ")
	Integer befollowed (@Param("id")Integer id);
}

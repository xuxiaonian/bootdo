package com.bootdo.common.dao;

import java.util.List;
import java.util.Map;

import com.bootdo.common.domain.DailyRankings;
import com.bootdo.users.domain.SaleUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TimedTaskMapper {
	@Select("select a.GMT_CREATE as time ,  a.NAME as phone , a.USER_ID  as userId ,b.NAME as userName from C_SYS_USER a LEFT JOIN C_SYS_USER b on a.PARENT_ID=b.USER_ID  ")
	List<SaleUser> saleList();
	@Select(" select sum(a.ORDER_AMOUNT) from GPC.TB_ORDER_INFO a  where a.user_id in (select user_id from act.tb_user_info where sale_id =#{id} ) and a.ORDER_STATUS=1 and a.ISFOLLOW=0 and a.START_DAY=#{data}  ")
	Float own (@Param("id")Integer id,@Param("data") String data);
	@Select(" select sum(a.ORDER_AMOUNT) from GPC.TB_ORDER_INFO a  where a.user_id in (select user_id from act.tb_user_info where sale_id =#{id} ) and a.ORDER_STATUS=1 and a.ISFOLLOW=1 and a.START_DAY=#{data}  ")
	Float follow (@Param("id")Integer id,@Param("data") String data);
	@Select(" select COUNT(user_id) from act.tb_user_info where sale_id =#{id} ")
	Integer openaccount (@Param("id")Integer id);
	@Select(" select count(a.user_id) from act.tb_user_info a LEFT JOIN  act.TB_USER_ACT b on a.USER_ID=b.USER_ID where a.sale_id =#{id} and b.ACT_TYPE=2000 and  b.BALANCE>0 ")
	Integer consumption (@Param("id")Integer id);
	@Select(" select sum(b.FOLLOW_COUNT)   from GPC.TB_ORDER_INFO a  LEFT JOIN GPC.TB_PROGRAM_RELEASE b on a.PROGRAM_ID=b.PROGRAM_ID where a.user_id in (select user_id from act.tb_user_info where sale_id =#{id}) and a.ORDER_STATUS=1 and a.ISFOLLOW=1 ")
	Integer befollowed (@Param("id")Integer id);

	@Insert("INSERT INTO C_DAILYRANKINGS(SORT ,SALE, SALEID, MANAGER, OWN, FOLLOW, TOTAL, BEFOLLOWED, OPENACCOUNT, CONSUMPTION, TIMEENTRY, NEWTIME) " +
			" VALUES(#{sort},#{sale},#{saleid}, #{manager}, #{own}, #{follow}, #{total}, #{befollowed}, #{openaccount}, #{consumption}, #{timeentry}, #{newtime} )")
	Integer insert(DailyRankings dailyRankings);

	@Insert("INSERT INTO C_MONTHLYRANKINGS(SORT ,SALE, SALEID, MANAGER, OWN, FOLLOW, TOTAL, BEFOLLOWED, OPENACCOUNT, CONSUMPTION, TIMEENTRY, NEWTIME) " +
			" VALUES(#{sort},#{sale},#{saleid}, #{manager}, #{own}, #{follow}, #{total}, #{befollowed}, #{openaccount}, #{consumption}, #{timeentry}, #{newtime} )")
	Integer monthInsert(DailyRankings dailyRankings);
	@Select(" select sum(a.ORDER_AMOUNT) from GPC.TB_ORDER_INFO a  where a.user_id in (select user_id from act.tb_user_info where sale_id =#{id} ) and a.ORDER_STATUS=1 and a.ISFOLLOW=0 and a.START_DAY>#{odata} and #{ndata}> a.START_DAY")
	Float monthown (@Param("id")Integer id,@Param("odata") String odata,@Param("ndata") String ndata);
	@Select(" select sum(a.ORDER_AMOUNT) from GPC.TB_ORDER_INFO a  where a.user_id in (select user_id from act.tb_user_info where sale_id =#{id} ) and a.ORDER_STATUS=1 and a.ISFOLLOW=1 and a.START_DAY>#{odata} and #{ndata}> a.START_DAY ")
	Float monthfollow (@Param("id")Integer id,@Param("odata") String odata,@Param("ndata") String ndata);
}

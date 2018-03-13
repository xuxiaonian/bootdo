package com.bootdo.wall.dao;

import com.bootdo.wall.domain.Wall;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WallMapper {

	@Select(" select * from ( SELECT rownum rn, a.USER_NAME ,a.CREATE_TIMESTAMP as time ,b.NAME as sale FROM act.TB_USER_INFO a LEFT JOIN C_SYS_USER b ON a.SALE_ID=b.USER_ID " +
			" WHERE a.SALE_ID  is NOT NULL order by CREATE_TIMESTAMP desc )  aaa   where rn <= 5 ")
	List<Wall> openUserList();

	@Select("<script>" +
			" SELECT a.counts ,b.NAME as sale  FROM (SELECT SALE_ID, count(SALE_ID)as counts FROM act.TB_USER_INFO where  SALE_ID  is NOT NULL GROUP BY SALE_ID) a  LEFT JOIN C_SYS_USER b ON a.SALE_ID=b.USER_ID " +
			"</script>")
	List<Wall> saleList();


//	消费
	@Select(" select * from ( SELECT rownum rn,  a.BUY_TIMESTAMP as time ,  a.ORDER_AMOUNT as money ,b.USER_NAME as userName ,c.name as sale from  gpc.TB_ORDER_INFO a " +
			" LEFT JOIN act.TB_USER_INFO b on a.USER_ID=b.USER_ID LEFT JOIN C_SYS_USER c on c.USER_ID=b.SALE_ID " +
			" WHERE a.ORDER_STATUS=1  order by a.BUY_TIMESTAMP desc) aaa where rn<=10 ")
	List<Wall> consumeList();
//	充值
	@Select(" select * from ( SELECT rownum rn,  a.CREATE_TIMESTAMP as time ,  a.ORDER_AMOUNT as money ,b.USER_NAME as userName ,c.name as sale from  ACT.TB_ORDER_RECHARGE a " +
			" LEFT JOIN act.TB_USER_INFO b on a.USER_ID=b.USER_ID LEFT JOIN C_SYS_USER c on c.USER_ID=b.SALE_ID " +
			" WHERE a.ORDER_STATUS=2  order by a.CREATE_TIMESTAMP desc) aaa where rn<=10 ")
	List<Wall> rechargeList();
}

package com.bootdo.users.dao;

import com.bootdo.users.domain.SaleUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UsersMapper {




	@Select(
			" select c.email as email , c.qq as qq , c.weixin as weixin , c.USER_ID as userId ,c.NAME as userName ,c.USERNAME as phone ,c.GMT_CREATE as time , a.NAME as srole ,b.NAME as spname from c_sys_user c " +
			" LEFT JOIN C_ROLE a ON a.ID=c.ROLE " +
			" LEFT JOIN c_sys_user b on b.USER_ID=c.PARENT_ID where  c.USER_ID=#{user} "
			)
	SaleUser user(Integer user);
	@Select(
			" select c.PASSWORD as email   from c_sys_user c " +
			"  where c.USER_ID=#{user} ")
	SaleUser pass(Integer user);
	@Update("<script>"+
			"update  c_sys_user  set PASSWORD = #{password}" +
			"where USER_ID = #{userId}"+
			"</script>")
	Integer updatePass(@Param("userId")Integer userId, @Param("password")String password);
	@Update("<script>"+
			"update c_sys_user set NAME = #{name}, USERNAME = #{userName}, QQ = #{qq}, WEIXIN = #{weixin}, EMAIL = #{email} where USER_ID = #{userId}"+
			"</script>")
    Integer updateUser(SaleUser saleUser);
}

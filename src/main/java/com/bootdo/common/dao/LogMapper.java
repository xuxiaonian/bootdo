package com.bootdo.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import com.bootdo.common.domain.SysLogDO;
@Mapper
public interface LogMapper {

	
	@Select("<script>" +
	"select * from c_sys_log " +
			"</script>")
	List<SysLogDO> list(Map<String,Object> map);

	@Select("select count(*) from c_sys_log")
	int count();

	@Insert("insert into c_sys_log (user_id)"
			+ "values ( 1 )")
	int save(SysLogDO log);

	@Update("<script>" + "update sys_log " + "<set>" + "<if test=\"userId != null\">`user_id` = #{userId}, </if>"
			+ "<if test=\"username != null\">`username` = #{username}, </if>"
			+ "<if test=\"operation != null\">`operation` = #{operation}, </if>"
			+ "<if test=\"time != null\">`time` = #{time}, </if>"
			+ "<if test=\"method != null\">`method` = #{method}, </if>"
			+ "<if test=\"params != null\">`params` = #{params}, </if>" + "<if test=\"ip != null\">`ip` = #{ip}, </if>"
			+ "<if test=\"gmtCreate != null\">`gmt_create` = #{gmtCreate}</if>" + "</set>" + "where id = #{id}"
			+ "</script>")
	int update(SysLogDO log);

	@Delete("delete from sys_log where id =#{id}")
	int remove(Long id);

	@Delete("<script>" + "delete from sys_log where id in "
			+ "<foreach collection=\"list\" index=\"i\" open=\"(\" separator=\",\" close=\")\" item=\"item\"  >#{item}</foreach>"
			+ "</script>")
	int batchRemove(List<Long> list);
}

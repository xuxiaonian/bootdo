package com.bootdo.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.bootdo.system.domain.SysUserDO;
@Mapper
public interface UserMapper {
	@Select("select * from C_SYS_USER where USERNAME = #{phone}")
	List<SysUserDO> list (String  phone);
}

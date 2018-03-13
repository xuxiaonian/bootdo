package com.bootdo.system.dao;

import java.util.List;

import com.bootdo.system.domain.SysUserDO;
import org.apache.ibatis.annotations.*;

import com.bootdo.system.domain.MenuDO;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Mapper
@Order(1)
@Component("menuMapper")
public interface MenuMapper {


	@Select("select  RUL.ID as menuId  , RUL.PARENT_ID as parentId , RUL.MENU_NAME as name , RUL.MENU_URL as url , RUL.ICON as icon , RUL.WEIGHT as orderNum  from F_MENU_URL RUL " +
			"WHERE RUL.STYLE=1 and RUL.STATE=1" )
	List<MenuDO> menuList(Integer id);
	@Select("select * from C_SYS_USER where USERNAME = #{phone}")
	List<SysUserDO> list (String  phone);
}

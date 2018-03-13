package com.bootdo.system.service.impl;


import java.util.List;

import com.bootdo.customer.dao.CustomerMapper;
import com.bootdo.system.dao.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootdo.system.dao.UserMapper;

import com.bootdo.system.domain.SysUserDO;

import com.bootdo.system.service.UserService;

@Transactional
@Service
public class UserServiceImp implements UserService {
	@Autowired @Qualifier("menuMapper")
	MenuMapper menuMapper;

	@Override
	public List<SysUserDO> list(String phone) {

		return menuMapper.list(phone);
	}


}

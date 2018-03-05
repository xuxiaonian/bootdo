package com.bootdo.users.service.impl;



import com.bootdo.common.utils.StringTools;
import com.bootdo.users.dao.UsersMapper;


import com.bootdo.users.domain.SaleUser;
import com.bootdo.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Transactional
@Service
public class UserserviceImp implements UsersService {

	@Autowired
	UsersMapper usersMapper;


	@Override
	public SaleUser user(Integer user) {
		return usersMapper.user(user);
	}

	@Override
	public SaleUser pass(Integer user) {
		return usersMapper.pass(user);
	}

	@Override
	public Integer updatePass(Integer userId, String password) {

		password= StringTools.MD5EncodeToHex(password);
		return usersMapper.updatePass(userId,password);
	}

	@Override
	public Integer updateUser(SaleUser saleUser) {
		return usersMapper.updateUser(saleUser);
	}
}

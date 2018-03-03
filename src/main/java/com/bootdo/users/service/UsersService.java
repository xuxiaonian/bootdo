package com.bootdo.users.service;


import com.bootdo.users.domain.SaleUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public interface UsersService {

	 SaleUser user(Integer user);
	 SaleUser pass(Integer user);
	 Integer updatePass(Integer userId,String password);
	Integer updateUser(SaleUser saleUser);
}

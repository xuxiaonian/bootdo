package com.bootdo.system.controller;


import com.bootdo.system.domain.SysUserDO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;


import com.bootdo.system.service.UserService;

import java.util.List;

@RequestMapping("/sys/user")
@Controller
public class UserController {
	@Autowired
	UserService userService;


	@RequiresPermissions("sys:user:user")
	@GetMapping("")
	String user(Model model) {
		List<SysUserDO>ss=userService.list("111111111");
		return "sys/user/user";
	}



}

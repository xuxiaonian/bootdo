package com.bootdo.users.controller;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;


import com.bootdo.users.domain.SaleUser;
import com.bootdo.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@RequestMapping("/users/manage")
@Controller
public class UsersController {
	@Autowired
	UsersService userService;



	@GetMapping("")
	String user(Model model) {
		return "users/userslist";
	}



	@GetMapping("/update")
	String update(HttpServletRequest request, Model model) {
		String user=request.getSession().getAttribute("user").toString();
		SaleUser use=userService.user(Integer.parseInt(user));
		model.addAttribute("user",use);
		return "users/update";
	}
	@PostMapping("/check")
	String check(String keyWord,HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		String user=request.getSession().getAttribute("user").toString();
		SaleUser pass=userService.pass(Integer.parseInt(user));
		String outs="1";
		String password=pass.getEmail();
		if(password!=null){
			outs="0";
		}
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.print(outs);
		out.flush();
		out.close();
		return null;
	}
	@GetMapping("/updatePass")
	String updatePass(HttpServletRequest request, Model model) {
		String user=request.getSession().getAttribute("user").toString();
		SaleUser use=userService.user(Integer.parseInt(user));
		model.addAttribute("user",use);
		return "users/updatePass";
	}
	@PostMapping("/updatePa")
	void updatePa(Integer userId,String password, HttpServletResponse response) throws IOException {
		Integer ss= userService.updatePass(userId,password);
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.print(ss);
		out.flush();
		out.close();
	}
	@PostMapping("/updates")
	void updates(SaleUser saleUser, HttpServletResponse response) throws IOException {
		Integer ss= userService.updateUser(saleUser);
		try {
			response.sendRedirect("/users/manage/update");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

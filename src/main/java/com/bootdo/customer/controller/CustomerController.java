package com.bootdo.customer.controller;

import com.bootdo.common.domain.DailyRankings;
import com.bootdo.common.utils.PageUtils;

import com.bootdo.customer.domain.*;
import com.bootdo.customer.service.CustomerService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RequestMapping("/customer")
@Controller
public class CustomerController {
	@Autowired
	CustomerService customerService;



	@GetMapping("/buyList")
	String buyList(Model model) {

		return "customer/buyList";
	}

	@GetMapping("/buy")
	@ResponseBody
	PageUtils buy(HttpServletRequest request,@RequestParam Map<String, Object> params) {
		String user=request.getSession().getAttribute("user").toString();
		List<Order> list = customerService.list(Integer.parseInt(user),params);
		int total = customerService.total(Integer.parseInt(user));
		PageUtils pageUtil = new PageUtils(list, total);
		return pageUtil;
	}

	@GetMapping("/extractList")
	String extractList(Model model) {

		return "customer/extractList";
	}

	@GetMapping("/extract")
	@ResponseBody
	PageUtils extract(HttpServletRequest request, @RequestParam Map<String, Object> params) {
		String user=request.getSession().getAttribute("user").toString();
		List<Withdrawals> list = customerService.wlist(Integer.parseInt(user),params);
		int total = customerService.wtotal(Integer.parseInt(user));
		PageUtils pageUtil = new PageUtils(list, total);
		return pageUtil;


	}
	@GetMapping("/details")
	String details(String id,Model model) {
		Details details = customerService.details(id);
		model.addAttribute("details",details);
		return "customer/details";

	}

	@GetMapping("/capitalDetails")
	String capitalDetails(Model model) {

		return "customer/capitalDetailsList";
	}

	@GetMapping("/capital")
	@ResponseBody
	PageUtils capital(HttpServletRequest request, @RequestParam Map<String, Object> params) {

		List<Recharge> list = customerService.clist(params);
		int total = customerService.ctotal(params);
		PageUtils pageUtil = new PageUtils(list, total);
		return pageUtil;


	}
	@GetMapping("/achievement")
	String achievement(HttpServletRequest request,Model model) {
		String user=request.getSession().getAttribute("user").toString();
		Achievement achievement = customerService.achievement(Integer.parseInt(user));
		model.addAttribute("achievement",achievement);
		return "customer/achievement";
	}
}

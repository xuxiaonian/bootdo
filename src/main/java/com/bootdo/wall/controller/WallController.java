package com.bootdo.wall.controller;
import com.bootdo.wall.domain.Wall;
import com.bootdo.wall.service.WallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/wall")
@Controller
public class WallController {
	@Autowired
	WallService wallService;
	@GetMapping("/openUser")
	String wall(Model model) {
		List<Wall> openUserList=wallService.openUserList();
		model.addAttribute("openUserList",openUserList);
		List<Wall> saleList=wallService.saleList();
		model.addAttribute("saleList",saleList);
		return "wall/openUserList";
	}
	 @GetMapping("/carousel")
	  String carousel(Model model) {
		List<Wall> rechargeList=wallService.rechargeList();
		model.addAttribute("rechargeList",rechargeList);
		List<Wall> consumeList=wallService.consumeList();
		model.addAttribute("consumeList",consumeList);
		return "wall/carouselList";
	}




}

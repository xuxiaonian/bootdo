
package com.bootdo.customer.controller;

        import com.bootdo.common.domain.DailyRankings;
        import com.bootdo.customer.service.CustomerService;
        import com.bootdo.customer.service.RankingService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;

        import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.List;


@RequestMapping("/ranking")
@Controller
public class RankingController {
    @Autowired
    RankingService rankingService;



    @GetMapping("/daylidt")
    String buyList(Model model) {
        String sort = new SimpleDateFormat("yyyyMMdd").format(new Date());
        List <DailyRankings> dayList=rankingService.dayList(sort);
        model.addAttribute("dayList",dayList);
        return "ranking/daylist";
    }


    @GetMapping("/monthlidt")
    String extractList(Model model) {
        String sort = new SimpleDateFormat("yyyyMMdd").format(new Date());
        List <DailyRankings> monthList=rankingService.monthList(sort);
        model.addAttribute("monthList",monthList);
        return "ranking/monthlist";
    }



}

package com.bootdo.customer.service;


import com.bootdo.common.domain.DailyRankings;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface RankingService {


	List<DailyRankings> dayList(String sort);

	List<DailyRankings> monthList(String sort);
}

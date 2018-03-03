package com.bootdo.customer.service.impl;


import com.bootdo.common.domain.DailyRankings;
import com.bootdo.customer.dao.CustomerMapper;
import com.bootdo.customer.dao.RankingMapper;
import com.bootdo.customer.domain.*;
import com.bootdo.customer.service.CustomerService;
import com.bootdo.customer.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Transactional
@Service
public class RankingServiceImp implements RankingService {

	@Autowired
	RankingMapper rankingMapper;


	@Override
	public List<DailyRankings> dayList(String sort) {
		return rankingMapper.dayList(sort);
	}

	@Override
	public List<DailyRankings> monthList(String sort) {
		return rankingMapper.monthList(sort);
	}
}

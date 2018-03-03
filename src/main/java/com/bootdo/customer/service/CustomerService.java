package com.bootdo.customer.service;

import com.bootdo.common.domain.DailyRankings;
import com.bootdo.customer.domain.*;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


@Service
public interface CustomerService {

	List<Order> list(int i, Map<String, Object> params);
	Integer total(int i);

	Details details(String id);

	List<Withdrawals> wlist(int i, Map<String, Object> params);

	int wtotal(int i);

	List<Recharge> clist(Map<String, Object> params);

	int ctotal(Map<String, Object> params );

    Achievement achievement(int i);
}

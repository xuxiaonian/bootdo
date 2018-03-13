package com.bootdo.customer.dao;

import com.bootdo.common.domain.DailyRankings;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface RankingMapper {




	@Select(" select * FROM  C_DAILYRANKINGS WHERE SORT =#{sort} ")
	List<DailyRankings> dayList(String sort);
	@Select(" select * FROM  C_MONTHLYRANKINGS WHERE SORT =#{sort} ")
	List<DailyRankings> monthList(String sort);
}

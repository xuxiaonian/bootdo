package com.bootdo.wall.service;


import com.bootdo.wall.domain.Wall;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public interface WallService {
	List<Wall> openUserList();
	List<Wall> saleList();

	List<Wall> rechargeList();

	List<Wall> consumeList();
}

package com.bootdo.wall.service.impl;


import com.bootdo.wall.dao.WallMapper;
import com.bootdo.wall.domain.Wall;
import com.bootdo.wall.service.WallService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class WallServiceImp implements WallService {

    @Autowired
    WallMapper wallMapper;

    @Override
    public List<Wall> openUserList() {
      return wallMapper.openUserList();
//        return null;
    }

    @Override
    public List<Wall> saleList() {
     return wallMapper.saleList();
//        return null;
    }

    @Override
    public List<Wall> rechargeList() {
        return  wallMapper.rechargeList();
    }

    @Override
    public List<Wall> consumeList() {
        return wallMapper.consumeList();
    }
}

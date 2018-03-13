package com.bootdo.system.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bootdo.common.utils.Query;
import org.springframework.stereotype.Service;

import com.bootdo.system.domain.SysUserDO;
@Service
public interface UserService {

    List<SysUserDO> list(String phone);

}

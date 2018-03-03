package com.bootdo.system.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bootdo.common.utils.Query;
import org.springframework.stereotype.Service;

import com.bootdo.system.domain.SysUserDO;
@Service
public interface UserService {
	SysUserDO get(Long id);


    List<SysUserDO> list(String phone);
	List<SysUserDO> list(Query phone);
    int count(Map<String, Object> map);
	int save(SysUserDO user);
	int update(SysUserDO user);
	int remove(Long userId);
	int batchremove(List<Long> userIds);
	boolean exit(Map<String, Object> params);

	boolean exit(String phone);

	Set<String> listRoles(Long userId);
	int resetPwd(SysUserDO user);
}

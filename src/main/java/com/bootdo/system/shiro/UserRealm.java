package com.bootdo.system.shiro;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.bootdo.common.utils.EdsUtil;
import com.bootdo.common.utils.StringTools;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.system.dao.UserMapper;
import com.bootdo.system.domain.SysUserDO;
import com.bootdo.system.service.MenuService;

public class UserRealm extends AuthorizingRealm {
	@Autowired
	UserMapper userMapper;
	@Autowired
	MenuService menuService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		Long userId = ShiroUtils.getUserId();
		Set<String> perms = menuService.listPerms(userId);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(perms);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		Map<String, Object> map  = new HashMap<>();
		map.put("username", username);
		String password = new String((char[]) token.getCredentials());

		// 查询用户信息

		SysUserDO user = userMapper.list(username).get(0);


		if (user == null) {
			throw new UnknownAccountException("账号不正确");
		}
		String pass= EdsUtil.decryptBasedDes(user.getPassword());
		// 密码错误
		if (!pass.equals(password)) {
			throw new IncorrectCredentialsException("密码不正确");
		}

		// 账号锁定
		if (user.getStatus() == 0) {
			throw new LockedAccountException("账号已被锁定,请联系管理员");
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
		return info;
	}

}

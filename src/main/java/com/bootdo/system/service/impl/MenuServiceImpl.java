package com.bootdo.system.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.bootdo.common.domain.Tree;
import com.bootdo.common.utils.BuildTree;
import com.bootdo.system.dao.MenuMapper;
import com.bootdo.system.dao.RoleMenuMapper;
import com.bootdo.system.domain.MenuDO;
import com.bootdo.system.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	MenuMapper menuMapper;
	@Autowired
	RoleMenuMapper roleMenuMapper;






	@Override
	public List<Tree<MenuDO>> listMenuTree(Integer id) {
		List<Tree<MenuDO>> trees = new ArrayList<Tree<MenuDO>>();
		List<MenuDO> menuDOs = menuMapper.menuList(id);
		for (MenuDO sysMenuDO : menuDOs) {
			Tree<MenuDO> tree = new Tree<MenuDO>();
			tree.setId(sysMenuDO.getMenuId().toString());
			tree.setParentId(sysMenuDO.getParentId().toString());
			tree.setText(sysMenuDO.getName());
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("url", sysMenuDO.getUrl());
			attributes.put("icon", sysMenuDO.getIcon());
			tree.setAttributes(attributes);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		List<Tree<MenuDO>> list = BuildTree.buildList(trees,"0");
		return list;
	}

	@Override
	public Tree<MenuDO> getTree() {
		return null;
	}

	@Override
	public Tree<MenuDO> getTree(Long id) {
		return null;
	}

	@Override
	public List<MenuDO> list() {
		return null;
	}

	@Override
	public int remove(Long id) {
		return 0;
	}

	@Override
	public int save(MenuDO menu) {
		return 0;
	}

	@Override
	public int update(MenuDO menu) {
		return 0;
	}

	@Override
	public MenuDO get(Long id) {
		return null;
	}

	@Override
	public Set<String> listPerms(Long userId) {
		return null;
	}

}

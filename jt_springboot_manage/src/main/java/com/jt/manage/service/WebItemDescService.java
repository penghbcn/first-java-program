package com.jt.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.manage.mapper.ItemDescMapper;
import com.jt.manage.pojo.ItemDesc;

@Service
public class WebItemDescService {
	@Autowired
	private ItemDescMapper itemDescMapper;

	public ItemDesc findItemDescById(Long itemId) {
		System.out.println("已进入后台");
		return itemDescMapper.selectByPrimaryKey(itemId);
	}

}

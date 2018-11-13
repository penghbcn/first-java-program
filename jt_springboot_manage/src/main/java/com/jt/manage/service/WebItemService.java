package com.jt.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.manage.mapper.ItemMapper;
import com.jt.manage.pojo.Item;

@Service
public class WebItemService {
	@Autowired
	private ItemMapper itemMapper;

	public Item findItemById(Long itemId) {
		return itemMapper.selectByPrimaryKey(itemId);
	}

}

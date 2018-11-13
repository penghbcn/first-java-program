package com.jt.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.vo.SysResult;
import com.jt.manage.mapper.ItemDescMapper;
import com.jt.manage.pojo.ItemDesc;

@Service
public class ItemDescService {
	@Autowired
	private ItemDescMapper itemDescMapper;

	public SysResult findItemDescByItemId(Long itemId) {
		try {
			ItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);
			return SysResult.oK(itemDesc);
		} catch (Exception e) {
			e.printStackTrace();
			return SysResult.build(201, e.getMessage());
		}
	}
}

package com.jt.manage.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;
import com.jt.manage.mapper.ItemDescMapper;
import com.jt.manage.mapper.ItemMapper;
import com.jt.manage.pojo.Item;
import com.jt.manage.pojo.ItemDesc;

@Service
public class ItemService {

	@Autowired
	private ItemMapper itemMapper;

	public EasyUIResult findItemList(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<Item> itemList = itemMapper.selectAll();
		PageInfo<Item> pageInfo = new PageInfo<>(itemList);
		EasyUIResult easyUIResult = new EasyUIResult();
		easyUIResult.setTotal((int) pageInfo.getTotal());
		easyUIResult.setRows(pageInfo.getList());
		return easyUIResult;
	}

	@Autowired
	private ItemDescMapper itemDescMapper;

	public SysResult saveItem(Item item, String desc) {
		try {
			// 插入item表
			item.setStatus(1);
			item.setCreated(new Date());
			item.setUpdated(item.getCreated());
			itemMapper.insert(item);
			// 插入item_desc表
			ItemDesc itemDesc = new ItemDesc();
			itemDesc.setItemDesc(desc);
			itemDesc.setCreated(item.getCreated());
			itemDesc.setUpdated(item.getCreated());
			itemDesc.setItemId(item.getId());
			itemDescMapper.insert(itemDesc);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
			return SysResult.build(201, e.getMessage());
		}
	}

	public SysResult updateItem(Item item, String desc) {
		try {
			item.setUpdated(new Date());
			itemMapper.updateByPrimaryKeySelective(item);

			ItemDesc itemDesc = new ItemDesc();
			itemDesc.setItemId(item.getId());
			itemDesc.setItemDesc(desc);
			itemDesc.setUpdated(item.getUpdated());
			itemDescMapper.updateByPrimaryKeySelective(itemDesc);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
			return SysResult.build(201, e.getMessage());
		}
	}

	public SysResult deleteItem(Long[] ids) {
		try {
			for (Long id : ids) {
				itemMapper.deleteByPrimaryKey(id);
				itemDescMapper.deleteByPrimaryKey(id);
			}
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
			return SysResult.build(201, e.getMessage());
		}
	}
}

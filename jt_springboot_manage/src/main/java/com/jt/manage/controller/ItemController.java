package com.jt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.Item;
import com.jt.manage.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping("item/query")
	@ResponseBody
	public EasyUIResult findItemList(Integer page, Integer rows) {
		EasyUIResult itemList = itemService.findItemList(page, rows);
		return itemList;
	}

	@RequestMapping("item/save")
	@ResponseBody
	public SysResult saveItem(Item item, String desc) {
		SysResult sysResult = itemService.saveItem(item, desc);
		return sysResult;
	}

	@RequestMapping("item/update")
	@ResponseBody
	public SysResult updateItem(Item item, String desc) {
		SysResult sysResult = itemService.updateItem(item, desc);
		return sysResult;
	}

	@RequestMapping("item/delete")
	@ResponseBody
	public SysResult deleteItem(Long[] ids) {
		SysResult sysResult = itemService.deleteItem(ids);
		return sysResult;
	}

}

package com.jt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.SysResult;
import com.jt.manage.service.ItemDescService;

@Controller
public class ItemDescController {
	@Autowired
	private ItemDescService itemDescService;

	@RequestMapping("item/query/item/desc/{itemId}")
	@ResponseBody
	public SysResult findItemDescByItemId(@PathVariable Long itemId) {
		SysResult sysResult = itemDescService.findItemDescByItemId(itemId);
		return sysResult;
	}
}

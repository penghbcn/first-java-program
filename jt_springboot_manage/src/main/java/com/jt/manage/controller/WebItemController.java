package com.jt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.manage.pojo.Item;
import com.jt.manage.service.WebItemService;

@Controller
public class WebItemController {
	@Autowired
	private WebItemService webItemService;

	@RequestMapping("items/{itemId}")
	@ResponseBody
	public Item findItemById(@PathVariable Long itemId) {
		return webItemService.findItemById(itemId);
	}
}

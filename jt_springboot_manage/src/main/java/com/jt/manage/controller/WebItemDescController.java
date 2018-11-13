package com.jt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.manage.pojo.ItemDesc;
import com.jt.manage.service.WebItemDescService;

@RestController
public class WebItemDescController {
	@Autowired
	private WebItemDescService webItemDescService;

	@RequestMapping("/desc/{itemId}")
	public ItemDesc getItemDesc(@PathVariable Long itemId) {
		ItemDesc itemDesc = webItemDescService.findItemDescById(itemId);
		return itemDesc;
	}
}

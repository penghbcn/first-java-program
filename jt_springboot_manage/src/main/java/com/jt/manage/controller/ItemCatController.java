package com.jt.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.manage.pojo.ItemCat;
import com.jt.manage.service.ItemCatService;

@Controller
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;

	@RequestMapping("findAllItemCat")
	@ResponseBody
	public List<ItemCat> findAllItemCat() {
		List<ItemCat> itemCatList = itemCatService.findAllItemCat();
		return itemCatList;
	}

	/*
	 * 商品分类树展示
	 */
	@RequestMapping("item/cat/list")
	@ResponseBody
	public List<ItemCat> findListByParentId(@RequestParam(defaultValue = "0") Long id) {
		List<ItemCat> itemCatList = itemCatService.findListByParentId(id);
		return itemCatList;
	}
}

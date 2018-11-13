package com.jt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.manage.service.WebItemCatService;

@Controller
public class WebItemCatController {

	@Autowired
	private WebItemCatService webItemCatService;

	@RequestMapping("/web/itemcat/all")
	@ResponseBody
	public String getAllItemCat(String callback) {
		String jsonData = webItemCatService.getAllItemCat();
		return callback + "(" + jsonData + ")";
	}

}

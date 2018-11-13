package com.jt.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.manage.mapper.ItemCatMapper;
import com.jt.manage.pojo.ItemCat;
import com.jt.manage.pojo.ItemCatResult;
import com.jt.manage.util.ItemCatUtil;

@Service
public class WebItemCatService {
	private static final ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private ItemCatMapper itemCatMapper;

	public String getAllItemCat() {
		List<ItemCat> itemCatList = itemCatMapper.selectAll();
		ItemCatResult itemCatResult = ItemCatUtil.allItemCat(itemCatList);
		String jsonData = null;
		try {
			jsonData = mapper.writeValueAsString(itemCatResult);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonData;
	}
}

package com.jt.manage.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.redis.RedisService;
import com.jt.manage.mapper.ItemCatMapper;
import com.jt.manage.pojo.ItemCat;

@Service
public class ItemCatService {
	@Autowired
	private ItemCatMapper itemCatMapper;
	@Autowired
	private RedisService redisService;

	private final static ObjectMapper mapper = new ObjectMapper();

	public List<ItemCat> findAllItemCat() {
		/* List<ItemCat> itemCatList = itemCatMapper.findAllItemCat(); */
		List<ItemCat> itemCatList = itemCatMapper.selectAll();
		return itemCatList;
	}

	public List<ItemCat> findListByParentId(Long id) {
		String key = "ITEM_CAT_" + id;
		List<ItemCat> itemCatList = null;
		if (redisService.exists(key)) {
			String jsonData = redisService.get(key);
			JsonNode data = null;
			try {
				data = mapper.readTree(jsonData);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			if (data.isArray() && data.size() > 0) {
				try {
					itemCatList = mapper.readValue(data.traverse(),
							mapper.getTypeFactory().constructCollectionType(List.class, ItemCat.class));
				} catch (IOException e) {
					e.printStackTrace();
					return null;
				}
			}
		} else {
			ItemCat itemCat = new ItemCat();
			itemCat.setParentId(id);
			// 自动拼接所有的非null属性进行查询
			itemCatList = itemCatMapper.select(itemCat);
			try {
				String jsonData = mapper.writeValueAsString(itemCatList);
				redisService.set(key, jsonData);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		return itemCatList;
	}

}

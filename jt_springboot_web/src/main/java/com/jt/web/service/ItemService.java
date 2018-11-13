package com.jt.web.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.redis.RedisService;
import com.jt.common.service.HttpClientService;
import com.jt.web.pojo.Item;
import com.jt.web.pojo.ItemDesc;

@Service
public class ItemService {
	public static final ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private HttpClientService client;
	@Autowired
	private RedisService redisService;

	public Item getItem(Long itemId) {
		/*
		 * CloseableHttpClient client = HttpClients.createDefault(); String url
		 * = "http://manage.jt.com/items/" + itemId; HttpGet get = new
		 * HttpGet(url); CloseableHttpResponse response = null; try { response =
		 * client.execute(get); } catch (IOException e) { e.printStackTrace(); }
		 * HttpEntity entity = response.getEntity(); try { String jsonItem =
		 * EntityUtils.toString(entity); Item item = mapper.readValue(jsonItem,
		 * Item.class); return item; } catch (ParseException | IOException e) {
		 * e.printStackTrace(); } return null;
		 */
		String key = "ITEM_" + itemId;
		Item item = null;
		if (redisService.exists(key)) {
			System.out.println("商品信息进入缓存");
			String itemJson = redisService.get(key);
			try {
				item = mapper.readValue(itemJson, Item.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			String url = "http://manage.jt.com/items/" + itemId;
			System.out.println("商品信息未进入缓存");
			try {
				String itemJson = client.doGet(url);
				item = mapper.readValue(itemJson, Item.class);
				redisService.set(key, itemJson);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return item;
	}

	public ItemDesc getItemDesc(Long itemId) {
		String key = "ITEM_DESC_" + itemId;
		ItemDesc itemDesc = null;
		if (redisService.exists(key)) {
			System.out.println("商品desc进入缓存");
			try {
				itemDesc = mapper.readValue(redisService.get(key), ItemDesc.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("商品desc未进入缓存");
			String url = "http://manage.jt.com/desc/" + itemId;
			try {
				String itemDescJson = client.doGet(url);
				itemDesc = mapper.readValue(itemDescJson, ItemDesc.class);
				redisService.set(key, itemDescJson);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return itemDesc;
	}
}

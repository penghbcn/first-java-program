package com.jt.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.service.HttpClientService;
import com.jt.common.vo.SysResult;
import com.jt.web.pojo.Cart;
import com.jt.web.pojo.Item;

@Service
public class CartService {

	private static final ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private HttpClientService client;

	public List<Cart> myCart(Long userId) {
		String url = "http://cart.jt.com/cart/query/" + userId;
		SysResult result = null;
		try {
			String jsonData = client.doGet(url);
			result = mapper.readValue(jsonData, SysResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Cart> cartList = (List<Cart>) result.getData();
		return cartList;
	}

	public void addCart(Long userId, Long itemId, Integer num) {
		String url = "http://manage.jt.com/items/" + itemId;
		Item item;
		try {
			String itemJson = client.doGet(url);
			item = mapper.readValue(itemJson, Item.class);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("itemId", itemId);
		params.put("num", num);
		params.put("itemTitle", item.getTitle());
		params.put("itemImage", item.getImage().split(",")[0]);
		params.put("itemPrice", item.getPrice());
		url = "http://cart.jt.com/cart/save";
		try {
			client.doPost(url, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateNum(Long userId, Long itemId, Integer num) {
		String url = "http://cart.jt.com/cart/update/num/" + userId + "/" + itemId + "/" + num;
		try {
			client.doGet(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCart(Long userId, Long itemId) {
		String url = "http://cart.jt.com/cart/delete/" + userId + "/" + itemId;
		try {
			client.doGet(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

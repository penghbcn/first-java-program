package com.jt.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.order.mapper.OrderMapper;
import com.jt.order.pojo.Order;

@Service
public class OrderService {
	private static final ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private OrderMapper orderMapper;

	public String saveOrder(String orderJson) {
		Order order = null;
		try {
			order = mapper.readValue(orderJson, Order.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		String orderId = order.getUserId() + "" + System.currentTimeMillis();
		order.setOrderId(orderId);
		orderMapper.saveOrder(order);
		return orderId;
	}

	public Order queryOrder(String orderId) {
		return orderMapper.queryOrder(orderId);
	}

}

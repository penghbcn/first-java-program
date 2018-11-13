package com.jt.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.common.vo.SysResult;
import com.jt.order.pojo.Order;
import com.jt.order.service.OrderService;

@Service
public class OrderController {
	@Autowired
	private OrderService orderService;

	@RequestMapping("order/create")
	public SysResult orderCreate(@RequestBody String orderJson) {
		String orderId = orderService.saveOrder(orderJson);
		return SysResult.oK(orderId);
	}

	@RequestMapping("order/query/{orderId}")
	public Order queryOrder(@PathVariable String orderId) {
		Order order = orderService.queryOrder(orderId);
		return order;
	}
}

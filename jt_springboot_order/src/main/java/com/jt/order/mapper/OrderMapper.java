package com.jt.order.mapper;

import java.util.Date;

import com.jt.order.pojo.Order;

public interface OrderMapper {

	public void paymentOrder(Date date);

	public void saveOrder(Order order);

	public Order queryOrder(String orderId);

}

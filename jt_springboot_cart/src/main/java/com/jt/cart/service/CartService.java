package com.jt.cart.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.cart.mapper.CartMapper;
import com.jt.cart.pojo.Cart;

@Service
public class CartService {

	@Autowired
	private CartMapper cartMapper;

	public List<Cart> queryCartList(Long userId) {
		Cart cart = new Cart();
		cart.setUserId(userId);
		List<Cart> cartList = cartMapper.select(cart);
		return cartList;
	}

	public void saveCart(Cart cart) {
		Cart _cart = new Cart();
		_cart.setUserId(cart.getUserId());
		_cart.setItemId(cart.getItemId());
		Cart existsCart = cartMapper.selectOne(_cart);
		if (existsCart == null) {
			cart.setCreated(new Date());
			cart.setUpdated(cart.getCreated());
			cartMapper.insert(cart);
		} else {
			existsCart.setNum(existsCart.getNum() + cart.getNum());
			existsCart.setUpdated(new Date());
			cartMapper.updateByPrimaryKey(existsCart);
		}
	}

	public void updateCartNum(Long userId, Long itemId, Integer num) {
		Cart cart = new Cart();
		cart.setUserId(userId);
		cart.setItemId(itemId);
		cart.setNum(num);
		cart.setUpdated(new Date());
		cartMapper.updateByPrimaryKeySelective(cart);
	}

	public void deleteCart(Long userId, Long itemId) {
		Cart cart = new Cart();
		cart.setUserId(userId);
		cart.setItemId(itemId);
		cartMapper.delete(cart);
	}
}

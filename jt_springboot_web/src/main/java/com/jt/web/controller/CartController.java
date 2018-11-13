package com.jt.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.web.pojo.Cart;
import com.jt.web.service.CartService;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;

	@RequestMapping("cart/show")
	public String myCart(HttpServletRequest request, Model model) {
		// Long userId = 7L;
		Long userId = (Long) request.getAttribute("userId");
		List<Cart> cartList = cartService.myCart(userId);
		model.addAttribute("cartList", cartList);
		return "cart";
	}

	@RequestMapping("cart/add/{itemId}")
	public String addCart(@PathVariable Long itemId, Integer num, HttpServletRequest request) {
		Long userId = (Long) request.getAttribute("userId");
		cartService.addCart(userId, itemId, num);
		return "rediect:/cart/show.html";
	}

	@RequestMapping("update/num/{itemId}/{num}")
	public String updateNum(HttpServletRequest request, @PathVariable Long itemId, @PathVariable Integer num) {
		Long userId = (Long) request.getAttribute("userId");
		cartService.updateNum(userId, itemId, num);
		return "";
	}

	@RequestMapping("cart/delete/{itemId}")
	public String deleteCart(HttpServletRequest request, @PathVariable Long itemId) {
		Long userId = (Long) request.getAttribute("userId");
		cartService.deleteCart(userId, itemId);
		return "rediect:/cart/show.html";
	}
}

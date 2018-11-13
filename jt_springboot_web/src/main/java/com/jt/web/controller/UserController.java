package com.jt.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.util.CookieUtils;
import com.jt.common.vo.SysResult;
import com.jt.web.pojo.User;
import com.jt.web.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("user/register")
	public String goRegister() {
		return "register";
	}

	@RequestMapping("service/user/doRegister")
	@ResponseBody
	public SysResult doRegister(User user) {
		System.out.println("进入web注册UserController");
		SysResult sysResult = userService.doRegister(user);
		System.out.println(sysResult.getData());
		System.out.println("离开web注册UserController");
		return sysResult;
	}

	@RequestMapping("user/login")
	public String goLogin() {
		return "login";
	}

	@RequestMapping("service/user/doLogin")
	@ResponseBody
	public SysResult doLogin(User user, HttpServletRequest request, HttpServletResponse response) {
		String ticket = userService.doLogin(user);
		if (StringUtils.isNotEmpty(ticket)) {
			CookieUtils.setCookie(request, response, "JT_TICKET", ticket);
			return SysResult.oK();
		} else {
			return SysResult.build(201, "失败了");
		}
	}
}

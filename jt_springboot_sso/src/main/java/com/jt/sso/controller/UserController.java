package com.jt.sso.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.vo.SysResult;
import com.jt.sso.pojo.User;
import com.jt.sso.service.UserService;

@Controller
public class UserController {
	private static final ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private UserService userService;

	@RequestMapping("user/check/{param}/{type}")
	@ResponseBody
	public String check(@PathVariable String param, @PathVariable Integer type, String callback) throws Exception {
		Boolean exists = userService.check(param, type);
		System.out.println("SSo");
		SysResult result = SysResult.oK(exists);
		String jsonData = mapper.writeValueAsString(result);
		return callback + "(" + jsonData + ")";
	}

	@RequestMapping("user/register")
	@ResponseBody
	public SysResult register(User user) {
		System.out.println("进入SSO注册Controller");
		userService.register(user);
		return SysResult.oK(user.getUsername());
	}

	@RequestMapping("user/login")
	@ResponseBody
	public SysResult login(@RequestParam("u") String username, @RequestParam("p") String password) {
		SysResult result = userService.login(username, password);
		return result;
	}

	@RequestMapping("user/query/{ticket}")
	@ResponseBody
	public String query(@PathVariable String ticket, String callback) throws Exception {
		String userJson = userService.getUserJsonByTicket(ticket);
		SysResult result = SysResult.oK(userJson);
		String jsonData = mapper.writeValueAsString(result);
		if (StringUtils.isNotEmpty(callback)) {
			return callback + "(" + jsonData + ")";
		} else {
			return jsonData;
		}
	}
}

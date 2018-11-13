package com.jt.web.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.service.HttpClientService;
import com.jt.common.vo.HttpResult;
import com.jt.common.vo.SysResult;
import com.jt.web.pojo.User;

@Service
public class UserService {
	public static final ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private HttpClientService client;

	public SysResult doRegister(User user) {
		System.out.println("进入web注册UserService");
		String url = "http://sso.jt.com/user/register";
		Map<String, Object> params = new HashMap<>();
		params.put("username", user.getUsername());
		params.put("password", user.getPassword());
		params.put("phone", user.getPhone());
		params.put("email", user.getPhone());
		System.out.println(user);
		System.out.println(params);
		try {
			client.doPost(url, params);
			System.out.println("离开web注册UserService");
			// SysResult sysResult = mapper.readValue(result.getBody(),
			// SysResult.class);
			return SysResult.oK(user.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
			return SysResult.build(201, "注册失败");
		}
	}

	public String doLogin(User user) {
		String url = "http://sso.jt.com/user/login";
		Map<String, Object> params = new HashMap<>();
		params.put("u", user.getUsername());
		params.put("p", user.getPassword());
		String ticket = null;
		try {
			HttpResult result = client.doPost(url, params);
			SysResult sysResult = mapper.readValue(result.getBody(), SysResult.class);
			ticket = (String) sysResult.getData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ticket;
	}
}

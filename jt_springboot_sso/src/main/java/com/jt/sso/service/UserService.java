package com.jt.sso.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.redis.RedisService;
import com.jt.common.vo.SysResult;
import com.jt.sso.mapper.UserMapper;
import com.jt.sso.pojo.User;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RedisService redisService;
	private static final ObjectMapper mapper = new ObjectMapper();

	public Boolean check(String param, Integer type) {
		Boolean exists = false;
		if (type == 1) {
			int count = userMapper.checkUsername(param);
			if (count >= 1) {
				exists = true;
			}
		} else if (type == 2) {
			int count = userMapper.checkPhone(param);
			if (count >= 1) {
				exists = true;
			}
		} else {
			int count = userMapper.checkEmail(param);
			if (count >= 1) {
				exists = true;
			}
		}
		return exists;
	}

	public void register(User user) {
		System.out.println("进入SSO注册UserService");
		user.setCreated(new Date());
		user.setUpdated(user.getCreated());
		String MD5pwd = DigestUtils.md5Hex(user.getPassword());
		System.out.println(MD5pwd);
		user.setPassword(MD5pwd);
		userMapper.insert(user);
	}

	public SysResult login(String username, String password) {
		String ticket = "";
		User _user = new User();
		_user.setUsername(username);
		List<User> userList = userMapper.select(_user);
		if (userList.size() >= 1) {
			User user = userList.get(0);
			String md5pwd = DigestUtils.md5Hex(password);
			if (md5pwd.equals(user.getPassword())) {
				ticket = DigestUtils.md5Hex("JT_TICKET_" + System.currentTimeMillis() + username);
				String userJson = null;
				try {
					userJson = mapper.writeValueAsString(user);
					redisService.set(ticket, userJson);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}
		}
		return SysResult.oK(ticket);
	}

	public String getUserJsonByTicket(String ticket) {
		String userJson = redisService.get(ticket);
		return userJson;
	}
}

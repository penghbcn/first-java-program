package com.jt.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.service.HttpClientService;
import com.jt.common.util.CookieUtils;
import com.jt.common.vo.SysResult;
import com.jt.web.pojo.User;

public class CartInterceptor implements HandlerInterceptor {
	private static final ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private HttpClientService client;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 通过cookie判断登录
		String ticket = CookieUtils.getCookieValue(request, "JT_TICKET");
		if (StringUtils.isNotEmpty(ticket)) {
			String url = "http://sso.jt.com/user/query/" + ticket;
			String jsonData = client.doGet(url);
			if (StringUtils.isNotEmpty(jsonData)) {
				SysResult sysResult = mapper.readValue(jsonData, SysResult.class);
				String userJson = (String) sysResult.getData();
				User user = mapper.readValue(userJson, User.class);
				Long userId = user.getId();
				request.setAttribute("userId", userId);
				return true;
			}
		}
		response.sendRedirect("/user/login.html");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}

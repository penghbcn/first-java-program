package yohm.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yohm.web.vo.SysResult;

/**
 * 功能简述 (用户相关处理)
 *
 * @author tarena
 * @date 2018/8/14
 * @since 1.0.0
 */
@Controller
public class UserController {

	@RequestMapping("user/doLogin/{username}/{password}")
	@ResponseBody
	public SysResult doLogin(@PathVariable String username, @PathVariable String password, HttpServletRequest request) {
		System.out.println("login:" + username + " " + password);
		return SysResult.ok();
	}

	@RequestMapping("user/doRegister/{username}/{password}")
	@ResponseBody
	public SysResult doRegister(@PathVariable String username, @PathVariable String password) {
		System.out.println("register:" + username + " " + password);
		return SysResult.ok();
	}

	@RequestMapping("user/checkLogin")
	@ResponseBody
	public SysResult checkLogin(HttpServletRequest request, HttpServletResponse response) {
		// Cookie[] cookies=request.getCookies();
		// for (Cookie cookie:cookies) {
		// if(cookie.getName()==redis中的保存值)
		// 。。。
		// }
		System.out.println(SysResult.ok());
		return SysResult.ok();
	}
}

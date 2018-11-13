package cn.tedu.service;

import cn.tedu.domain.User;
import cn.tedu.exception.MsgException;

public interface UserService
{
	/**
	 * 执行登录的方法
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 封装了用户数据的JavaBean
	 * @throws MsgException
	 *             封装了错误信息的异常对象
	 */
	User login(String username, String password) throws MsgException;

	/**
	 * 查询用户是否存在的方法
	 * 
	 * @param username
	 *            用户名
	 * @return true--用户名存在 false--用户名不存在
	 */
	boolean hasUsername(String username);

	/**
	 * 执行注册用户的方法
	 * 
	 * @param user
	 *            封装了用户数据的JavaBean
	 * @throws MsgException
	 *             封装了错误信息的异常对象
	 */
	void registUser(User user) throws MsgException;
}

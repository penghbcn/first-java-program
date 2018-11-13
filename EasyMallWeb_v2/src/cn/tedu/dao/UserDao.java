package cn.tedu.dao;

import cn.tedu.domain.User;

public interface UserDao
{
	/**
	 * 根据用户名和密码查询用户数据的方法
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return null--不存在该用户；User--封装了对应用户数据的对象
	 */
	User getUserByUAndP(String username, String password);

	/**
	 * 根据用户名查询数据是否存在
	 * 
	 * @param username
	 *            用户名
	 * @return true--用户存在；false--用户不存在
	 */
	User getUserByUsername(String username);

	/**
	 * 保存用户的方法
	 * 
	 * @param user
	 *            封装了用户信息的JavaBean
	 * @return true--保存成功； false-- 保存失败
	 */
	boolean saveUser(User user);
}

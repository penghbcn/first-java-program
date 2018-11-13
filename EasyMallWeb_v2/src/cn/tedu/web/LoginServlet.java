package cn.tedu.web;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.utils.JDBCUtils;
import cn.tedu.utils.WebUtils;

public class LoginServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// 乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取表单参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 验证参数
		if (WebUtils.isNull(username))
		{
			request.setAttribute("msg", "用户名不能为空");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		}
		if (WebUtils.isNull(password))
		{
			request.setAttribute("msg", "密码不能为空");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		}
		// 实现记住用户名
		String remname = request.getParameter("remname");
		if ("true".equals(remname))
		{
			String remname1 = URLEncoder.encode(remname, "utf-8");
			Cookie cookie = new Cookie("user", remname1);
			cookie.setPath(request.getContextPath() + "/");
			cookie.setMaxAge(3600 * 24 * 30);
			response.addCookie(cookie);
		} else
		{
			Cookie cookie = new Cookie("user", "");
			cookie.setPath(request.getContextPath() + "/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		// 验证登录
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			conn = JDBCUtils.getConn();
			String sql = "select * from user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next())
			{
				request.getSession().setAttribute("user", username);
				response.getWriter().write("登录成功，3秒后返回首页");
				response.setHeader("Refresh",
						"3;url=" + request.getContextPath() + "/index.jsp");
			} else
			{
				request.setAttribute("msg", "用户名或密码错误");
				request.getRequestDispatcher("/login.jsp").forward(request,
						response);
				return;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
			request.setAttribute("msg", "请稍后再试");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		} finally
		{
			JDBCUtils.close(conn, ps, rs);
		}
	}
}

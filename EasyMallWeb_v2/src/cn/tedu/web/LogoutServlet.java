package cn.tedu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// 乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 删除session
		if (request.getSession(false) != null)
		{
			request.getSession(false).invalidate();
		}
		response.getWriter().write(
				"<h1 style='color:red;text-align:center'>成功登出，3秒后返回首页</h1>");
		response.setHeader("Refresh", "3;url=" + request.getContextPath()
				+ "/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}

}

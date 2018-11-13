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
		// ����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// ɾ��session
		if (request.getSession(false) != null)
		{
			request.getSession(false).invalidate();
		}
		response.getWriter().write(
				"<h1 style='color:red;text-align:center'>�ɹ��ǳ���3��󷵻���ҳ</h1>");
		response.setHeader("Refresh", "3;url=" + request.getContextPath()
				+ "/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}

}

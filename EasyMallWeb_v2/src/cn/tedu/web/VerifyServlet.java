package cn.tedu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.utils.VerifyCode;

public class VerifyServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// ���ò�������֤��ͼƬ
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		// д��ͼƬ
		VerifyCode vc = new VerifyCode();
		vc.drawImage(response.getOutputStream());
		// ����֤��д��session
		String valicode = vc.getCode();
		request.getSession().setAttribute("valicode", valicode);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);

	}

}

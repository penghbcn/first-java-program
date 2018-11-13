package cn.tedu.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.utils.JDBCUtils;
import cn.tedu.utils.WebUtils;

public class RegistServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// �������
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// ��ȡ������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String valistr = request.getParameter("valistr");
		// ����֤
		// �ǿ���֤
		if (WebUtils.isNull(username))
		{
			request.setAttribute("msg", "�û�������Ϊ��");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		}
		if (WebUtils.isNull(password))
		{
			request.setAttribute("msg", "���벻��Ϊ��");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		}
		if (WebUtils.isNull(password2))
		{
			request.setAttribute("msg", "ȷ�����벻��Ϊ��");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		}
		if (WebUtils.isNull(nickname))
		{
			request.setAttribute("msg", "�ǳƲ���Ϊ��");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		}
		if (WebUtils.isNull(email))
		{
			request.setAttribute("msg", "���䲻��Ϊ��");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		}
		if (WebUtils.isNull(valistr))
		{
			request.setAttribute("msg", "��֤�벻��Ϊ��");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		}
		// ȷ������һ������֤
		if (!password.equals(password2))
		{
			request.setAttribute("msg", "ȷ���������������һ��");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		}
		// �����ʽ��֤
		String reg = "^\\w+@\\w+(\\.\\w+)+$";
		if (!email.matches(reg))
		{
			request.setAttribute("msg", "�����ʽ����ȷ");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		}
		// ��֤����֤
		String valicode = (String) request.getSession(false).getAttribute(
				"valicode");
		if (!valistr.equalsIgnoreCase(valicode))
		{
			request.setAttribute("msg", "��֤�벻��ȷ");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		}
		// �û�����������֤
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try

		{
			conn = JDBCUtils.getConn();
			String sql = "select * from user where username=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next())
			{
				request.setAttribute("msg", "�û����Ѵ���");
				request.getRequestDispatcher("/regist.jsp").forward(request,
						response);
				return;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
			return;
		} finally
		{
			JDBCUtils.close(conn, ps, rs);
		}
		// ע��
		Connection conn2 = null;
		PreparedStatement ps2 = null;
		try
		{
			conn2 = JDBCUtils.getConn();
			String sql = "insert into user values(null,?,?,?,?)";
			ps2 = conn2.prepareStatement(sql);
			ps2.setString(1, username);
			ps2.setString(2, password);
			ps2.setString(3, nickname);
			ps2.setString(4, email);
			int i = ps2.executeUpdate();
			if (i <= 0)
			{
				request.setAttribute("msg", "���Ժ�����");
				request.getRequestDispatcher("/regist.jsp").forward(request,
						response);
				return;
			} else
			{
				response.getWriter()
						.write("<h1 style='color:red;text-align:center'>ע��ɹ���3��󷵻���ҳ</h1>");
				response.setHeader("Refresh",
						"3;url=" + request.getContextPath() + "/index.jsp");
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
			request.setAttribute("msg", "���Ժ�����");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		} finally
		{
			JDBCUtils.close(conn2, ps2, null);
		}
	}
}

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
		// 解决乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取表单参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String valistr = request.getParameter("valistr");
		// 表单验证
		// 非空验证
		if (WebUtils.isNull(username))
		{
			request.setAttribute("msg", "用户名不能为空");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		}
		if (WebUtils.isNull(password))
		{
			request.setAttribute("msg", "密码不能为空");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		}
		if (WebUtils.isNull(password2))
		{
			request.setAttribute("msg", "确认密码不能为空");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		}
		if (WebUtils.isNull(nickname))
		{
			request.setAttribute("msg", "昵称不能为空");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		}
		if (WebUtils.isNull(email))
		{
			request.setAttribute("msg", "邮箱不能为空");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		}
		if (WebUtils.isNull(valistr))
		{
			request.setAttribute("msg", "验证码不能为空");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		}
		// 确认密码一致性验证
		if (!password.equals(password2))
		{
			request.setAttribute("msg", "确认密码必须与密码一致");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		}
		// 邮箱格式验证
		String reg = "^\\w+@\\w+(\\.\\w+)+$";
		if (!email.matches(reg))
		{
			request.setAttribute("msg", "邮箱格式不正确");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		}
		// 验证码验证
		String valicode = (String) request.getSession(false).getAttribute(
				"valicode");
		if (!valistr.equalsIgnoreCase(valicode))
		{
			request.setAttribute("msg", "验证码不正确");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		}
		// 用户名不存在验证
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
				request.setAttribute("msg", "用户名已存在");
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
		// 注册
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
				request.setAttribute("msg", "请稍后再试");
				request.getRequestDispatcher("/regist.jsp").forward(request,
						response);
				return;
			} else
			{
				response.getWriter()
						.write("<h1 style='color:red;text-align:center'>注册成功！3秒后返回首页</h1>");
				response.setHeader("Refresh",
						"3;url=" + request.getContextPath() + "/index.jsp");
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
			request.setAttribute("msg", "请稍后再试");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		} finally
		{
			JDBCUtils.close(conn2, ps2, null);
		}
	}
}

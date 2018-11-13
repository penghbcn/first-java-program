package cn.tedu.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils
{
	private JDBCUtils()
	{
	}

	private static ComboPooledDataSource pool = new ComboPooledDataSource();

	public static DataSource getPool()
	{
		return pool;
	}

	public static Connection getConn()
	{
		Connection conn = null;
		try
		{
			conn = pool.getConnection();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn, Statement st, ResultSet rs)
	{
		if (rs != null)
		{
			try
			{
				rs.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			} finally
			{
				rs = null;
			}
		}
		if (st != null)
		{
			try
			{
				st.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			} finally
			{
				st = null;
			}
		}
		if (conn != null)
		{
			try
			{
				conn.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			} finally
			{
				conn = null;
			}
		}
	}
}

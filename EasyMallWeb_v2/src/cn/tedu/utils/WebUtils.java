package cn.tedu.utils;

public class WebUtils
{
	/**
	 * 非空验证 为空时返回true,不为空时返回false
	 * */
	public static boolean isNull(String str)
	{
		if (str == null || "".equals(str.trim()))
		{
			return true;
		}
		return false;
	}
}

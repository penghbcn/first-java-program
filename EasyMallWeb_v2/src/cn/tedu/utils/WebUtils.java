package cn.tedu.utils;

public class WebUtils
{
	/**
	 * �ǿ���֤ Ϊ��ʱ����true,��Ϊ��ʱ����false
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

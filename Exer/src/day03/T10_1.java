package day03;

import java.util.Scanner;

public class T10_1
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("请输入一个小于10的整数");
		int i = s.nextInt();
		while (i < 0 || i > 10)
		{
			System.out.println("参数非法，请重新输入");
			i = s.nextInt();
		}
		s.close();
		System.out.println(mul(i));
	}

	private static long mul(int i)
	{
		if (i == 1)
			return 1;
		return i * mul(i - 1);
	}
}

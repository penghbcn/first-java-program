package day03;

import java.util.Scanner;

public class T22
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("请输入所需项数");
		int n = s.nextInt();
		while (n <= 0)
		{
			System.out.println("参数非法，请重新输入");
			n = s.nextInt();
		}
		s.close();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++)
		{
			sb.append(list(i) + " ");
		}
		String str = "[" + sb.toString().trim() + "]";
		System.out.println(str);
	}

	private static int list(int n)
	{
		if (n == 1)
			return 0;
		if (n == 2)
			return 1;
		else
			return list(n - 2) + list(n - 1);
	}
}

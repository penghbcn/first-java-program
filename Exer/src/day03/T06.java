package day03;

import java.util.Scanner;

public class T06
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("请输入重量");
		int i = s.nextInt();
		s.close();
		while (i < 0)
		{
			System.out.println("非法参数，请重新输入");
			i = s.nextInt();
		}
		if (i < 20)
			System.out.println("运费" + 5 + "元");
		else if (i < 100)
			System.out.println("运费" + (5 + (i - 20) * 0.2) + "元");
		else
			System.out.println("运费" + (5 + (80 * 0.2 + (i - 100) * 0.15)) + "元");
	}
}

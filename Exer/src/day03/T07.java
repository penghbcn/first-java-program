package day03;

import java.util.Scanner;

public class T07
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("请输入一个三位整数");
		int i = s.nextInt();
		while (i < 100 || i > 999)
		{
			System.out.println("非法参数，请重新输入");
			i = s.nextInt();
		}
		s.close();
		System.out.println(i / 100 + i / 10 % 10 + i % 10);
	}
}

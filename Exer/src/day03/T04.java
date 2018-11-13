package day03;

import java.util.Scanner;

public class T04
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("请输入年份");
		int i = s.nextInt();
		s.close();
		if (i % 4 == 0 && i % 100 != 0 || i % 100 == 0 && i % 400 == 0)
			System.out.println(i + "年是闰年");
		else
			System.out.println(i + "年不是闰年");
	}
}

package day03;

import java.util.Scanner;

public class T05
{
	public static void main(String[] args)
	{

		Scanner s = new Scanner(System.in);
		System.out.println("请输入两个数字");
		int i1 = s.nextInt();
		int i2 = s.nextInt();
		System.out.println("1:+");
		System.out.println("2:-");
		System.out.println("3:*");
		System.out.println("4:/");
		System.out.println("请输入您的选择");
		int i = s.nextInt();
		s.close();
		switch (i)
		{
		case 1:
			System.out.println(i1 + "+" + i2 + "=" + (i1 + i2));
			break;
		case 2:
			System.out.println(i1 + "-" + i2 + "=" + (i1 - i2));
			break;
		case 3:
			System.out.println(i1 + "*" + i2 + "=" + (i1 * i2));
			break;
		case 4:
			System.out.println(i1 + "/" + i2 + "=" + (i1 * 1.0 / i2));
			break;
		default:
			System.out.println("非法参数");
			break;
		}
	}
}

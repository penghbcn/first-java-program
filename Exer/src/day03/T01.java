package day03;

import java.util.Scanner;

public class T01
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("请输入年龄");
		int i = s.nextInt();
		while (i < 0)
		{
			System.out.println("非法参数，请重新输入");
			i = s.nextInt();
		}
		s.close();
		if (i < 6)
			System.out.println("儿童");
		else if (i < 13)
			System.out.println("少儿");
		else if (i < 18)
			System.out.println("青少年");
		else if (i < 35)
			System.out.println("青年");
		else if (i < 50)
			System.out.println("中年");
		else
			System.out.println("中老年");
	}
}

package day03;

import java.util.Scanner;

public class T03
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("请输入三个整数");
		int i1 = s.nextInt();
		int i2 = s.nextInt();
		int i3 = s.nextInt();
		s.close();
		int temp = i1;
		if (temp < i2)
			temp = i2;
		if (temp < i3)
			temp = i3;
		System.out.println(temp);
	}
}

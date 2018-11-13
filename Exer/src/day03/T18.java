package day03;

import java.util.Scanner;

public class T18
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("请输入一个整数");
		int n = s.nextInt();
		s.close();
		if (n < 0)
			n = -n;
		int sum = 0;
		for (int i = n; i > 0; i /= 10)
		{
			sum += i % 10;
		}
		System.out.println(sum);
	}
}

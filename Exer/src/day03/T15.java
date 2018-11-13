package day03;

import java.util.Scanner;

public class T15
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("请输入一个整数");
		int n = s.nextInt();
		s.close();
		for (int i = 1; i <= n; i++)
		{
			for (int j = 0; j < n - i; j++)
			{
				System.out.print(" ");
			}
			for (int k = 1; k < 2 * i; k++)
			{
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}

package day03;

import java.util.Scanner;

public class T19
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("������һ������");
		int n = s.nextInt();
		s.close();
		if (n < 2)
			System.out.println(n + "��������");
		else
		{
			boolean b = false;
			for (int i = 2; i <= n / 2; i++)
			{
				if (n % i == 0)
				{
					b = true;
					System.out.println(n + "��������");
					break;
				}
			}
			if (b == false)
				System.out.println(n + "������");
		}
	}
}

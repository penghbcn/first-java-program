package day03;

import java.util.Scanner;

public class T23
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("������һ������");
		int n = s.nextInt();
		s.close();
		int sum = 0;
		while (n != 0)
		{
			if ((n & 1) == 1)
				sum++;
			n >>>= 1;
		}
		System.out.println(sum);
	}
}

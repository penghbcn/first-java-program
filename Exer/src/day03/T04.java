package day03;

import java.util.Scanner;

public class T04
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("���������");
		int i = s.nextInt();
		s.close();
		if (i % 4 == 0 && i % 100 != 0 || i % 100 == 0 && i % 400 == 0)
			System.out.println(i + "��������");
		else
			System.out.println(i + "�겻������");
	}
}

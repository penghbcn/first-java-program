package day03;

import java.util.Scanner;

public class T06
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("����������");
		int i = s.nextInt();
		s.close();
		while (i < 0)
		{
			System.out.println("�Ƿ�����������������");
			i = s.nextInt();
		}
		if (i < 20)
			System.out.println("�˷�" + 5 + "Ԫ");
		else if (i < 100)
			System.out.println("�˷�" + (5 + (i - 20) * 0.2) + "Ԫ");
		else
			System.out.println("�˷�" + (5 + (80 * 0.2 + (i - 100) * 0.15)) + "Ԫ");
	}
}

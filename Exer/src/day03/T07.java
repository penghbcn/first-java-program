package day03;

import java.util.Scanner;

public class T07
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("������һ����λ����");
		int i = s.nextInt();
		while (i < 100 || i > 999)
		{
			System.out.println("�Ƿ�����������������");
			i = s.nextInt();
		}
		s.close();
		System.out.println(i / 100 + i / 10 % 10 + i % 10);
	}
}

package day03;

import java.util.Scanner;

public class T02
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("����������");
		int i = s.nextInt();
		s.close();
		if (i == 1)
			System.out.println("����");
		else if (i == 2)
			System.out.println("����");
		else if (i == 3)
			System.out.println("����");
		else if (i == 4)
			System.out.println("ӨӨ");
		else if (i == 5)
			System.out.println("����");
		else
			System.out.println("������ӭ��");
	}
}

package day03;

import java.util.Scanner;

public class T01
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("����������");
		int i = s.nextInt();
		while (i < 0)
		{
			System.out.println("�Ƿ�����������������");
			i = s.nextInt();
		}
		s.close();
		if (i < 6)
			System.out.println("��ͯ");
		else if (i < 13)
			System.out.println("�ٶ�");
		else if (i < 18)
			System.out.println("������");
		else if (i < 35)
			System.out.println("����");
		else if (i < 50)
			System.out.println("����");
		else
			System.out.println("������");
	}
}

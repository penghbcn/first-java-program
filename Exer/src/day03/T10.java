package day03;

import java.util.Scanner;

public class T10
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("������һ��С��10������");
		int i = s.nextInt();
		while (i < 0 || i > 10)
		{
			System.out.println("�����Ƿ�������������");
			i = s.nextInt();
		}
		s.close();
		int mul = 1;
		for (int j = i; j > 0; j--)
			mul *= j;
		System.out.println(mul);
	}
}

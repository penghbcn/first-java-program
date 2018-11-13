package day03;

import java.util.Scanner;

public class T02
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("ÇëÊäÈëÕûÊı");
		int i = s.nextInt();
		s.close();
		if (i == 1)
			System.out.println("±´±´");
		else if (i == 2)
			System.out.println("¾§¾§");
		else if (i == 3)
			System.out.println("»¶»¶");
		else if (i == 4)
			System.out.println("Ó¨Ó¨");
		else if (i == 5)
			System.out.println("ÄİÄİ");
		else
			System.out.println("±±¾©»¶Ó­Äã");
	}
}

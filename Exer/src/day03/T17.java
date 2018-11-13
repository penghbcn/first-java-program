package day03;

public class T17
{
	public static void main(String[] args)
	{
		int abc;
		for (abc = 100; abc < 1000; abc++)
		{
			int a = abc / 100;
			int b = abc / 10 % 10;
			int c = abc % 10;
			if (a * a * a + b * b * b + c * c * c == abc)
				System.out.println(abc);
		}
	}
}

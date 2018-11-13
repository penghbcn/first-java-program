package day03;

public class T09_1
{
	public static void main(String[] args)
	{
		System.out.println(sum(100));
	}

	private static int sum(int i)
	{
		if (i == 1)
			return 1;
		if (i % 2 == 0)
			return i - 1 + sum(i - 3);
		else
			return i + sum(i - 1);
	}
}

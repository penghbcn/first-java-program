package day03;

public class T08_1
{
	public static void main(String[] args)
	{
		System.out.println(sum(100));
	}

	private static int sum(int i)
	{
		if (i == 1)
			return 1;
		return i + sum(i - 1);
	}

}

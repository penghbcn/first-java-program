package day03;

public class T14
{
	public static void main(String[] args)
	{
		int abcd = 1000;
		while (abcd < 10000)
		{
			int ab = abcd / 100;
			int cd = abcd % 100;
			if ((ab + cd) * (ab + cd) == abcd)
				System.out.println(abcd);
			abcd++;
		}
		// for (int abcd = 1000; abcd < 10000; abcd++)
		// {
		// int ab = abcd / 100;
		// int cd = abcd % 100;
		// if ((ab + cd) * (ab + cd) == abcd)
		// System.out.println(abcd);
		// }
	}
}

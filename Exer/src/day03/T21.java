package day03;

public class T21
{
	public static void main(String[] args)
	{
		double l = 1;
		int i = 1;
		double PI = 0.0;
		while (PI < 3.1415926 || PI > 3.1415927)
		{
			PI += 4 / (2 * l - 1) * i;
			l++;
			i *= -1;
		}
		System.out.println((int) l);
	}
}

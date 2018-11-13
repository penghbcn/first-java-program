package day03;

public class T12
{
	public static void main(String[] args)
	{
		int i;
		int j;
		for (i = 0; i < 34; i++)
		{
			for (j = 0; j < 50; j++)
			{
				if ((100 - i - j) % 3 == 0 && i * 3 + j * 2 + (100 - i - j) / 3 == 100)
					System.out.println("公鸡" + i + "只，母鸡" + j + "只，小鸡" + (100 - i - j) + "只");
			}
		}
	}
}

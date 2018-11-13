package day03;

public class T13
{
	public static void main(String[] args)
	{
		int i;
		int j;
		for (i = 0; i < 9; i++)
		{
			for (j = 0; j < 12; j++)
			{
				if ((36 - i - j) % 2 == 0 && i * 4 + j * 3 + (36 - i - j) / 2 == 36)
					System.out.println("ÄÐ" + i + "\tÅ®" + j + "\tÐ¡º¢" + (36 - i - j));
			}
		}
	}
}

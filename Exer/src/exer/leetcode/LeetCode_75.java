package exer.leetcode;

public class LeetCode_75
{
	public static void main(String[] args)
	{
		int[] arr = { 2, 0, 2, 1, 1, 0 };
		sortShow(arr);
	}

	private static void sortShow(int[] arr)
	{
		int i = 0;
		int j = 0;
		int k = 0;
		for (int q = 0; q < arr.length; q++)
		{
			if (arr[q] == 0)
			{
				arr[k] = 2;
				k++;
				arr[j] = 1;
				j++;
				arr[i] = 0;
				i++;
			} else if (arr[q] == 1)
			{
				arr[k] = 2;
				k++;
				arr[j] = 1;
				j++;
			} else
			{
				arr[k] = 2;
				k++;
			}
		}
		for (int c : arr)
		{
			System.out.print(c + " ");
		}
	}
}

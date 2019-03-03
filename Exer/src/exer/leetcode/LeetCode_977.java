package exer.leetcode;

import java.util.Arrays;

public class LeetCode_977 {

	public static void main(String[] args) {
		int[] nums = { -3, 2, 7, 11, 15 };
		int[] result = sortedSquares(nums);
		System.out.println(Arrays.toString(result));
	}

	public static int[] sortedSquares(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i] * a[i];
		}
		Arrays.sort(b);
		return b;
	}
}

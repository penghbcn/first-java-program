package exer.leetcode;

import java.util.Scanner;

public class LeetCode_657 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String moves = s.nextLine();
		s.close();
		System.out.println(judgeCircle(moves));
	}

	public static boolean judgeCircle(String moves) {
		int rs = 0;
		int ls = 0;
		int us = 0;
		int ds = 0;
		for (int i = 0; i < moves.length(); i++) {
			if ("R".equals(String.valueOf(moves.charAt(i)))) {
				rs++;
			}
			if ("L".equals(String.valueOf(moves.charAt(i)))) {
				ls++;
			}
			if ("U".equals(String.valueOf(moves.charAt(i)))) {
				us++;
			}
			if ("D".equals(String.valueOf(moves.charAt(i)))) {
				ds++;
			}
		}
		if (rs == ls && us == ds) {
			return true;
		} else {
			return false;
		}
	}
}

package exer.leetcode;

import java.util.Scanner;

public class LeetCode_657_update1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String moves = s.nextLine();
		s.close();
		System.out.println(judgeCircle(moves));
	}

	public static boolean judgeCircle(String moves) {
		int rs = 0;
		int us = 0;
		char[] cs = moves.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if ('R' == cs[i]) {
				rs++;
			}
			if ('L' == cs[i]) {
				rs--;
			}
			if ('U' == cs[i]) {
				us++;
			}
			if ('D' == cs[i]) {
				us--;
			}
		}
		if (rs == 0 && us == 0) {
			return true;
		} else {
			return false;
		}
	}
}

package exer.leetcode;

import java.util.Scanner;

public class LeetCode_657_update2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String moves = s.nextLine();
		s.close();
		System.out.println(judgeCircle(moves));
	}

	public static boolean judgeCircle(String moves) {
		char[] cs = moves.toCharArray();
		char[] count = new char[122];
		for (char c : cs) {
			count[c]++;
		}
		return count['U'] == count['D'] && count['R'] == count['L'];
	}
}

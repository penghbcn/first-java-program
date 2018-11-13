package exer.leetcode;

import java.util.Scanner;

public class LeetCode_771 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String J = s.nextLine();
		String S = s.nextLine();
		s.close();
		char[] jc = J.toCharArray();
		char[] sc = S.toCharArray();
		int count = 0;
		for (int i = 0; i < jc.length; i++) {
			for (int j = 0; j < sc.length; j++) {
				if (jc[i] == sc[j]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}

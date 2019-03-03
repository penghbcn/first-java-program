package exer.leetcode;

public class LeetCode_709 {

	public static void main(String[] args) {
		String str = "Hello";
		System.out.println(toLowerCase(str));
	}

	public static String toLowerCase(String str) {
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] >= 'A' && chars[i] <= 'Z') {
				chars[i] += 32;
			}
		}
		return new String(chars);
	}
}

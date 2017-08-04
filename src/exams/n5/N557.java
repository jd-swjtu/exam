package exams.n5;

import exams.n1.N151;

/*
 Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class N557 {

	public static void main(String[] args) {
		System.out.println("#" + new N557().reverseWords("Let's take LeetCode contest") + "#");
	}

	public String reverseWords(String s) {
		char[] str = s.toCharArray();
		//reverse(str, 0, str.length - 1);
		int ss = 0;
		int ee = ss + 1;
		while (ee < str.length) {
			if (str[ee] == ' ') {
				reverse(str, ss, ee - 1);
				ss = ee + 1;
				while (ss < str.length && str[ss] == ' ') {
					ss++;
				}
				ee = ss + 1;
			} else {
				ee++;
			}
		}
		reverse(str, ss, str.length - 1);
		return new String(str);
	}

	private void reverse(char[] str, int s, int e) {
		while (s < e) {
			char c = str[s];
			str[s] = str[e];
			str[e] = c;

			s++;
			e--;
		}
	}
}

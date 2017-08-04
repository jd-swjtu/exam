package exams.n5;

/*
 Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
 */
public class N541 {

	public static void main(String[] args) {
		System.out.println(new N541().reverseStr("abcdefghijk", 4));
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

	public String reverseStr(String s, int k) {
		int len = s.length();
		char[] str = s.toCharArray();
		for (int i = 0; i < len/(2*k)*2*k+k; i += 2 * k) {
			if( i+k-1 < len)
				this.reverse(str, i, i + k - 1);
			else
				this.reverse(str, i, len - 1);
		}
		return new String(str);
	}
}

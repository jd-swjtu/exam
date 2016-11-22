package exams.n1;

public class N186 {

	public static void main(String[] args) {
		char[] c = "the sky is blue".toCharArray();
		new N186().reverseWords(c);
		System.out.println(new String(c));
	}

	/*
	 *
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?
	 */
	
	public void reverseWords(char[] s) {
		int l = 0;
		for(int i=0; i<s.length; i++) {
			if(s[i] == ' ') {
				reverse(s, l, i-1);
				l = i+1;
			}
		}
		reverse(s, l, s.length-1);
		reverse(s, 0, s.length-1);
	}
	
	private void reverse(char[] s, int l, int r) {
		while(l<r) {
			char c = s[l];
			s[l] = s[r];
			s[r] = c;
			
			l++;
			r--;
		}
	}
}

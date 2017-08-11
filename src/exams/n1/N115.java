package exams.n1;

/*
 Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
 */
public class N115 {

	public static void main(String[] args) {
		System.out.println(new N115().numDistinct("rabbbit", "rabbit"));
		System.out.println(new N115().numDistinct("rabbit", "rabbit"));
		System.out.println(new N115().numDistinct("rabbbiit", "rabbit"));
	}

	public int numDistinct(String s, String t) {
       return this.numDistinct(s.toCharArray(), 0, t.toCharArray(), 0);
    }

	public int numDistinct(char[] s, int si, char[] t, int ti) {
		if(ti == t.length) return 1;
		if(si == s.length) return 0;

		int total = 0;
		if (t[ti] == s[si]) {
			total += this.numDistinct(s, si + 1, t, ti + 1);
		}
		total += this.numDistinct(s, si + 1, t, ti);

		return total;
	}
}

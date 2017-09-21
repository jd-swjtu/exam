package exams.n0;

/*
 Implement strStr()

Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class N28 {

	public static void main(String[] args) {

	}

	public int strStr(String haystack, String needle) {
		if(haystack == null || needle == null) return -1;
		if(needle.length() > haystack.length()) return -1;
		
		for(int i=0; i<=haystack.length() - needle.length(); i++) {
			int j=0;
			while(j<needle.length() && haystack.charAt(i+j) == needle.charAt(j)) {
				j++;
			}
			if(j == needle.length()) return i;
		}
		
		return -1;
	}
}

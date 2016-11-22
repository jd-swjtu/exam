package exams.n3;

public class N387 {

	public static void main(String[] args) {
		System.out.println(new N387().firstUniqChar("leetcode"));
		System.out.println(new N387().firstUniqChar("loveleetcode"));
	}

	public int firstUniqChar(String s) {
		if(s==null || s.length() == 0) return -1;

		int[] a = new int[26];
		for(int i=0; i<s.length(); i++) {
			int offset = s.charAt(i) - 'a';
			if(a[offset] == 0) {
				a[offset] = i + 1;
			} else {
				a[offset] = -1;
			}
		}

		int min = s.length()+1;
		for(int i=0; i<a.length; i++) {
			if(a[i] >0 && a[i] < min) min = a[i];
		}
		return min - 1;
	}
}

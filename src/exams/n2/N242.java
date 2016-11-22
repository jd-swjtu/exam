package exams.n2;

public class N242 {

	public static void main(String[] args) {
		System.out.println(new N242().isAnagram("atea", "teaa"));
	}

	public boolean isAnagram(String s, String t) {
		if(s == null && t == null ) return true;
		if(s == null || t == null ) return false;

		int len = s.length();
		if(t.length() != len) return false;

		int[] a = new int[26];
		for(int i=0; i<len; i++) {
			a[s.charAt(i) - 'a']++;
			a[t.charAt(i) - 'a']--;
		}

		for(int i=0; i<26; i++) {
			if(a[i] != 0) return false;
		}
		return true;
	}
}

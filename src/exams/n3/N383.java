package exams.n3;

public class N383 {

	public static void main(String[] args) {
		System.out.println(new N383().canConstruct("a", "b"));
		System.out.println(new N383().canConstruct("aa", "ab"));
		System.out.println(new N383().canConstruct("aa", "aab"));
	}

	/*
	 *  Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true

	 */

	public boolean canConstruct(String ransomNote, String magazine) {
		int[] a = new int[26];
		for(char c: magazine.toCharArray()) {
			a[c-'a']++;
		}

		for(char c: ransomNote.toCharArray()) {
			int idx = c - 'a';
			a[idx]--;

			if(a[idx] < 0) return false;
		}
		return true;
	}
}

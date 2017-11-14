package exams.utils;

import java.util.Arrays;

public class Strings {
	public static int[] kmp(char[] ss) {
		int l = ss.length;
		int[] r = new int[l];
		int i=1;
		int j=0;
		while(i<l) {
			if(ss[i] == ss[j]) {
				r[i] = j+1;
				i++;
				j++;
			} else {
				if(j==0) {
					r[i]=r[j];
					i++;
				} else {
					j = r[j-1];
				}
			}
		}
		return r;
	}
	
	public static int search(String s, String t) {
		char[] tt = t.toCharArray();
		int[] kmp = Strings.kmp(tt);
		char[] ss = s.toCharArray();
		
		int i=0;
		int j=0;
		while(i<ss.length) {
			if(ss[i] == tt[j]) {
				i++;
				j++;
			} else {
				if(j>0) {
					j = kmp[j-1];
				} else {
					j=0;
				}
				if(ss[i]==tt[j]) {
					i++;
					j++;
				} else {
					i++;
				}
			}
			if(j==tt.length) {
				return i-tt.length;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(Strings.kmp("abcdabca".toCharArray())));
		System.out.println(Arrays.toString(Strings.kmp("aabaabaaa".toCharArray())));
		System.out.println(Strings.search("abxabcabcaby", "abcaby"));
	}

}

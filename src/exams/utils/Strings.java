package exams.utils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

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
			
				if(j==tt.length) {
					return i-tt.length;
				}
			} else {
				if(j>0) {
					j = kmp[j-1];
				} else {
					i++;
				}
			}
		}
		return -1;
	}
	
	//abc 123 ab1c23
	/*
	 	0	1  	2 	3
   0 	t 	f  	f 	f
   a 	t	f	f	f
   b    t	t	f	f
   c    f	t	t	t
	 */
	public static boolean isInterleave(char[] s1, char[] s2, char[] s3) {
	    
	    if(s3.length != s1.length + s2.length)
	        return false;
	    
	    boolean[][] table = new boolean[s1.length+1][s2.length+1];
	    
	    for(int i=0; i<s1.length+1; i++) {
	        for(int j=0; j< s2.length+1; j++){
	            if(i==0 && j==0)
	                table[i][j] = true;
	            else if(i == 0)
	                table[i][j] = ( table[i][j-1] && s2[j-1] == s3[i+j-1]);
	            else if(j == 0)
	                table[i][j] = ( table[i-1][j] && s1[i-1] == s3[i+j-1]);
	            else
	                table[i][j] = (table[i-1][j] && s1[i-1] == s3[i+j-1] ) || (table[i][j-1] && s2[j-1] == s3[i+j-1] );
	        }
	        System.out.println(Arrays.toString(table[i]));
	    }
	    
	    
	    return table[s1.length][s2.length];
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(Strings.kmp("abcdabca".toCharArray())));
		System.out.println(Arrays.toString(Strings.kmp("aabaabaaa".toCharArray())));
		System.out.println(Strings.search("abxabyabxabyabz", "abxabyabz"));
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.add(5);
		q.add(4);
		q.add(7);
		Iterator<Integer> it = q.iterator();
		while(it.hasNext()) {
			System.out.println("#" + it.next());
		}
		while(!q.isEmpty()) {
			System.out.println("@" + q.poll());
		}
		Strings.isInterleave("abc".toCharArray(), "123".toCharArray(), "ab1c23".toCharArray());
	}

}

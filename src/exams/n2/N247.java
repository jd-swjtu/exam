package exams.n2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].


 */
public class N247 {

	public static void main(String[] args) {
		for(String s: new N247().findStrobogrammatic(2)) {
			System.out.println(s);
		}
	}
	
	public List<String> findStrobogrammatic(int n) {
        List<String> results = new ArrayList<String>();
        
        char[] a = new char[]{'0', '1', '8'};
        char[] b = new char[]{'0', '1', '8', '6', '9'};
        
        if(n < 0) return results;
        //181, 818, 619, 689, 916,986
        this.find(a, b, "", results, n/2, n%2==1);
        Iterator<String> it = results.iterator();
        while(it.hasNext()) {
        	String s = it.next();
        	if(s.startsWith("0")) it.remove();
        }
        
        return results;
    }
	
	private void find(char[] a, char[] b, String s, List<String> results, int n, boolean odd) {
		if( n == 0 ) {
			if(odd) {
				for(int i=0; i<a.length; i++) {
					results.add(s + a[i] + this.revert(s));
				}
			}  else {
				results.add(s + this.revert(s));
			}
		} else {
			for(int i=0; i<b.length; i++) {
				find(a, b, s + b[i], results, n-1, odd);
			}
		}
	}
	
	private String revert(String s) {
		char[] map = new char[]{'0','1','0','0','0','0','9','0','8','6'};
		StringBuilder sbf = new StringBuilder();
		for(char c: s.toCharArray()) {
			sbf.insert(0, map[c-'0']);
		}
		return sbf.toString();
	}

}

package exam;

import java.util.ArrayList;
import java.util.List;

public class Contest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] r = new int[][]{{0,0,1,1},{0,1,3,2},{1,0,2,2}};
				//{{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
		System.out.println(new Contest().isRectangleCover(r));
	}

	@LeetCode(389)
	public char findTheDifference(String s, String t) {
        int[] sa = new int[26];
        int[] sb = new int[26];
        
        for(int i=0; i<s.length(); i++) {
            sa[s.charAt(i)-'a']++;
        }
        for(int i=0; i<t.length(); i++) {
            sb[t.charAt(i)-'a']++;
        }
        for(int i=0; i<26; i++) {
            if (sb[i]-sa[i]==1) {
                return (char)(i+'a');
            }
        }
        return ' ';
    }
/*	
public int lastRemaining(int n) {
        
    }

private int lastRemaining(int s, int e, boolean left) {
	if(s == e) return e;
	if(left) {
		
	}
}*/

public boolean isRectangleCover(int[][] rectangles) {
    int x2=0, y2=0, x1=Integer.MAX_VALUE, y1=Integer.MAX_VALUE;
    int len = rectangles.length;
    
    int w = 0;
    for(int i=0; i<len; i++) {
    	int[] rect = rectangles[i];
    
    		if(rect[2] > x2){
    			x2 = rect[2];
    		}
    		if(rect[0] < x1) {
    			x1 = rect[0];
    		}
    	
    		if(rect[3] > y2){
    			y2 = rect[3];
    		}
    		if(rect[1] < y1) {
    			y1 = rect[1];
    		}
    	
    	
    	w += (rect[2]-rect[0]) * (rect[3]-rect[1]);
    	System.out.println(w);
    }
    System.out.println(x1 + ":" + y1 + " - " + x2 + ":" + y2);
    if(w ==  (x2-x1) * (y2-y1))
    		return true;
    return false;
}


}

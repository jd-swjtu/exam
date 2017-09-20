package exams.n0;

/*
 Write a function to find the longest common prefix string amongst an array of strings.
 */
public class N14 {

	public static void main(String[] args) {
		System.out.println(new N14().longestCommonPrefix(new String[]{"abcdefg", "abcxx", "abcmm"}));
	}

	public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        
        String shortStr = strs[0];
        int sl = shortStr.length();
        /*for(int i=1; i<strs.length; i++) {
        	int l = strs[i].length();
        	if(l < sl) {
        		sl = l;
        		shortStr = strs[i];
        	}
        }*/
        for(int i=1; i<strs.length; i++) {
        	int j= strs[i].length();
            if(sl >j) sl = j;
            
            j = 0;
        	while(j<sl) {
        		if(strs[i].charAt(j) == shortStr.charAt(j)) {
        			j++;
        		} else {
        			break;
        		}
        	}
        	sl = j;
        }
        
        return shortStr.substring(0, sl);
    }
}

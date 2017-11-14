package exams.n0;

/*
 Wildcard Matching
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
 */
public class N44 {

	public static void main(String[] args) {
		N44 m = new N44();
		System.out.println(m.isMatch("a*a", "a*"));
	}
	
	public boolean isMatch(String s, String p) {
        int width = s.length();
        int height = p.length();
        
        if(height > 0) {
        	char fc = p.charAt(0);
        	StringBuffer sbf = new StringBuffer();
        	sbf.append(fc);
        	for(int i=1; i<height; i++) {
        		char cc = p.charAt(i);
        		if(fc != '*' || cc != fc) {
        			sbf.append(cc);
        			fc = cc;
        		}
        	}
        	p = sbf.toString();
        	height = p.length();
        }
        
        boolean[][] dp = new boolean[width + 1][height + 1];
        dp[0][0] = true;
        
        for(int i=1; i<=height; i++) {
        	if(p.charAt(i-1) != '*') break;
        	dp[0][i] = true;
        }
        
        for (int i = 1; i <= width; i++){
            for (int j = 1; j <= height; j++){
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if (p.charAt(j-1) == '*'){
                	dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        
        return dp[width][height];
    }

	public boolean isMatchx(String s, String p) {
        if(p.length() == 0) {
        	if(s.length() == 0) return true;
        	return false;
        }
        
        if(p.charAt(0) != '*') {
        	if(s.length() == 0) return false;
        	if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '?')
        		return isMatchx(s.substring(1), p.substring(1));
        	return false;
        }
        
        boolean r = isMatchx(s, p.substring(1));
        while(!r) {
        	if(s.length()>0) {
        		s = s.substring(1);
        		r = isMatchx(s, p.substring(1));
        	} else
        		return false;
        }
        return r;
    }
}

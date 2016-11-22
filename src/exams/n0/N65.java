package exams.n0;

public class N65 {
//Pattern pat = Pattern.compile("^\\s*[+-]?(\\d+\\.?|\\.\\d+|\\d+\\.\\d+)(e[+-]?(\\d+))?\\s*$");
	public static void main(String[] args) {
		System.out.println(new N65().isNumber(" e10"));
		System.out.println(new N65().isNumber("0"));
		System.out.println(new N65().isNumber(" 0.1"));
		System.out.println(new N65().isNumber("0.3e2.4"));
		System.out.println(new N65().isNumber("e9"));
		System.out.println(new N65().isNumber("2e10"));
		System.out.println(new N65().isNumber(".3e5"));
	}
/*
 * Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. 
 */
	
public boolean isNumber(String s) {
        s = s.trim();
        if(s.equals("")) return false;
        
        boolean signFlag = false;
        boolean signValue = false;
        boolean dotFlag = false;
        boolean dotValue = false;
        boolean eFlag = false;
        boolean eValue = false;
        
        for(char c: s.toCharArray()) {
        	if(c == ' ') return false;
        	
        	if(c == '+' || c == '-') {
        		if(!signFlag) {
        			signFlag = true;
        		} else {
        			return false;
        		}
        	} else if(c == '.') {
        		if(!dotFlag) {
        			dotFlag = true;
        		} else {
        			return false;
        		}
        		signValue = true;
        	} else if(c == 'e') {
        		if(!eFlag) {
        			eFlag = true;
        		} else {
        			return false;
        		}
        	} else if(c>='0' && c<='9') {
        		if(eFlag) {
        			eValue = true;
        		}
        		if(dotFlag) {
        			dotValue = true;
        		}
        		if(!eFlag) signValue = true;
        	} else {
        		return false;
        	}
        }
        
        if(dotFlag && !dotValue) return false;
        if(eFlag && (!eValue || !signValue)) return false;
        if(signFlag && !signValue) return false;
    	return true;
    }
}

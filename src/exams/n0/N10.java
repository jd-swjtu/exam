package exams.n0;

public class N10 {

	public static void main(String[] args) {
		System.out.println(new N10().isMatch("", ".*"));
	}
	
	public boolean isMatch(String s, String p) {
		if(p == null || p.length() == 0) {
			if(s==null || s.length() == 0) return true;
			return false;
		}
		
		if(p.length() == 1) {
			if(s == null || s.length() == 0 || s.length() > 1 || !(p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) return false;
			return true;
		}
		
		if(p.charAt(1) != '*') {
			if(s == null || s.length() ==0 || !(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) return false;
			return isMatch(s.substring(1), p.substring(1));
		} else {
			boolean r= isMatch(s, p.substring(2));
			int start=0;
			int len = (s!=null)?s.length():0;
			while(!r && start < len && (s.charAt(start) == p.charAt(0) || p.charAt(start) == '.')) {
				r = isMatch(s.substring(++start), p.substring(2));
			}
			return r;
		}
	}

}

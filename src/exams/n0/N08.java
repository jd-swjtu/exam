package exams.n0;

public class N08 {

	public static void main(String[] args) {
		System.out.println(new N08().atof("-123.0001"));
	}

	public float atof(String s) {
		if(s == null || s.length() == 0) return 0l;
		
		int sign = 1;
		if(s.charAt(0) == '+') s = s.substring(1);
		else if(s.charAt(0) == '-') {
			s = s.substring(1);
			sign = -1;
		}
		
		float v = 0;
		
		boolean flag = false;
		int base = 1;
		float vv = 0;
		for(char c: s.toCharArray()) {
			if(c == '.') {
				flag = true;
				continue;
			}
			if(c < '0' || c > '9') return 0l;
			
			if(!flag) {
				v = v*10 + c - '0';
			} else {
				vv = vv * 10 + (c - '0');
				base = base*10;
			}
		}
		if(vv > 0) {
			v = v + vv/base;
		}
		return v * sign;
	}
}

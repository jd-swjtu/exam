package exams.oo;

public class N8 {

	public static void main(String[] args) {
		System.out.println(new N8().atof("123.0001"));
	}

	public float atof(String s) {
		float v = 0;
		
		boolean flag = false;
		int base = 1;
		float vv = 0;
		for(char c: s.toCharArray()) {
			if(c == '.') {
				flag = true;
				continue;
			}
			
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
		return v;
	}
}

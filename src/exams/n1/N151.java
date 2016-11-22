package exams.n1;

public class N151 {

	public static void main(String[] args) {
		System.out.println("#" + new N151().reverseWords(" the sky is blue") + "#");
	}

	public String reverseWords(String s) {
		char[] str = s.toCharArray();
		reverse(str, 0, str.length - 1);
		int ss = 0;
		int ee = ss + 1;
		while(ee<str.length) {
			if(str[ee] == ' ') {
				reverse(str, ss, ee-1);
				ss = ee+1;
				while(ss<str.length && str[ss] == ' ') {
					ss++;
				}
				ee=ss+1;
			} else {
				ee++;
			}
		}
		reverse(str, ss, str.length-1);
		return new String(str);
	}

	private void reverse(char[] str, int s, int e) {
		while(s<e) {
			char c = str[s];
			str[s] = str[e];
			str[e] = c;

			s++;
			e--;
		}
	}
}

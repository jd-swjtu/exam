package exams.n0;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
0
1   5
2 4 
3

n

0 - (2n-2)
1 - (2n-2)+1, (2n-2)+n-1
k - (2n-2) + k, (2n-2) + n-k
n-1  - 2n-2 + n - 1
 */
public class N06 {

	public static void main(String[] args) {
		System.out.println(new N06().convert("PAYPALISHIRING", 3));
	}

	public String convert(String s, int n) {
		if (n == 0) return "";
		if (n == 1) return s;
		
		StringBuffer sbf = new StringBuffer();
		int step = 2*n-2;
		int l = s.length();
		for(int i=0; i<n; i++) {
			for(int j=i;j<l; j += step) {
				sbf.append(s.charAt(j));
				if(i!=0 && i!=n-1) {
					int k = j - i + 2*n - 2 - i;
					if(k<l) {
						sbf.append(s.charAt(k));
					}
				}
			}
		}
		return sbf.toString();
    }
}

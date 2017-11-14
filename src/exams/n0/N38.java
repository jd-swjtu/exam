package exams.n0;

/*
 Count and Say
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
 */
public class N38 {

	public static void main(String[] args) {
		System.out.println(new N38().countAndSay(6));
	}

	public String countAndSay(int n) {
		String s = "1";

		while( n > 1) {
			s = sayIt(s);
			n--;
		}

		return s;
    }
	
	private String sayIt(String n) {
		StringBuffer sbf = new StringBuffer();

		char cc = n.charAt(0);
		int count = 1;
		for(int i=1; i<n.length(); i++) {
			char c = n.charAt(i);

			if(c == cc) {
				count++;
			} else {
				sbf.append(String.valueOf(count)).append(cc);

				cc = c;
				count = 1;
			}
		}
		sbf.append(String.valueOf(count)).append(cc);
		return sbf.toString();
	}
}

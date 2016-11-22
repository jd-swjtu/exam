package exams.n3;

public class N344 {

	public static void main(String[] args) {
		System.out.println(new N344().reverseString("abcdefg"));
		System.out.println(new N344().reverseString2("abcdefg"));
	}

	public String reverseString(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i=s.length()-1; i>=0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
	
	public String reverseString2(String s) {
		char[] arr = s.toCharArray();
		
		int end = arr.length - 1;
		int start = 0;
		
		while(start < end) {
			char c = arr[start];
			arr[start] = arr[end];
			arr[end] = c;
			
			start++;
			end--;
		}
		
		return new String(arr);
	}
}

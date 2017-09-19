package exams.n0;

public class N11 {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6,7,8,9,10,9,8,7,6,5,4,3,2,1};
		int s = 0;
		int e = a.length - 1;
		int max = 0;
		while(s < e) {
			int m = 0;
			if(a[s]<a[e]) {
				m = a[s];
				s++;
			} else {
				m = a[e];
				e--;
			}
			max = Math.max(max, (e-s+1)*m);
		}
		System.out.println(max);
	}
}

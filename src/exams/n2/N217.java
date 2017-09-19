package exams.n2;

/*
 Given an array of integers, find if the array contains any duplicates. 
 Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */
public class N217 {
public boolean containsDuplicate(int[] nums) {
       return false; 
    }

public void quicksort(int[] a, int l, int r) {
	int s = split(a, l, r);
	if(l < s -1)
		quicksort(a, l, s-1);
	if(s < r)
		quicksort(a, s, r);
}

public int split(int[] a, int s, int e) {
	int m = (s+e)/2;
	while(s<=e) {
		while(a[s] < a[m])
			s++;
		
		while(a[e] > a[m])
			e--;
		if(s<=e) {
			int tmp = a[s];
			a[s] = a[e];
			a[e] = tmp;
			
			s++;
			e--;
		}
	}
	
	return s;
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

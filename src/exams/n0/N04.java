package exams.n0;

/*
 There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */
public class N04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num1 = {1,3};
		int[] num2 = {2,4};
		
		int[] num = new int[num1.length + num2.length];
		int i=0;
		int j=0;
		int k=0;
		while(i<num1.length && j<num2.length) {
			if (num1[i] < num2[j]) {
				num[k++] = num1[i++];
			} else {
				num[k++] = num2[j++];
			}
		}
		while(i<num1.length) {
			num[k++] = num1[i++];
		}
		while(j<num2.length) {
			num[k++] = num2[j++];
		}
		
		int l = num.length;
		if (l%2 == 0) {
			System.out.println((num[l/2] + num[l/2-1])/2.0);
		} else {
			System.out.println(num[l/2]);
		}
	}

}

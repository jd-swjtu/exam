package exams.n0;

import java.util.Arrays;

public class N88 {

	public static void main(String[] args) {
		int[] nums1 = new int[]{3,5,7,9, 0, 0, 0, 0, 0, 0,0,0};
		int[] nums2 = new int[]{2,4,6,8,10,12,14};
		new N88().merge(nums1, 4, nums2, 7);
		System.out.println(Arrays.toString(nums1));
		
		int[] nums = {45,23,11,89,77,98,4,28,65,43};
		new N88().mergeSort(nums, new int[nums.length], 0, nums.length-1);
		System.out.println(Arrays.toString(nums));
	}

	/*
	 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
The number of elements initialized in nums1 and nums2 are m and n respectively.
	 */

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i=m-1;
		int j=n-1;
		
		while(i>=0 && j>=0) {
			if(nums1[i] >= nums2[j]) {
				nums1[i+j+1] = nums1[i];
				i--;
			} else {
				nums1[i+j+1] = nums2[j];
				j--;
			}
		}
		
		while(j>=0) {
			nums1[j] = nums2[j];
			j--;
		}
	}
	
	public void mergeSort(int[] nums, int[] tmp, int s, int e) {
		int mid = (s+e)/2;
		
		if(s<mid) {
			mergeSort(nums, tmp, s, mid);
		}
		
		if(mid+1 < e) {
			mergeSort(nums, tmp, mid+1, e);
		}
		
		for(int i=s; i<=e; i++) {
			tmp[i] = nums[i];
		}
		int i=s;
		int j=mid+1;
		int k=s;
		while(i<=mid && j<=e) {
			if(tmp[i]<=tmp[j]) {
				nums[k++]=tmp[i++];
			} else {
				nums[k++]=tmp[j++];
			}
		}
		
		while(i<=mid) {
			nums[k++]=tmp[i++];
		}
		
		while(j<=e) {
			nums[k++]=tmp[j++];
		}
	}
}

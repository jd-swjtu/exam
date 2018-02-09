package exams;

import java.util.Arrays;

public class Alg {

	public static void main(String[] args) {
		Alg alg = new Alg();
		//alg.quicksort(new int[]{3, 2, 1}, 0, 1);
		alg.quicksort(new int[]{7,6,5,4,3,2,1,0}, 0, 7);
		//alg.selectSort(new int[]{1, 5, 3,7,9,2,4,10});
	}

	public void selectSort(int[] arr){
	    for (int i = 0; i<arr.length-1; i++) {      //外层循环移动游标
	        for(int j = i+1; j < arr.length; j++){    //内层循环遍历游标及之后(或之前)的元素
	            if(arr[i] > arr[j]){
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
	        }
	        System.out.println("Sorting: " + Arrays.toString(arr));
	    }
	}
	
	int partition(int arr[], int i, int j) {
		int pivot = arr[j];
		int p = i;
		for(int k=i; k<=j-1; k++) {
			if(arr[k] <= pivot) {
				int tmp = arr[p];
				arr[p] = arr[k];
				arr[k] = tmp;
				p++;
			}
		}
		
		arr[j] = arr[p];
		arr[p] = pivot;
		System.out.println(Arrays.toString(arr));
		return p;
	}
	
	int partition1(int arr[], int left, int right) {
		int i = left, j = right;
		int tmp;
		//Why return i, because pivot is close to left
		int pivot = arr[(left + right) / 2]; //(left+right+1)/2
		//System.out.println(pivot);

		while (i < j) {
			while (arr[i] < pivot)
				i++;
			
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		
		System.out.println("Sorting: " + left + ":" + i + " " + j + ":" + right + " " + Arrays.toString(arr));

		return i; //j
	}

	void quicksort(int arr[], int left, int right) {
		if (left >= right)
			return;
		
		int index = partition(arr, left, right);
		quicksort(arr, left, index - 1 /*j: index*/);
		quicksort(arr, index /*j: index + 1*/ , right);
	}
	
	public void quickSort(int[] arr, int low, int high){
	    if(arr.length <= 0) return;
	    if(low >= high) return;
	    int left = low;
	    int right = high;
	    int temp = arr[left];   
	    while (left < right){
	        while(left < right && arr[right] >= temp){  
	            right--;
	        }
	        arr[left] = arr[right];
	        while(left < right && arr[left] <= temp){
	            left++;
	        }
	        arr[right] = arr[left];
	    }
	    arr[left] = temp;
	    System.out.println("Sorting: " + left + " " + Arrays.toString(arr));
	    quickSort(arr, low, left-1);
	    quickSort(arr, left+1, high);
	}
	
	public void bubbleSort(int[] arr) {
		for(int i=0; i<arr.length - 1; i++) {
			for(int j=0; j<arr.length-i-1; j++) {
				if(arr[j] < arr[j+1]) {
					int t = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = t;
				}
			}
			System.out.println("Sorting: " + Arrays.toString(arr));
		}
	}
}

package exams.n2;

import java.util.Arrays;

import exams.utils.ListNode;

public class N238 {

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4};
		
		int[] results = new N238().productExceptSelf(nums);
		System.out.print(Arrays.toString(results));
		System.out.println();
		
		System.out.println(new N238().difference(ListNode.create("3221"), ListNode.create("542")));
	}
	
	public ListNode difference(ListNode l1, ListNode l2) {
	    if(l1 == null) return l2;
	    if(l2 == null) return l1;
	    ListNode res = new ListNode(0);
	   // while( l1 != null ) {
	       while(l1 != null && l2 != null) {
	          if(l1.val < l2.val) {
	              ListNode node = new ListNode(l1.val);
	              node.next = res.next;
	              res.next = node;
	              
	              l1 = l1.next;
	              //break;
	          } else if(l1.val > l2.val) {
	              ListNode node = new ListNode(l2.val);
	              node.next = res.next;
	              res.next = node;
	              l2 = l2.next;
	          } else {
	              l2 = l2.next;
	              l1 = l1.next;
	          }
	       }
	    //}
	//[4,5,6]
	//[1,4,7]
	    while(l1 != null) {
	        ListNode node = new ListNode(l1.val);
	        node.next = res.next;
            res.next = node;
	        l1 = l1.next;
	    }
	    while(l2 != null) {
	        ListNode node = new ListNode(l2.val);
	        node.next = res.next;
            res.next = node;
	        l2 = l2.next;
	    }
	    return res.next;
	}

	
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		if(len == 0) return new int[0];
		
		int[] results = new int[len];
		
		results[0] = 1;
		for(int i=1; i<len; i++) {
			results[i] = results[i-1] * nums[i-1];
		}
		
		int base = 1;
		for(int i=len-1; i>=0; i--) {
			results[i] = results[i] * base;
			
			base = base * nums[i];
		}
		
		return results;
	}
	
	
}

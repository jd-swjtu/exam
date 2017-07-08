package exams.n2;

import java.util.LinkedList;
import java.util.Queue;

import exams.utils.TreeNode;

/*
 Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
public class N298 {
	int maxV = 0;
	public int longestConsecutive(TreeNode root) {
		maxV = 0;
       max(root, 1);
       return maxV;
    }
	
	private void max(TreeNode n, int l) {
		if (n.left != null) {
			if(n.left.val == n.val + 1) {
				max(n.left, l+1);
			} else {
				max(n.left, 1);
			}
		}
		if(n.right != null) {
			if(n.right.val == n.val + 1) {
				max(n.right, l+1);
			} else {
				max(n.right, 1);
			}
		}
		if(l > maxV) {
			maxV = l;
		}
	}

	/**
	 * TODO: limitation: Cannot have two child with the same values
	 */
	public int longP(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		
		int res = 0;
		while(!q.isEmpty()) {
			int r = 0;
			TreeNode n = q.poll();
			while(n != null) {
				r++;
				if ((n.left != null && n.left.val == n.val + 1) || (n.right != null && n.right.val == n.val + 1)) {
					if (n.left != null && n.left.val == n.val + 1) {
						q.offer(n.right);
						n = n.left;
					} else {
						q.offer(n.left);
						n = n.right;
					}
				} else {
					if (n.left != null) q.offer(n.left);
					if (n.right != null) q.offer(n.right);
					n = null;
				}
			}
			res = Math.max(r, res);
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(new N298().longestConsecutive(TreeNode.deserialize("1,null,3,2,4,null,null,null,5")));
		System.out.println(new N298().longestConsecutive(TreeNode.deserialize("2,null,3,2,null,1")));

		System.out.println(new N298().longP(TreeNode.deserialize("1,null,3,2,4,null,null,null,5")));
		System.out.println(new N298().longP(TreeNode.deserialize("2,null,3,2,null,1")));
	}

}

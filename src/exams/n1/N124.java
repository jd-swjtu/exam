package exams.n1;


import java.util.LinkedList;

import exams.utils.TreeNode;

public class N124 {

	public static void main(String[] args) {
		//System.out.println(new N124().maxPathSum(TreeNode.deserialize("1,2,3")));
		//System.out.println(new N124().maxPathSum(TreeNode.deserialize("20,10,null,5,15")));
		TreeNode root = TreeNode.deserialize("20,10,30,5,15,25,35,3,8,13,17,27,29,34,38");
		System.out.println(new N124().maxPathSum(root));
		System.out.println(new N124().get(root));
	}

	/*
	 *  Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3

Return 6. 
	 */
	
	private int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if(root == null) return 0;
		getMax(root);
		return max;
	}

	private int getMax(TreeNode root) {
		if(root == null) {
			return 0;
		}

		int wl = getMax(root.left);
		int wr = getMax(root.right);
		int v = Math.max(Math.max(wl, wr) + root.val, root.val);
		max = Math.max(Math.max(v, wl + wr + root.val), max);

		return v;
	}

	//Only get the path from root node to leaf node
	public int get(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		LinkedList<TreeNode> q = new LinkedList<>();
		q.addLast(root);
		int max=root.val;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				TreeNode n = q.removeFirst();
				if(n.left != null) {
					n.left.val += n.val;
					max = Math.max(max, n.left.val);
					q.addLast(n.left);
				}
				if(n.right != null) {
					n.right.val += n.val;
					max = Math.max(max, n.right.val);
					q.addLast(n.right);
				}
			}
		}
		return max;
	}
}

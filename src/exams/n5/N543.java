package exams.n5;

import exams.utils.TreeNode;

/*
 Given a binary tree, you need to compute the length of the diameter of the tree. 
 The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 */
//Please refer to N124
public class N543 {

	int max = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		max = 0;
		levels(root); 
		return max;
    }
	
	public int levels(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int l = levels(root.left);
		int r = levels(root.right);
		if (l+r > max) {
			max = l + r;
		}
		
		return 1 + Math.max(l, r);
	}
	
	public static void main(String[] args) {
		System.out.println(new N543().diameterOfBinaryTree(TreeNode.deserialize("1,2,3,4,5")));
		
		/*
		 20
		 /\
    10             30
  5    15       25     35
3   8 13 17 | 27  29|34  38
		 */
		System.out.println(new N543().diameterOfBinaryTree(TreeNode.deserialize("20,10,30,5,15,25,35,3,8,13,17,27,29,34,38")));
		System.out.println(new N543().diameterOfBinaryTree(TreeNode.deserialize("20,10,30,5,null,null,null,3,null")));
	}
}

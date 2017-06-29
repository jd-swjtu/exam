package exams.n1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import exams.utils.TreeNode;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 * @author jichen
 *
 */
public class N103 {

	List<List<Integer>> zigzagLevel(TreeNode root) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		boolean left = true;
		if (root != null) {
			q.addLast(root);
			while(!q.isEmpty()) {
				int size = q.size();
				for(int i=0; i<size; i++) {
					if(left) {
						TreeNode n = q.pollFirst();
						System.out.println(n.val);
						
						
						if(n.left != null) q.addLast(n.left);
						if(n.right != null) q.addLast(n.right);
					} else {
						TreeNode n = q.pollLast();
						System.out.println(n.val);
						
						
						if(n.right != null) q.addFirst(n.right);
						if(n.left != null) q.addFirst(n.left);
					}
				}
				left = !left;
			}
		}
		
		
		return results;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNode.deserialize("9,5,15,3,7,13,17,1,4,6,8,12,14,16,18");
		//TreeNode root = TreeNode.deserialize("9,5,15,3,7,13");
		new N103().zigzagLevel(root);

	}

}

package exams.n2;

import java.util.ArrayList;
import java.util.List;

import exams.utils.TreeNode;

public class N257 {

	public static void main(String[] args) {
		System.out.println(new N257().binaryTreePaths(TreeNode.deserialize("1,2,3,null,5")));
	}

	/*
	 *  Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5

All root-to-leaf paths are:

["1->2->5", "1->3"]
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> results = new ArrayList<String>();
		if(root != null) {
			helper(root, results, String.valueOf(root.val));
		}
		return results;
	}
	
	private void helper(TreeNode root, List<String> results, String path) {
		if(root.left == null && root.right == null) {
			results.add(path);
			
			return;
		}
		
		if(root.left != null) {
			helper(root.left, results, path + "->" + root.left.val);
		}
		if(root.right != null) {
			helper(root.right, results, path + "->" + root.right.val);
		}
	}
}

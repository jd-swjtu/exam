package exams.ap;

import java.util.LinkedList;
import java.util.Queue;

import exams.utils.TreeNode;

public class N98 {

	public static void main(String[] args) {
		System.out.println(new N98().isValidBST2(TreeNode.deserialize("5,3,7,1,4,6,8")));
	}
	/*
	 *  Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

	 */

	public boolean isValidBST(TreeNode root) {
		if(root == null) return false;

		boolean ret = true;
		if(root.left != null) {
			if(root.left.val > root.val) return false;

			ret = ret & isValidBST(root.left);
		}
		if(root.right != null) {
			if(root.right.val < root.val) return false;
			ret = ret & isValidBST(root.right);
		}



		return ret;
	}

	public boolean isValidBST2(TreeNode root) {
		if(root == null) return false;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);

		while(!q.isEmpty()) {
			TreeNode n = q.poll();

			if(n.left != null) {
				if(n.left.val > n.val) return false;
				q.offer(n.left);
			}

			if(n.right != null) {
				if(n.right.val < n.val) return false;
				q.offer(n.right);
			}
		}

		return true;
	}
}

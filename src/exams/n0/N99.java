package exams.n0;

import java.util.ArrayList;
import java.util.List;

import exams.utils.TreeNode;

/*
 Recover Binary Search Tree
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */
public class N99 {

	public static void main(String[] args) {
		TreeNode root = TreeNode.deserialize("5,7,3,2,4,6,8");
		new N99().recoverTree(root);
		System.out.println(root.serialize());
	}

	 public void recoverTree(TreeNode root) {
	        List<TreeNode> bad = new ArrayList<>();
	        this.isValidBST(root, bad);
	        if (bad.size() == 2) {
	        	int t = bad.get(0).val;
	        	bad.get(0).val = bad.get(1).val;
	        	bad.get(1).val = t;
	        }
	 }
	 
	 public void isValidBST(TreeNode root, List<TreeNode> bad) {
			if(root.left != null) {
				if(root.left.val < root.val) {
					isValidBST(root.left, bad);
				} else {
					bad.add(root.left);
				}
			}

			if(root.right != null) {
				if (root.right.val > root.val) {
					isValidBST(root.right, bad);
				} else {
					bad.add(root.right);
				}
			}
		}
}

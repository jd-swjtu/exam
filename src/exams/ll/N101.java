package exams.ll;

import exams.utils.TreeNode;

public class N101 {

	public static void main(String[] args) {
		System.out.println(new N101().isSymmetric(TreeNode.deserialize("1,2,2,3,4,4,3")));
		System.out.println(new N101().isSymmetric(TreeNode.deserialize("1,2,2,null,3,null,3")));
	}

	/*
	 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3

	 */
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		return isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(TreeNode l, TreeNode r) {
		if(l == null && r == null) return true;
		if(l == null || r == null) return false;

		return (l.val == r.val) && isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
	}
}

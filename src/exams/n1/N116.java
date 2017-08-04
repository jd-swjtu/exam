package exams.n1;

import exams.utils.TreeNode;

/*
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */
public class N116 {

	public void connect(TreeNode root) {
		if (root == null)
			return;

		connect(root.left, root.right);
		System.out.println("Done");
	}

	public void connect(TreeNode l, TreeNode r) {
		l.next = r;
		if (l.left != null) {
			connect(l.left, l.right);
			l.right.next = r.left;
			connect(r.left, r.right);
		}
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.deserialize("20,10,30,5,15,25,35,3,8,13,17,27,29,34,38");
		N116 n116 = new N116();
		n116.connect(root);
		System.out.println(root.next());

	}

}

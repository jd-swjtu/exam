package exams.n1;

import java.util.Stack;

import exams.utils.TreeNode;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
 * @author jichen
 *
 */
public class N173 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNode.deserialize("9,5,15,3,7,13,17,1,4,6,8,12,14,16,18");
		BSTIterator b = new BSTIterator(root);
		
		while(b.hasNext()) {
			System.out.println(b.next());
		}
	}

}

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class BSTIterator {
	Stack<TreeNode> s = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        TreeNode p = root;
        while(p != null) {
        	s.push(p);
        	p = p.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode p = s.pop();
        int v = p.val;
        
        p = p.right;
        while (p != null) {
        	s.push(p);
        	p = p.left;
        }
        return v;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
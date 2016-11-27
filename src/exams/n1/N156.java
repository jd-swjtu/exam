package exams.n1;

import java.util.Stack;

import exams.utils.TreeNode;

public class N156 {

	public static void main(String[] args) {
		System.out.println((new N156().upsideDownBinaryTree(TreeNode.deserialize("1,2,3,4,5"))).serialize());
	}
/*
 *  Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, 
 *  flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
   1
  / \
 2   3
/ \
4 5

return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5  2
   / \
   3 1
 
 */
	
	public TreeNode upsideDownBinaryTree(TreeNode root) {
    	if(root == null) return null;
    	
    	TreeNode p = null, r = null;
    	while(root != null) {
    		TreeNode pp = root;
    		TreeNode rr = root.right;
    		root = root.left;
    		
    		pp.right = p;
    		pp.left = r;
    		
    		p = pp;
    		r = rr;
    	}
    	
    	
    	return p;
    }
	
	public TreeNode upsideDownBinaryTreex(TreeNode root) {
    	if(root == null) return null;
    	
    	TreeNode p, parent = null, r = null;
    	while(root != null) {
    		p = new TreeNode(root.val);
    		
    		if(parent != null) {
    			p.left = parent.right;
    		}
    		p.right = r;
    		r = p;
    		
    		parent = root;
    		root = root.left;
    	}
    	
    	
    	return r;
    }
    
	
	public TreeNode UpsideDownBinaryTree(TreeNode root) {
		Stack<TreeNode> q = new Stack<TreeNode>();
		while(root != null) {
			q.push(root);
			root = root.left;
		}
		
		TreeNode p = q.pop();
		root = p;
		
		while(!q.isEmpty()) {
			TreeNode t = q.pop();
			
			p.left = t.right;
			p.right = t;
			
			p = p.right;
		}
		p.left = null;
		p.right = null;
		
		return root;
	}
}

package exams.aa;

import java.util.LinkedList;
import java.util.Queue;

import exams.utils.TreeNode;

public class N98 {

	public static void main(String[] args) {
		System.out.println(new N98().isValidBST(TreeNode.deserialize("1,2,3")));
		System.out.println(new N98().isValidBST(TreeNode.deserialize("5,3,7,2,4,6,8")));
		
		System.out.println(new N98().isValidBST2(TreeNode.deserialize("1,2,3")));
		System.out.println(new N98().isValidBST2(TreeNode.deserialize("5,3,7,2,4,6,8")));
	}

	public boolean isValidBST(TreeNode root) {
		if(root == null) return true;

		boolean result = true;
		if(root.left != null) {
			result = result && (root.left.val < root.val) &&  isValidBST(root.left);
		}

		if(root.right != null) {
			result = result && (root.right.val > root.val) && isValidBST(root.right);
		}

		return result;
	}
	
	public boolean isValidBST2(TreeNode root) {
		if(root == null) return true;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			TreeNode n = q.poll();
			
			if(n.left != null) {
				if(n.val <= n.left.val) return false;
				q.offer(n.left);
			}
			if(n.right != null) {
				if(n.right.val <= n.val) return false;
				q.offer(n.right);
			}
		}
		return true;
	}
}

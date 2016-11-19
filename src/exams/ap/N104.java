package exams.ap;

import java.util.LinkedList;
import java.util.Queue;

import exams.utils.TreeNode;

public class N104 {

	public static void main(String[] args) {
		System.out.println(new N104().maxDepth2(TreeNode.deserialize("3,9,20,null,null,15,7")));
	}

	public int maxDepth(TreeNode root) {
		if(root == null) return 0;

		int l = maxDepth(root.left) + 1;
		int r = maxDepth(root.right) + 1;

		return Math.max(l, r);
	}
	
	public int maxDepth2(TreeNode root) {
		if(root == null) return 0;

		int level = 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while(!q.isEmpty()) {
			level++;
			int size = q.size();
			for(int i=0; i<size; i++) {
				TreeNode node = q.poll();
				
				if(node.left != null) q.offer(node.left);
				if(node.right != null) q.offer(node.right);
			}
		}
		
		return level;
	}
}

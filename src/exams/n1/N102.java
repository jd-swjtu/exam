package exams.n1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import exams.utils.TreeNode;

public class N102 {

	public static void main(String[] args) {
		System.out.println(new N102().levelOrder(TreeNode.deserialize("3,9,20,null,null,15,7")));
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		if(root == null) return res;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			List<Integer> levelNodes = new ArrayList<Integer>();
			for(int i=0; i<size; i++) {
				TreeNode node = q.poll();
				levelNodes.add(node.val);
				
				if(node.left != null) q.offer(node.left);
				if(node.right != null) q.offer(node.right);
			}
			res.add(levelNodes);
		}
		
		return res;
	}
}

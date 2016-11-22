package exams.n1;

import java.util.LinkedList;
import java.util.Queue;

import exams.utils.TreeNode;

public class N111 {

	public static void main(String[] args) {
		TreeNode root = TreeNode.deserialize("1,2,null,4,5,null,null,6");
		System.out.println(new N111().maxMin(root, 0));
		System.out.println(new N111().minDepth(root));
	}

	public int maxMin(TreeNode root, int level) {
		if(root == null) return 0;
		
		if(root.right == null && root.left == null) {
			return level+1;
		}
		
		int rl = maxMin(root.right, level + 1);
		int ll = maxMin(root.left, level + 1);
		
		if(root.right == null || root.left == null) {
			return Math.max(rl, ll);
		}
		
		return Math.min(rl,  ll);
	}
	
	public int minDepth(TreeNode root) {
        //return maxMin(root, 0);
		
		if(root == null) return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		int levels = 0;
		q.offer(root);
		
		while(!q.isEmpty()) {
			levels++;
			
			int size = q.size();
			for(int i=0; i<size; i++) {
				TreeNode n = q.poll();
			
				if(n.right == null && n.left == null)  return levels;
				if(n.right != null) q.offer(n.right);
				if(n.left != null) q.offer(n.left);
			}
		}
		
		return levels;
    }
}

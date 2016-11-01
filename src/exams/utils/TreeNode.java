package exams.utils;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;


public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int x) { val = x; }
	
	public String toString() { return String.valueOf(val); }
	
	public static TreeNode deserialize(String str) {
		String[] strs = str.split(",");
		if(strs.length > 0) {
			Queue<TreeNode> q = new ArrayDeque<TreeNode>();
			String s = strs[0];
			if(s.equals("null")) return null;
			
			TreeNode root = new TreeNode(Integer.parseInt(s));

			q.add(root);
			for(int i=1; i<strs.length; i+=2) {
				TreeNode n = q.poll();
				String v = strs[i];
				if(!"null".equals(v)) {
					TreeNode nn = new TreeNode(Integer.parseInt(v));
					n.left = nn;

					q.add(nn);
				}
				if(i+1<strs.length) {
					v = strs[i+1];
					if(!"null".equals(v)) {
						TreeNode nn = new TreeNode(Integer.parseInt(v));
						n.right = nn;

						q.add(nn);
					}
				}
			}
			return root;
		}
		return null;
	}
	
	public String serialize() {
		StringBuffer sbf = new StringBuffer();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode node = this;
		if(node != null) {
			q.add(node);
			
			while(q.size() > 0) {
				node = q.poll();

				if(node == null) {
					sbf.append("null,");
					continue;
				}
				
				sbf.append(node.val).append(",");
				q.add(node.left);
				q.add(node.right);
			}
		}
		return sbf.toString();
	}
}

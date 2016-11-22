package exams.n3;

import java.util.ArrayList;
import java.util.List;

import exams.utils.TreeNode;

public class N366 {

	public static void main(String[] args) {
		System.out.println(new N366().xxxTree(
				TreeNode.deserialize("1,2,3,4,5,null,null,null,null,null,6")
				));
	}

	public List<List<Integer>> xxxTree(TreeNode root) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		treeIndex(root, results);
		return results;
	}
	
	private int treeIndex(TreeNode root, List<List<Integer>> results) {
		if(root == null) return -1;
		
		int l = treeIndex(root.left, results);
		int r = treeIndex(root.right, results);
		
		int cur = Math.max(l, r) + 1;
		if(results.size() == cur) {
			results.add(new ArrayList<Integer>());
		}
		
		results.get(cur).add(root.val);
		return cur;
	}
}

package exams.n1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import exams.utils.TreeNode;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * For example: Given the below binary tree and sum = 22, 
 * 		5
 * 	   / \
 *    4   8
 *   /   / \ 
 *  11 13   4 
 * / \     / \
 * 7 2    5   1
 * 
 * return [ [5,4,11,2], [5,8,4,5] ]
 * 
 * @author jichen
 *
 */
public class N113 {
	public void pathSumX(TreeNode root, int sum, List<List<Integer>> results, List<Integer> tmp) {
		if (root == null)
			return;

		int s = 0;
		for (int x : tmp)
			s += x;

		if (sum - s > root.val) {
			List<Integer> tt = new ArrayList<>(tmp);
			tt.add(root.val);

			pathSumX(root.left, sum, results, tt);
			pathSumX(root.right, sum, results, tt);
		} else if (sum - s == root.val) {
			if (root.left == null && root.right == null) {
				tmp.add(root.val);
				results.add(tmp);
			}
		}
	}

	public List<List<Integer>> pathSumX(TreeNode root, int sum) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();

		List<Integer> tmp = new ArrayList<Integer>();
		int cSum = 0;

		if (root == null || root.val > sum)
			return results;

		Stack<TreeNode> s = new Stack<>();
		//node's level, index start from 0
		Stack<Integer> l = new Stack<>();

		int level = 0;
		TreeNode p = root;
		s.push(p);
		l.push(level);

		while (!s.isEmpty()) {
			p = s.pop();
			level = l.pop();

			//Current node has not been summed, so the size of tmp should be equal to 'level'
			while (tmp.size() > level) {
				cSum -= tmp.remove(tmp.size() - 1);
			}

			//Use current node value, since we know add this node, the value still less than or equal to sum
			tmp.add(p.val);
			cSum += p.val;

			if (cSum == sum && p.left == null && p.right == null) {
				results.add(new ArrayList<>(tmp));
				continue;
			} 

			//Before enter stack, make sure the node is meet requirement currently
			if (p.right != null && cSum + p.right.val <= sum) {
				l.push(level + 1);
				s.push(p.right);
			}

			if (p.left != null && cSum + p.left.val <= sum) {
				l.push(level + 1);
				s.push(p.left);
			}
		}

		return results;
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		Map<TreeNode, List<Integer>> map = new HashMap<TreeNode, List<Integer>>();

		if (root == null || root.val > sum)
			return results;

		List<Integer> tmp = new ArrayList<>();
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.addLast(root);
		tmp.add(root.val);
		map.put(root, tmp);

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode p = q.pollFirst();
				tmp = map.get(p);
				int s = 0;
				for (int y : tmp)
					s += y;
				if (p.left != null && sum - p.left.val >= s) {
					q.addLast(p.left);
					List<Integer> tmpx = new ArrayList<>(tmp);
					tmpx.add(p.left.val);
					map.put(p.left, tmpx);
				}
				if (p.right != null && sum - p.right.val >= s) {
					q.addLast(p.right);
					List<Integer> tmpx = new ArrayList<>(tmp);
					tmpx.add(p.right.val);
					map.put(p.right, tmpx);
				}
			}
		}

		for (TreeNode p : map.keySet()) {
			if (p.left == null || p.right == null) {
				tmp = map.get(p);
				int s = 0;
				for (int x : tmp)
					s += x;

				if (s == sum) {
					System.out.println(tmp);
					results.add(tmp);
				}
			}
		}
		return results;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.deserialize("5,4,8,11,null,13,4,7,2,null,null,5,1");
		// System.out.println(new N113().pathSum(root, 22));
		System.out.println(new N113().pathSumX(root, 22));

		List<List<Integer>> results = new ArrayList<List<Integer>>();
		new N113().pathSumX(root, 22, results, new ArrayList<Integer>());
		// System.out.println(results);
	}

}

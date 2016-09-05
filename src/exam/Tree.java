package exam;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class Tree {



	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	@LeetCode(94)
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> results = new ArrayList<Integer>();
		tranversal(root, results);
		return results;
	}

	private void tranversal(TreeNode node, List<Integer> results) {
		if(node != null) {
			tranversal(node.left, results);
			results.add(node.val);
			tranversal(node.right, results);
		}
	}

	private TreeNode genTree(TreeNode root, int v) {
		TreeNode node = new TreeNode(v);
		if(root.val < v) {
			if(root.right == null) {
				root.right = node;
				return root;
			}
			node.left = root;
			return node;
		}
		return node;
	}

	private TreeNode clone(TreeNode root) {
		if(root != null) {
			TreeNode _root = new TreeNode(root.val);
			copy(root.left, _root, true);
			copy(root.right, _root, false);

			return _root;
		}
		return null;
	}
	private void copy(TreeNode src, TreeNode p, boolean isLeft) {
		if(src != null) {
			TreeNode n = new TreeNode(src.val);
			if(isLeft) {
				p.left = n;
			} else {
				p.right = n;
			}
			copy(src.left, n, true);
			copy(src.right, n, false);
		}
	}

	public void printTree(TreeNode n, int x) {
		for(int i=0; i<x; i++)
			System.out.print(" ");
		System.out.println(n.val);


		if(n.left != null) {
			for(int i=0; i<x-2; i++)
				System.out.print(" ");
			System.out.println("/");
			printTree(n.left, x-2);
		}
		if(n.right != null) {
			for(int i=0; i<x+2; i++)
				System.out.print(" ");
			System.out.println("\\");
			printTree(n.right, x+2);
		}
	}

	public boolean isValidBST(TreeNode root) {
		return tranversalx(root);
	}
	private long vv = Long.MIN_VALUE;
	private boolean tranversalx(TreeNode node) {
		boolean result = true;
		if(node != null) {
			result &= tranversalx(node.left);
			if(node.val <= vv) return false;
			else vv = node.val;
			result &= tranversalx(node.right);
		}
		return result;
	}


	public void recoverTree(TreeNode root) {
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		tranversalx(root, null, nodes);

		if(nodes.size() == 4) {
			TreeNode n1 = nodes.get(0);
			TreeNode p1 = nodes.get(1);
			TreeNode n2 = nodes.get(2);
			TreeNode p2 = nodes.get(3);

			TreeNode n3 = n1.left;
			TreeNode n4 = n1.right;

			n1.left = n2.left;
			n1.right = n2.right;
			if(p2 != null) {
				if(p2.left == n2) {
					p2.left = n1;
				} else {
					p2.right = n1;
				}
			}

			n2.left = n3;
			n2.right = n4;
			if(p1 != null) {
				if(p1.left == n1) {
					p1.left = n2;
				} else {
					p1.right = n2;
				}
			}
		}
	}

	private void tranversalx(TreeNode node, TreeNode parent, List<TreeNode> nodes) {
		if(node != null) {
			tranversalx(node.left, node, nodes);
			if(node.val <= vv) {
				nodes.add(node);
				nodes.add(parent);
				vv = Long.MIN_VALUE;
				if(nodes.size() == 4) return;
			} else vv = node.val;
			tranversalx(node.right, node, nodes);
		}
	}

	public List<TreeNode> generateTrees(int n) {
		return genBST(1, n);
	}

	private List<TreeNode> genBST(int min, int max) {
		List<TreeNode> ret = new ArrayList<TreeNode>();
		if(min>max) {
			ret.add(null);
			return ret;
		}

		for(int i=min; i<=max; i++) {
			List<TreeNode> leftSubTree = genBST(min,i-1);
			List<TreeNode> rightSubTree = genBST(i+1,max);
			for(int j=0; j<leftSubTree.size(); j++) {
				for(int k=0; k<rightSubTree.size(); k++) {
					TreeNode root = new TreeNode(i);
					root.left = leftSubTree.get(j);
					root.right = rightSubTree.get(k);
					ret.add(root);
				}
			}
		}

		return ret;
	}

	public List<Integer> serialize(TreeNode root) {
		List<Integer> results = new ArrayList<Integer>();
		Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		TreeNode node = root;
		if(node != null) {
			q.add(node);

			while(q.size() > 0) {
				node = q.poll();
				if(node instanceof EmptyNode) {
					results.add(null);
				} else {
					results.add(node.val);
					if(node.left == null)
						q.add(new EmptyNode());
					else
						q.add(node.left);
					if(node.right == null)
						q.add(new EmptyNode());
					else
						q.add(node.right);
				}
			}
		}
		int idx = results.size() - 1;
		while(results.get(idx) == null) {
			results.remove(idx);
			idx--;
		}
		return results;
	}

	public TreeNode deserialize(List<Integer> results) {
		if(results.size()>0) {
			Queue<TreeNode> q = new ArrayDeque<TreeNode>();
			TreeNode root = new TreeNode(results.get(0));

			q.add(root);
			for(int i=1; i<results.size(); i+=2) {
				TreeNode n = q.poll();
				Integer v = results.get(i);
				if(v != null) {
					TreeNode nn = new TreeNode(v.intValue());
					n.left = nn;

					q.add(nn);
				}
				if(i+1<results.size()) {
					v = results.get(i+1);
					if(v != null) {
						TreeNode nn = new TreeNode(v.intValue());
						n.right = nn;

						q.add(nn);
					}
				}
			}
			return root;
		}
		return null;
	}

	@LeetCode(101)
	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root, root);
	}

	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if(left != null && right != null) {
			return left.val == right.val &&
					isSymmetric(left.left, right.right) &&
					isSymmetric(left.right, right.left);
		}
		if(left == null && right == null) return true;
		return false;
	}

	@LeetCode(100)
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p != null && q != null) {
			return p.val == q.val &&
					isSameTree(p.left, q.left) &&
					isSameTree(p.right, q.right);
		}

		if(p == null && q == null) return true;
		return false;
	}

	@LeetCode(102)
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		if(root!=null) q.add(root);
		else
			return results;
		int w = 1;

		List<Integer> r = new ArrayList<Integer>();
		while(q.size() > 0) {
			TreeNode p = q.poll();
			r.add(p.val);

			if(p.left != null) q.add(p.left);
			if(p.right != null) q.add(p.right);

			if(r.size() == w) {
				w = q.size();
				results.add(r);
				r = new ArrayList<Integer>();
			}
		}

		return results;
	}
	
	@LeetCode(102)
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		Deque<TreeNode> q = new ArrayDeque<TreeNode>();
		if(root!=null) q.add(root);
		else
			return results;
		int w = 1;
		boolean forward = true;

		List<Integer> r = new ArrayList<Integer>();
		while(q.size() > 0) {
			TreeNode p = forward?q.removeFirst():q.removeLast();
			r.add(p.val);

			if(forward) {
				if(p.left != null)  q.add(p.left);
				if(p.right != null) q.add(p.right);
			} else {
				if(p.right != null) q.addFirst(p.right);
				if(p.left != null)  q.addFirst(p.left);
			}

			if(r.size() == w) {
				w = q.size();
				results.add(r);
				r = new ArrayList<Integer>();
				forward = !forward;
			}
		}

		return results;
	}

	public static void main(String[] args) {
		Tree t = new Tree();
		/*List<TreeNode> trees = t.generateTrees(3);
		for(TreeNode tree: trees) {
			System.out.println(t.inorderTraversal(t.deserialize(t.serialize(tree))));
		}
		System.out.println(trees.size() + " " + t.calBST(1, 4));*/
		List<Integer> nodes = new ArrayList<Integer>();
		nodes.add(15);nodes.add(5);nodes.add(10);//nodes.add(null);nodes.add(null);nodes.add(6);nodes.add(20);
		TreeNode node = t.deserialize(nodes);
		//	System.out.println(t.isValidBST(node));
		System.out.println(t.inorderTraversal(node));
		t.recoverTree(node);
		System.out.println(t.inorderTraversal(node));
	}
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class EmptyNode extends TreeNode {
	public EmptyNode(){
		super(0);
	}
}
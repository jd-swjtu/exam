package exams.utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;


public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode next;
	
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
	
	public String next() {
		StringBuffer sbf = new StringBuffer();
		TreeNode r = this;
		
		TreeNode c = null;
		while (true) {
			while(r != null) {
				sbf.append(r.val).append("->");
				if (c == null && r.left != null) {
					c = r.left;
				}
				if (c == null && r.right != null) {
					c = r.right;
				}
				
				r = r.next;
			}
			sbf.append("NULL\n");
			if( c == null) {
				break;
			}
			r = c;
			c = null;
		}
		
		
		return sbf.toString();
	}
	
	public List<Integer> topView() {
		TreeNode r = this;
		LinkedList<TreeNode> q = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		Map<Integer, TreeNode> map = new HashMap<>();
		Map<TreeNode, Integer> v = new HashMap<>();
		
		q.offer(r);
		v.put(r, 0);
		map.put(0, r);
		
		while(!q.isEmpty()) {
			int s = q.size();
			for(int i=0; i<s; i++) {
				TreeNode n = q.pollFirst();
				if (n.left != null) {
					q.offer(n.left);
					int vv = v.get(n) - 1;
					v.put(n.left, vv);
					if(map.get(vv) == null) {
						map.put(vv, n.left);
					}
				}
				
				if (n.right != null) {
					q.offer(n.right);
					int vv = v.get(n) + 1;
					v.put(n.right, vv);
					if(map.get(vv) == null) {
						map.put(vv, n.right);
					}
				}
			}
		}
		TreeSet<Integer> sorted = new TreeSet<>(map.keySet());
		for(Integer i: sorted) {
			result.add(map.get(i).val);
		}
		return result;
	}
	
	public List<Integer> bottomView() {
		TreeNode r = this;
		LinkedList<TreeNode> q = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		Map<Integer, TreeNode> map = new HashMap<>();
		Map<TreeNode, Integer> v = new HashMap<>();
		
		q.offer(r);
		v.put(r, 0);
		map.put(0, r);
		
		while(!q.isEmpty()) {
			int s = q.size();
			for(int i=0; i<s; i++) {
				TreeNode n = q.pollFirst();
				if (n.left != null) {
					q.offer(n.left);
					int vv = v.get(n) - 1;
					v.put(n.left, vv);
					//if(map.get(vv) == null) {
						map.put(vv, n.left);
					//}
				}
				
				if (n.right != null) {
					q.offer(n.right);
					int vv = v.get(n) + 1;
					v.put(n.right, vv);
					//if(map.get(vv) == null) {
						map.put(vv, n.right);
					//}
				}
			}
		}
		TreeSet<Integer> sorted = new TreeSet<>(map.keySet());
		for(Integer i: sorted) {
			result.add(map.get(i).val);
		}
		return result;
	}
	
	public int inorderPredecesor(int v) {
		TreeNode r = this;
		TreeNode store = null;
		while(r != null) {
			if(v > r.val) {
				store = r;
				r = r.right;
			} else if(v < r.val) {
				r = r.left;
			} else {
				if (r.left != null) {
					r = r.left;
					//Find right most
					while(r.right != null) r = r.right;
					return r.val;
				} else {
					return store.val;
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	
	public int inorderSuccessor(int v) {
		TreeNode r = this;
		TreeNode store = null;
		while(r != null) {
			if(v > r.val) {
				r = r.right;
			} else if(v < r.val) {
				store = r;
				r = r.left;
			} else {
				if (r.right != null) {
					r = r.right;
					//Find left most
					while(r.left != null) r = r.left;
					return r.val;
				} else {
					return store.val;
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	
	public List<List<Integer>> levelView() {
		TreeNode r = this;
		LinkedList<TreeNode> q = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		
		q.offer(r);
		
		while(!q.isEmpty()) {
			int s = q.size();
			List<Integer> level = new ArrayList<>();
			for(int i=0; i<s; i++) {
				TreeNode n = q.pollFirst();
				level.add(n.val);
				
				for(TreeNode x: new TreeNode[]{n.left, n.right}) {
					if(x == null) continue;
					
					q.offer(x);
				}
			}
			result.add(level);
		}
		return result;
	}
	
	public int lowestCommonAncestor(int a, int b) {
		TreeNode n = lca(this, a, b);
		if (n != null) return n.val;
		return Integer.MIN_VALUE;
	}
	
	private TreeNode lca(TreeNode r, int a, int b) {
		if(r == null) return null;
		if (r.val == a || r.val == b) return r;
		//if (r.left == null && r.right == null) return null;
		
		TreeNode lc = lca(r.left, a, b);
		TreeNode rc = lca(r.right, a, b);
		if(lc != null && rc != null) return r;
		return (lc!=null)?lc:rc;
	}
	
	public List<Integer> getNodes(int k) {
		List<Integer> results = new ArrayList<>();
		if (k<0) return results;

		getNodes(this, k, results);
		return results;
	}
	
	private void getNodes(TreeNode n, int k, List<Integer> results) {
		if(n == null) return;
		if(k==0) {
			results.add(n.val);
			return;
		}
		
		getNodes(n.left, k-1, results);
		getNodes(n.right, k-1, results);
	}
	
	private void leafNodes(TreeNode n, List<Integer> current, List<List<Integer>> results) {
		if(n == null) {
			return;
		}
		current.add(n.val);
		if (n.left == null && n.right == null) {
			results.add(new ArrayList<>(current));
		} else {
			leafNodes(n.left, current, results);
			leafNodes(n.right, current, results);
		}
		current.remove(current.size()-1);
	}
	public List<List<Integer>> leafPath() {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> current = new ArrayList<>();
		
		this.leafNodes(this, current, results);
		return results;
	}
	
	public List<List<Integer>> digonal() {
		List<List<Integer>> results = new ArrayList<>();
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(this);
		while(!q.isEmpty()) {
			int s = q.size();
			List<Integer> current = new ArrayList<>();
			for(int i=0; i<s; i++) {
				TreeNode n = q.poll();
				while(n!=null) {
					current.add(n.val);
					if(n.left != null) {
						q.offer(n.left);
					}
					n = n.right;
				}
			}
			results.add(current);
		}
		return results;
	}
	
	public List<List<Integer>> getNodesForSum(int sum) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> current = new ArrayList<>();
		
		this.getNodesForSum(this, sum, current, results);
		return results;
	}
	
	private void getNodesForSum(TreeNode r, int s, List<Integer> current, List<List<Integer>> results) {
		if(r == null || s < r.val) {
			return;
		}
		current.add(r.val);
		s -= r.val;
		
		if (s == 0) {
			results.add(new ArrayList<>(current));
		} else {
			this.getNodesForSum(r.left, s, current, results);
			this.getNodesForSum(r.right, s, current, results);
		}
		
		current.remove(current.size()-1);
		return;
	}
	
	private boolean isMirror(TreeNode l, TreeNode r) {
		if (r == null && l == null) return true;
		if (r == null || l == null) return false;
		if(r.val != l.val) return false;
		return this.isMirror(l.left, r.right) && this.isMirror(l.right, r.left);
	}
	public boolean isMirror() {
		return this.isMirror(this.left, this.right);
	}
	
	private TreeNode mirror(TreeNode n) {
		if (n == null) return null;
		TreeNode l = n.left;
		n.left = mirror(n.right);
		n.right = mirror(l);
		return n;
	}
	public TreeNode mirror() {
		return this.mirror(this);
	}
	
	public TreeNode deleteBST(int v) {
		return this.deleteBST(this, v);
	}
	
	private TreeNode deleteBST(TreeNode root, int v) {
		if(root == null) return null;
		if(v > root.val) {
			root.right = this.deleteBST(root.right, v);
		} else if(v < root.val) {
			root.left = this.deleteBST(root.left, v);
		} else {
			if(root.left == null) {
				return root.right;
			} else if(root.right == null) {
				return root.left;
			} else {
				//Find the min value of right branch
				TreeNode p = root.right;
				while(p.left != null) p=p.left;
				root.val = p.val;
				root.right = this.deleteBST(root.right, root.val);
			}
		}
		return root;
		/*
		TreeNode parent = new TreeNode(Integer.MAX_VALUE);
		TreeNode rr = parent;
		parent.left = root;
		boolean left = true;
		TreeNode p = parent.left;
		while(p != null && p.val != v) {
			parent = p;
			if(p.val > v) {
				p = p.left;
				left = true;
			} else {
				p = p.right;
				left = false;
			}
		}
		if(p == null || p.val != v) return this;
		if (p.left == null && p.right == null) {
			if(left) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (p.left == null){
			if(left) {
				parent.left = p.right;
			} else {
				parent.right = p.right;
			}
		} else if(p.right == null){
			if(left) {
				parent.right = p.left;
			} else {
				parent.left = p.left;
			}
		} else {
			TreeNode pp = p.right;
			while(pp.left != null) pp = pp.left;
			p.val = pp.val;
			p.right = this.deleteBST(p.right, pp.val);
		}
		return rr.left;*/
	}
	
	private void inorder(TreeNode n, List<Integer> result) {
		if(n == null) return;
		
		inorder(n.left, result);
		result.add(n.val);
		inorder(n.right, result);
	}
	public List<Integer> inorder() {
		List<Integer> result = new ArrayList<>();
		this.inorder(this, result);
		return result;
	}
	
	private int _levels(TreeNode root) {
		if (root == null) return 0;
		return Math.max(this._levels(root.left), this._levels(root.right))+1;
	}
	public int maxLevels() {
		return this._levels(this);
	}
	
	private static TreeNode toBst(int[] nums, int s, int e) {
		if(s > e) return null;
		int m = (s+e)/2;
		TreeNode root = new TreeNode(nums[m]);
		root.left = toBst(nums, s, m-1);
		root.right = toBst(nums, m+1, e);
		
		return root;
	}
	public static TreeNode sortedArrayToBST(int[] nums) {
		int l = nums.length;
        if(l == 0) return null;
        
        return toBst(nums, 0, l-1); 
    }
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.deserialize(//"10,20,30,40,50,null,null,null,null,60,70,null,null,null,80");
				"20,10,30,5,15,27,35,3,8,13,17,25,29,34,38,null,4"
				);
		System.out.println(root.inorder());
		/*System.out.println(root.levelView());
		System.out.println(root.topView());
		System.out.println(root.bottomView());
		System.out.println(root.inorderPredecesor(13));
		System.out.println(root.inorderSuccessor(13));
		System.out.println(root.lowestCommonAncestor(3, 8));
		System.out.println(root.getNodes(3));
		System.out.println(root.leafPath());
		System.out.println(root.digonal());
		System.out.println(root.getNodesForSum(30));
		System.out.println(TreeNode.deserialize("1,2,2,1").isMirror());
		System.out.println(TreeNode.deserialize("1,2,3,4,5").mirror().serialize());*/
		
		System.out.println(root.deleteBST(20).inorder());
		System.out.println(TreeNode.deserialize("1,2,3,null,null,4,null,null,5").maxLevels());
		System.out.println(TreeNode.sortedArrayToBST(new int[]{1,2,3,4,5,6,7}).levelView());
	}
}

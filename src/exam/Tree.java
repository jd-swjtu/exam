package exam;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
	
	public List<Integer> inorderTraversalx(TreeNode root) {
		List<Integer> results = new ArrayList<Integer>();
		Deque<TreeNode> q = new LinkedList<TreeNode>();
		
		TreeNode n = root;
		
		while(n != null) {
			q.push(n);
			
			//Pre order
			results.add(n.val);
			n = n.left;
		}
		
		while (q.size() > 0) {
			n = q.pop();
			
			//Inorder
			//results.add(n.val);
			
			if(n.right != null) {
				n = n.right;
				
				while(n != null) {
					q.push(n);
					
					//pre order
					results.add(n.val);
					n = n.left;
				}
			}
		}
		
		return results;
	}
	
	public List<Integer> inorderTraversaly(TreeNode root) {
		List<Integer> results = new ArrayList<Integer>();
		Deque<TreeNode> q = new LinkedList<TreeNode>();
		
		TreeNode n = root;
		
		while(n != null || q.size() > 0) {
			
			while (n!= null) {
				q.push(n);
				//Pre order
				results.add(n.val);
				n = n.left;
			}
			
			if(q.size()>0) n = q.pop();
			if(n != null ) {
				if(n.right != null) {
					q.push(n.right);
					n = n.right;
				} else {
					n = null;
				}
			}
		}
		
		return results;
	}

	private void tranversal(TreeNode node, List<Integer> results) {
		if(node != null) {
			tranversal(node.left, results);
			results.add(node.val);
			tranversal(node.right, results);
		}
	}

	public TreeNode genTree(TreeNode root, int v) {
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

	public TreeNode clone(TreeNode root) {
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

	@LeetCode(98)
	public boolean isValidBST(TreeNode root) {
		return tranversalx(root);
	}
	public boolean isValidBSTx(TreeNode root) {
		if(root == null) return true;
		return tranversalx(root, root.left, root.right);
	}
	
	private long vv = Long.MIN_VALUE;
	private boolean tranversalx(TreeNode node) {
		if(node != null) {
			if(!tranversalx(node.left)) return false;
			if(node.val <= vv) return false;
			else vv = node.val;
			if(!tranversalx(node.right)) return false;
		}
		return true;
	}
	
	private boolean tranversalx(TreeNode node, TreeNode left, TreeNode right) {
		boolean result = true;
		if(left != null) {
			result &= left.val < node.val && tranversalx(left, left.left, left.right);
		}
		
		if(right != null) {
			result &= right.val > node.val && tranversalx(right, right.left, right.right);
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

	@LeetCode(103)
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

	@LeetCode(104)
	public int maxDepth(TreeNode root) {
		maxLevels = 0;
		tranversalxx(root, 0);
		return maxLevels;
	}
	private int maxLevels = 0;

	private void tranversalxx(TreeNode node, int max) {
		if(node != null) {
			tranversalxx(node.left, max + 1);
			if(max+1 > maxLevels) {
				maxLevels = max + 1;
			}
			tranversalxx(node.right, max + 1);
		}
	}

	//Low efficiency
	@LeetCode(107)
	public List<List<Integer>> levelOrderBottomx(TreeNode root) {
		List<List<Integer>> results = levelOrder(root);
		int size = results.size();
		for(int i=0; i<size/2; i++) {
			List<Integer> r = results.get(i);
			results.set(i, results.get(size-1-i));
			results.set(size-1-i, r);
		}
		return results;
	}

	@LeetCode(107)
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
				results.add(0, r);
				r = new ArrayList<Integer>();
			}
		}

		return results;
	}

	@LeetCode(105)
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode root = new TreeNode(0);
		buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, root, true);
		return root.left;
	}

	private void buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, TreeNode root, boolean isLeft) {
		if(ps > pe) return;

		int v = preorder[ps];

		//Find it in inorder
		int idx = -1;
		for(int i=is; i<=ie; i++) {
			if(inorder[i] == v) {
				idx = i;
				break;
			}
		}
		if(idx == -1) return;

		//left: is - idx-1
		//right: idx + 1, ie
		//left len = idx - is
		int leftlen = idx - is;
		int rightlen = ie - idx;
		TreeNode node = new TreeNode(v);
		if(isLeft) {
			root.left = node;
		} else {
			root.right = node;
		}
		if(leftlen != 0)
			buildTree(preorder, ps+1, ps + leftlen, inorder, is, idx-1, node, true);

		if(rightlen != 0)
			buildTree(preorder, ps+1 + leftlen, pe, inorder, idx+1, ie, node, false);
	}
	
	
	@LeetCode(105)
	public TreeNode buildTreePost( int[] inorder, int[] postorder) {
		TreeNode root = new TreeNode(0);
		for(int i=0; i<postorder.length/2; i++) {
			int t = postorder[i];
			postorder[i] = postorder[postorder.length-1-i];
			postorder[postorder.length-1-i] = t;
		}
		buildTreex(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, root, true);
		return root.left;
	}
	
	private void buildTreex(int[] postorder, int ps, int pe, int[] inorder, int is, int ie, TreeNode root, boolean isLeft) {
		if(ps > pe) return;

		int v = postorder[ps];

		//Find it in inorder
		int idx = -1;
		for(int i=is; i<=ie; i++) {
			if(inorder[i] == v) {
				idx = i;
				break;
			}
		}
		if(idx == -1) return;

		//left: is - idx-1
		//right: idx + 1, ie
		//left len = idx - is
		int leftlen = idx - is;
		int rightlen = ie - idx;
		TreeNode node = new TreeNode(v);
		if(isLeft) {
			root.left = node;
		} else {
			root.right = node;
		}
		if(leftlen != 0)
			buildTreex(postorder, ps+1+rightlen, pe, inorder, is, idx-1, node, true);

		if(rightlen != 0)
			buildTreex(postorder, ps+1, pe + rightlen, inorder, idx+1, ie, node, false);
	}
	
	@LeetCode(108)
	public TreeNode sortedArrayToBST(int[] nums) {
		TreeNode _root = new TreeNode(0);
		sortedArrayToBST(nums, 0, nums.length-1, _root, true);
		return _root.left;
	}

	private void sortedArrayToBST(int[] nums, int s, int e, TreeNode p, boolean isLeft) {
		if(s>e) return;
		int m = (s + e)/2;

		TreeNode node = new TreeNode(nums[m]);
		if(isLeft) p.left = node;
		else p.right = node;

		sortedArrayToBST(nums, s, m-1, node, true);
		sortedArrayToBST(nums, m+1, e, node, false);
	}
	
	public TreeNode sortedArrayToBSTx(int[] nums) {

		
		int levels = 0;
		int len = nums.length;
		while(len > 0) {
			levels++;
			len /= 2;
		}
		len = nums.length;
		
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		for(int i=0; i<len; i++) {
			nodes.add(new TreeNode(nums[i]));
		}
		
		int w = 1;
		for(int i=0; i<levels; i++) {
			int start = w - 1;
			w *= 2;
			int space = w * 2;
			
			for(int k=start; k<len; k += space) {
				
			}
		}
		

		TreeNode _root = new TreeNode(0);
		
		
		return _root.left;
	}
	
	@LeetCode(value=236, c="a")
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null)
			return null;

		if(root==p || root==q)
			return root;

		TreeNode l = lowestCommonAncestor(root.left, p, q);
		TreeNode r = lowestCommonAncestor(root.right, p, q);

		if(l!=null&&r!=null){
			return root;
		}else if(l==null&&r==null){
			return null;
		}else{
			return l==null?r:l;
		}
	}
	
	@LeetCode(value=235, c="a")
	public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < q.val)
          return lowestCommonAncestorX(root, p, q);
         else
         return lowestCommonAncestorX(root, q, p);
    }
    
    public TreeNode lowestCommonAncestorX(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        
        if(root==p || root==q)
			return root;
        
        if(p.val < root.val && q.val > root.val) 
        	return root;
        else if(p.val < root.val && q.val < root.val) 
        	return lowestCommonAncestorX(root.left, p, q);
        else if(p.val > root.val && q.val > root.val) 
        	return lowestCommonAncestorX(root.right, p, q);
        else 
        	return null;
    }
    
    public int constructAE(char[] order, TreeNode root, int s, boolean isLeft) {
    	char c = order[s];
    	
    	TreeNode tmp = new TreeNode(c);
    	if( c == '+' || c == '-' || c == '*' || c == '/') {
    		if(isLeft) {
    			root.left = tmp;
    		} else {
    			root.right = tmp;
    		}
    		
    		return constructAE(order, tmp, constructAE(order, tmp, s+1, false), true);
    	} else {
    		if(isLeft) root.left = tmp;
    		else root.right = tmp;
    		
    		return s+1;
    	}
    }
    
    public TreeNode constructAE(String postOrder) {
    	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    	for(char c: postOrder.toCharArray()) {
    		TreeNode tmp = new TreeNode(c);
    		if( c == '+' || c == '-' || c == '*' || c == '/') {
    			TreeNode r = stack.pop();
    			TreeNode l = stack.pop();
    			
    			tmp.left = l;
    			tmp.right = r;
    		}
    		stack.push(tmp);
    	}
    	return stack.pop();
    }

	public static void main(String[] args) {
		Tree t = new Tree();
		/*List<TreeNode> trees = t.generateTrees(3);
		for(TreeNode tree: trees) {
			System.out.println(t.inorderTraversal(t.deserialize(t.serialize(tree))));
		}
		System.out.println(trees.size() + " " + t.calBST(1, 4));*/
		//List<Integer> nodes = new ArrayList<Integer>();
		//nodes.add(104);nodes.add(5);nodes.add(15);nodes.add(null);nodes.add(null);nodes.add(6);nodes.add(20);
		//TreeNode node = t.deserialize(nodes);
			//System.out.println(t.isValidBST(node));
			
			//System.out.println(t.isValidBSTx(node));
		//System.out.println(t.inorderTraversal(node));
		//System.out.println(t.inorderTraversalx(node));
		//System.out.println(t.inorderTraversaly(node));
		/*t.recoverTree(node);
		System.out.println(t.inorderTraversal(node));*/

		//System.out.println(t.inorderTraversal(t.buildTree(new int[]{4, 2,1,3,6,5,7}, new int[]{1,2,3,4,5,6,7})));
		
		//System.out.println(t.inorderTraversal(t.buildTreePost(new int[]{1,2,3,4,5,6,7}, new int[]{1,3,2,5,7,6,4})));
		
		//System.out.println(t.inorderTraversal(t.buildTreePost(new int[]{1,2,3,4,5}, new int[]{2,3,1,5,4})));
		//System.out.println(t.inorderTraversal(t.sortedArrayToBSTx(new int[]{1,2,3,4})));
		
		//System.out.println(TreeNode.deserialize("1,2,null,null,3,4").serialize());
		
		TreeNode root = new TreeNode(0);
		String s = "-*g*fe+ba";
		t.constructAE(s.toCharArray(), root, 0, true);
		for(Integer i: t.inorderTraversal(root.left)) {
			System.out.print(String.valueOf((char)i.intValue()) + " ");
		}
		System.out.println();
		for(Integer i: t.inorderTraversal(t.constructAE("ab+ef*g*-"))) {
			System.out.print(String.valueOf((char)i.intValue()) + " ");
		}
	}
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
	
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

class EmptyNode extends TreeNode {
	public EmptyNode(){
		super(0);
	}
}
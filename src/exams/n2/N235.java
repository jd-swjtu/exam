package exams.n2;

import exams.utils.TreeNode;

public class N235 {
	public static void main(String[] args) {
		TreeNode root = TreeNode.deserialize("5,3,7,2,4,6,8");
		
		System.out.println(new N235().lowestCommonAncestor(root, new TreeNode(5), new TreeNode(8)));
	}

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return root;
        
        if(p.val < root.val) {
        	if(root.val < q.val)  return root;
        	else
        		return lowestCommonAncestor(root.left, p, q);
        } else {
        	if(q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        	else return null;
        }
    }
}

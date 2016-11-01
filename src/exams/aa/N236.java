package exams.aa;

import exams.utils.TreeNode;

public class N236 {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		
		n1.left = n2;
		n1.right = n3;
		n3.right = n4;
		
		System.out.println(new N236().lowestCommonAncestor(n1, n3, n4));
	}

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root == null) return root;
        
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        
        if(l != null && r != null) return root;
        
        return (l == null)?r:l;
    }
}

package exams.n1;

import exams.utils.TreeNode;

/*
 Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
       8 9     10
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */
public class N117 {
	public void connect(TreeNode root) {
		if (root == null)
			return;
		
		TreeNode r = root;
		TreeNode p = null;
		TreeNode np = null;
		TreeNode nr = null;
		
		while(r != null) {
			if(p != null) {
				if (p.left == null || p.right == null) {
					//r -- p.right or p.left
					if (p.next != null) {
						r.next = (p.next.left != null)?p.next.left:p.next.right;
					}
				} else {
					//p has left/right
					r.next = p.right;
					if (p.next != null) {
						r.next.next = (p.next.left != null)?p.next.left:p.next.right;
						r = r.next;
					}
				}
			}
		
			if(nr == null && r.left != null) {
				nr = r.left;
				np = r;
			}
			if(nr == null && r.right != null) {
				nr = r.right;
				np = r;
			}
		
			if (p != null && p.next != null) {
				r = r.next;
				p = p.next;
				System.out.println("--" + p.val + "/" + (r!=null?r.val:"-"));
			} else {
				r = nr;
				p = np;
				nr = null;
				np = null;
				System.out.println("C/P = " + (r!=null?r.val:"-")  + "/" + (p!=null?p.val:"-"));
			}
		}

		System.out.println("Done");
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.deserialize("1,2,3,4,5,null,7,null,null,8,9,null,10");
		N117 n117 = new N117();
		n117.connect(root);
		System.out.println(root.next());

	}

}

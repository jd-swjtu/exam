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
	public void connect1(TreeNode root) {
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

	public void connect2(TreeNode root) {
		if (root == null)
			return;

		TreeNode p = null;
		TreeNode q = root;
		
		TreeNode[] t = new TreeNode[3];

		while(true) {
			//q -- level has been organized ->next
			while(q != null) {
				int i=0;
				//Get q children
				if (q.left != null) t[i++] = q.left;
				if (q.right != null) t[i++] = q.right;

				//Get next child after q - q.next maybe null, or q.next no children, until at the end or find child
				q = q.next;
				while (q != null && (q.left == null && q.right == null)) {
					q = q.next;
				}
				if (q != null) {
					t[i++] = q.left != null?q.left:q.right;
				}

				if (i>1) {
					t[0].next = t[1];
				}
				if (i>2) {
					t[1].next = t[2];
				}
			
				//No child, move to next level
				if (i==0) {
					break;
				}

				//Next level the first child
				if (p == null) {
					p = t[0];
				}
			}
			
			//p is first node of next level
			if (p != null) {
				q = p;
				p = null;
			} else
				//next level no child now
				break;
        	}
	}

	public void connect(TreeNode root) {
		if (root == null)
			return;

		TreeNode p = null, h = null;
		TreeNode q = root;

		while ( q != null ) {
			if (q.left != null) {
				if(p != null) {
					p.next = q.left;
				}
				p = q.left;
				if(h == null) {
					h = p;
				}
			}

			if (q.right != null) {
				if(p != null) {
					p.next = q.right;
				}
				p = q.right;
				if(h == null) {
					h = p;
				}
			}

			q = q.next;
			if (q == null) {
				q = h;
				h = null;
				p = null;
			}
		}
	}

	public static void main(String[] args) {
		//TreeNode root = TreeNode.deserialize("1,2,3,4,5,6,7,8,9,null,null,10");
		//TreeNode root = TreeNode.deserialize("20,10,30,5,15,25,35,3,8,13,17,27,29,34,38");
		TreeNode root = TreeNode.deserialize("1,2,3,4,5,null,7,null,12,8,9,null,10");
		N117 n117 = new N117();
		n117.connect(root);
		System.out.println(root.next());
	}
}

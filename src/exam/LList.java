package exam;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LList {

	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		ListNode tail = new ListNode('x');
		head.next = tail;
		tail.next = head;

		head = ListNode.create("1234567890");
		//head.next.next.next.next.next = head.next.next;
		LList l = new LList();
		//System.out.println(l.hasCycle(head));

		tail.next = head.next.next;
		//System.out.println(l.getIntersectionNodex(head,  tail));
		//System.out.println(l.getIntersectionNode(head,  tail));

		MinStack minStack = new MinStack();
		/*for(int i=10; i>0; i--) {
			minStack.push(i);
			if(i%3==0) minStack.pop();
			System.out.println("=" + minStack.getMin());
		}*/
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.push(1);
		System.out.println(minStack.getMin()); //   --> Returns -3.
		//minStack.pop();
		//System.out.println(minStack.top()); //     --> Returns 0.
		//System.out.println(minStack.getMin());
		System.out.println(minStack.peekMax());
		minStack.popMax();
		System.out.println(minStack.getMin());
		System.out.println(minStack.peekMax());

		System.out.println(l.rotateRight(ListNode.create("12"), 3));

		System.out.println("==83==");
		System.out.println(l.deleteDuplicates(ListNode.create("112233333344")));
		System.out.println("==82==");
		System.out.println(l.deleteDuplicatesAll(ListNode.create("")));
		System.out.println("==143==");
		ListNode nn = ListNode.create("");
		l.reorderList(nn);
		System.out.println(nn);

		System.out.println("==146==");
		LRUCache lru = new LRUCache(2);
		/*lru.set(2, 1);
		lru.set(1, 1);
		System.out.println(lru.get(2));
		lru.set(4,1);
		System.out.println(lru.get(1));
		System.out.println(lru.get(2));*/

		/*System.out.println(lru.get(2));
		lru.set(2,6);
		lru.peek();
		System.out.println(lru.get(1));
		lru.set(1,5);
		lru.peek();
		lru.set(1,2);
		lru.peek();
		System.out.println(lru.get(1));
		lru.peek();
		System.out.println(lru.get(2));*/

		lru = new LRUCache(3);
		lru.set(1,1); 
		lru.set(2,2); 
		lru.set(3,3);
		lru.set(4,4);
		lru.get(4);
		lru.get(3);
		lru.get(2);
		lru.get(1);
		lru.set(5,5);
		lru.peek();
		System.out.println(lru.get(1));
		lru.peek();
		System.out.println(lru.get(2));
		lru.peek();
		System.out.println(lru.get(3));
		lru.peek();
		System.out.println(lru.get(4));
		lru.peek();
		System.out.println(lru.get(5));

		ListNode ln = ListNode.create("123456");
		System.out.println(ln + " - " + ln.reverse());

		System.out.println(l.searchMatrix(new int[][]{
			{1,   4,  6, 11, 15},
			{2,   5,  8, 12, 19},
			{3,   6,  9, 16, 22},
			{10, 13, 14, 17, 24},
			{18, 21, 23, 26, 30}
		}, 6));
		
		System.out.println(l.isPalindrome(ListNode.create("1121")));
	}
	
	@LeetCode(234)
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        int len = 0;
        ListNode p = head;
        while(p!=null) {
            len++;
            p=p.next;
        }
        if(len == 1) return false;
        
        int go = (len+1)/2;
        p = head;
        while(go > 0) {
            p = p.next;
            go--;
        }
        
        ListNode q = p;
        p = p.next;
        q.next = null;
        while(p != null) {
            ListNode e = p;
            p = p.next;
            
            e.next = q;
            q = e;
        }
        
        p = head;
        while(q != null && p.val == q.val) {
            p = p.next;
            q = q.next;
        }
        
        if(q != null) return false;
        return true;
    }

	@LeetCode(value=240, c="a")
	public int searchMatrix(int[][] matrix, int target) {
		// check corner case
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		if (matrix[0] == null || matrix[0].length == 0) {
			return 0;
		}

		// from bottom left to top right
		int n = matrix.length;
		int m = matrix[0].length;
		int x = n - 1;
		int y = 0;
		int count = 0;

		while (x >= 0 && y < m) {
			System.out.println("x,y=" + x + ":" + y);
			if (matrix[x][y] < target) {
				y++;
			} else if (matrix[x][y] > target) {
				x--;
			} else {
				count++;
				x--;
				y++;
			}

		}
		return count;
	}

	void inQueue(Deque<Integer> deque, int num) {
		while (!deque.isEmpty() && deque.peekLast() < num) {
			deque.pollLast();
		}
		deque.offer(num);
	}

	void outQueue(Deque<Integer> deque, int num) {
		if (deque.peekFirst() == num) {
			deque.pollFirst();
		}
	}

	@LeetCode(value=239, c="a")
	public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
		// write your code here
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Deque<Integer> deque = new ArrayDeque<Integer>();
		if (nums.length == 0) {
			return ans;
		}
		for (int i = 0; i < k - 1; i++) {
			inQueue(deque, nums[i]);
		}

		for(int i = k - 1; i < nums.length; i++) {
			inQueue(deque, nums[i]);
			ans.add(deque.peekFirst());
			outQueue(deque, nums[i - k + 1]);
		}
		return ans;

	}

	@LeetCode(143)
	public void reorderList(ListNode head) {
		if(head == null) return;
		List<ListNode> nodes = new ArrayList<ListNode>();
		ListNode p = head;
		while(p != null) {
			nodes.add(p);
			p = p.next;
		}
		System.out.println("Size:" + nodes.size());
		nodes.get((nodes.size()+1)/2-1).next = null;
		p=head;
		for(int i=0; i<nodes.size()/2; i+=1) {
			ListNode q = nodes.get(nodes.size() - i - 1);
			q.next = p.next;
			p.next = q;
			p = q.next;
		}
	}

	//@LeetCode(86)
	public ListNode partition(ListNode head, int x) {
		if(head == null) return null;

		ListNode tail = head;
		while(tail.next != null) {
			tail = tail.next;
		}

		ListNode t = tail.next;
		ListNode p = head;
		return null;
	}

	@LeetCode(83)
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return null;

		int v = head.val;
		ListNode p = head;
		while(p.next != null) {
			int cv = p.next.val;
			if(cv == v) {
				p.next = p.next.next;
			} else {
				p = p.next;
				v = cv;
			}
		}

		return head;
	}

	//Low efficiency
	@LeetCode(82)
	public ListNode deleteDuplicatesAll(ListNode head) {
		if(head == null) return null;

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode p = dummy;
		int v = head.val;
		boolean removed = false;
		while(p.next.next != null) {
			int cv = p.next.next.val;
			if(cv == v) {
				p.next.next = p.next.next.next;
				removed = true;
			} else {
				if(removed) {
					p.next = p.next.next;
					removed=false;
					if(p.next == null) break;
				} else {
					p = p.next;
				}
				v = cv;
			}
		}
		if(removed) {
			p.next = null;
		}

		return dummy.next;
	}

	@LeetCode(61)
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null) {
			return null;
		}

		ListNode p = head;
		int len = 0;
		while(p.next != null) {
			p = p.next;
			len++;
		}
		len += 1;

		k = k%len;
		if(k == 0) return head;

		p.next = head;
		int t = len - k - 1;
		p = head;
		while(t>0) {
			p = p.next;
			t--;
		}

		ListNode q = p.next;
		p.next = null;
		return q;
	}

	@LeetCode(value=141, c="a")
	public boolean hasCycle(ListNode head) {
		if(head == null) return false;

		ListNode p = head;
		ListNode q = head.next;

		while(p != q && q != null && q.next != null) {
			p = p.next;
			q = q.next.next;
		}

		if(q == null || q.next == null)
			return false;
		return true;
	}

	public ListNode getIntersectionNodex(ListNode headA, ListNode headB) {
		if(headA == null && headB == null) return null;

		ListNode pA = headA;
		ListNode pB = headB;

		int la=0;
		int lb=0;

		while(pA!=null) {la++; pA = pA.next;}
		while(pB!=null) {lb++; pB = pB.next;}

		pA = headA;
		pB=headB;
		if(lb>la) {
			int c = lb-la;
			while(c>0) {
				pB = pB.next;
				c--;
			}
			while(la>0) {
				if(pA == pB) return pA;
				pB = pB.next;
				pA = pA.next;
			}
		} else {
			int c = la - lb;
			while(c>0) {pA = pA.next;c--;}
			while(lb>0) {
				if(pA == pB) return pA;
				pB = pB.next;
				pA = pA.next;
			}
		}
		return null;
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null && headB == null) return null;

		ListNode pA = headA;
		ListNode pB = headB;

		while(pA!=null && pB!=null) {pA = pA.next; pB=pB.next;}
		if(pA != null) {
			pB = headB;
			while(pA!=null && pB!=null) {
				pA = pA.next; pB=pB.next;
			}

			if(pB!=null) {
				pA = headA;
			}

			while(pA!=null && pB!=null) {
				if(pA == pB) return pA;
				pA = pA.next; pB=pB.next;
			}
		} else if(pB != null) {
			pA = headA;
			while(pA!=null && pB!=null) {
				pA = pA.next; pB=pB.next;
			}

			if(pA!=null) {
				pB = headB;
			}

			while(pA!=null && pB!=null) {
				if(pA == pB) return pA;
				pA = pA.next; pB=pB.next;
			}
		}

		return null;
	}

	//Copy From internet
	private void copyNext(RandomListNode head) {
		while (head != null) {
			RandomListNode newNode = new RandomListNode(head.label);
			newNode.random = head.random;
			newNode.next = head.next;
			head.next = newNode;
			head = head.next.next;
		}
	}

	private void copyRandom(RandomListNode head) {
		while (head != null) {
			if (head.next.random != null) {
				head.next.random = head.random.next;
			}
			head = head.next.next;
		}
	}

	private RandomListNode splitList(RandomListNode head) {
		RandomListNode newHead = head.next;
		while (head != null) {
			RandomListNode temp = head.next;
			head.next = temp.next;
			head = head.next;
			if (temp.next != null) {
				temp.next = temp.next.next;
			}
		}
		return newHead;
	}

	@LeetCode(value=138, c="a")
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		copyNext(head);
		copyRandom(head);
		return splitList(head);
	}
}

class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
}


class MinStack {
	class NNode {
		NNode next;
		int val;
		int min;

		NNode max;

		NNode(int v){val = v; min = v; max = this;}
	}

	private NNode top;
	
	/** initialize your data structure here. */
	public MinStack() {
		top = new NNode(0);
	}

	@LeetCode(value=155, c="a")
	public void push(int x) {
		NNode node = new NNode(x);

		node.next = top.next;
		top.next = node;

		if(node.next != null) {
			if(node.next.min < x) {
				node.min = node.next.min;
			}
		}

		if(node.next != null) {
			if(node.next.max.val > x) {
				node.max = node.next.max;
			}
		}
	}

	public void pop() {
		top.next = top.next.next;
	}

	public int top() {
		return top.next.val;
	}

	public int getMin() {
		return top.next.min;
	}

	public int peekMax() {
		return top.next.max.val;
	}


	public void popMax() {
		NNode p = top.next.max;
		NNode q = top;
		while(q.next != p) {
			q = q.next;
		}
		if(q.next.next != null) {
			if(q.max.val > q.next.next.max.val) {
				q.max = q.next.next.max;
			}
		}
		q.next = q.next.next;

		p = top.next;
		while(p != q.next) {
			if(p.min > q.next.min) {
				p.min = q.next.min;
			}
			if(p.max.val < q.next.max.val) {
				p.max = q.next.max;
			}

			p = p.next;
		}

		//TODO: update max, min - reverse order
	}
}

class MinStackx {
	class NNode {
		NNode left, right;
		NNode next;
		int val;

		NNode(int v){val = v;}
	}

	private NNode top, root;

	/** initialize your data structure here. */
	public MinStackx() {
		top = new NNode(0);
		root =new NNode(0);
	}

	public void push(int x) {
		NNode node = new NNode(x);

		node.next = top.next;
		top.next = node;

		NNode p = root;
		NNode q = root.left;
		while(q != null && q.val < x) {
			p = q;
			q = q.left;
		}
		p.left = node;
		node.right = p;
		node.left = q;
		if(q!=null) q.right = node;
	}

	public void pop() {
		//int v = top.right.val;

		NNode p = top.next.right;
		NNode q = top.next.left;
		top.next = top.next.next;

		if(p != null) {
			p.left = q;
		}
		if(q != null) {
			q.right = p;
		}
	}

	public int top() {
		return top.next.val;
	}

	public int getMin() {
		return root.left.val;
	}
}


class LRUCache {
	private int counter = 0;
	private int capacity = 0;

	private Map<Integer,Integer> items = new HashMap<Integer,Integer>();
	private LinkedList<Integer> list = new LinkedList<Integer>();

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public void peek() {
		//System.out.println("#:");
	}
	public int get(int key) {
		if(items.keySet().contains(key)) {
			list.removeFirstOccurrence(key);
			list.addLast(key);
			return items.get(key).intValue();
		}
		return -1;
	}

	@LeetCode(value=146, c="a")
	public void set(int key, int value) {
		if(items.keySet().contains(key)) {
			list.remove(key);
			list.addLast(key);

			items.put(key, value);
		} else {
			if(counter >= capacity) {
				int oldkey = list.removeFirst();
				list.add(key);
				items.remove(oldkey);
				items.put(key, value);
			} else {
				counter++;
				list.add(key);
				items.put(key, value);
			}
		}
	}
}

class LRUCacheX {
	private int counter = 0;
	private int capacity = 0;

	class Item {
		int value;
		int key;

		Item next;
		Item prev;

		public Item(int k, int v) {
			value = v;
			key = k;
		}
	}

	private Map<Integer,Item> items = new HashMap<Integer,Item>();
	private Item header = new Item(0,0);

	public LRUCacheX(int capacity) {
		this.capacity = capacity;
		header.next = header;
		header.prev = header;
	}

	public void peek() {
		System.out.print("#:");
		Item p = header.next;
		while(p != null && p != header) {
			System.out.print(" " + p.key + "-" + p.value);
			p = p.next;
		}
		System.out.println();
	}
	public int get(int key) {
		if(items.keySet().contains(key)) {
			Item item = items.get(key);
			set(key,item.value);

			return item.value;
		}
		return -1;
	}

	@LeetCode(value=146, c="a")
	public void set(int key, int value) {
		if(items.keySet().contains(key)) {
			Item item = items.get(key);

			//Remove
			Item q = item.next;
			Item p = item.prev;
			p.next = q;
			if(q != null) q.prev = p;

			//Insert
			item.value = value;
			q = header.next;
			item.next = q;
			item.prev = header;

			header.next = item;
			q.prev = item;
		} else {
			if(counter >= capacity) {
				Item q = header.prev;
				items.remove(q.key);

				q.prev.next = header;
				header.prev = q.prev;

				//update q
				q.key = key;
				q.value = value;
				header.next.prev = q;
				q.next = header.next;
				header.next = q;
				q.prev = header;

				items.put(key, q);
			} else {
				counter++;
				Item item = new Item(key, value);
				items.put(key, item);

				Item q = header.next;
				item.next = q;
				item.prev = header;

				header.next = item;
				q.prev = item;
			}
		}
	}
}
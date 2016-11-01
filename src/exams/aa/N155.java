package exams.aa;

public class N155 {

	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(1);
		obj.push(3);
		obj.push(4);
		System.out.println(obj.top());
		System.out.println(obj.getMin());

		obj.push(1);
		System.out.println(obj.top());
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMin());
	}
}

class MinStack {
	class NNode {
		int val;

		NNode next;
		int min;

		public NNode(int v) {
			this.val = v;
			this.min = v;
		}
	}

	private NNode head = null;

	public void push(int v) {
		if(head == null) {
			head = new NNode(v);
		} else {
			NNode t = new NNode(v);
			if(v > head.min) {
				t.min = head.min;
			}

			t.next = head;
			head = t;
		}
	}

	public int pop() {
		if(head != null) {
			int v = head.val;
			head = head.next;

			return v;
		}
		return -1;
	}

	public int top() {
		if(head != null) {
			return head.val;
		}
		return -1;
	}

	public int getMin() {
		if(head != null) {
			return head.min;
		}
		return -1;
	}
}
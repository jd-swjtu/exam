package exams.aa;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class N146 {

	public static void main(String[] args) {
		LRUCache2 lru = new LRUCache2(0);
		lru.set(1, 1);
		lru.set(2, 2);
		lru.set(3, 3);
		
		System.out.println(lru.get(1));
		System.out.println(lru.get(2));
		System.out.println(lru.get(3));
		lru.set(4, 4);
		lru.set(5, 5);
		lru.set(0, 6);
		System.out.println(lru.get(1));
		System.out.println(lru.get(2));
		System.out.println(lru.get(3));
		System.out.println(lru.get(4));
		System.out.println(lru.get(5));
		System.out.println(lru.get(0));
	}

}

class LRUCache {
	class Item {
		int key;
		int value;
		
		Item next;
		Item prev;
		
		public Item(int k, int v) {
			this.key = k;
			this.value = v;
		}
	};
	
	private Item head = new Item(0,0);
	private Map<Integer,Item> items = new HashMap<>();
	private int cap = 0;
	private int count = 0;
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        if(this.cap == 0) this.cap = 3;
        
        head.next = head;
        head.prev = head;
    }
    
    public int get(int key) {
        if(items.containsKey(key)) {
        	Item item = items.get(key);
        	
        	Item next = item.next;
        	if(next != null) {
        		next.prev = item.prev;
        	}
        	item.prev.next = next;
        	
        	if(head.next != null) {
        		head.next.prev = item;
        	}
        	item.next = head.next;
        	head.next = item;
        	
        	return item.value;
        }
        
        return -1;
    }
    
    public void set(int key, int value) {
        if(items.containsKey(key)) {
        	get(key);
        } else {
        	if(count == cap){
        		Item item = head.prev;
        		if(item != head) {
        			Item prev = item.prev;
        			prev.next = head;
        			head.prev = prev;
        			
        			items.remove(item.key);
        		}
        		
        		count--;
        	}
        	
        	count++;
        	Item item = new Item(key, value);
        	items.put(key, item);
        	
        	Item next = head.next;
        	if(next != null) {
        		next.prev = item;
        	}
        	item.next = next;
        	item.prev = head;
        	head.next = item;
        }
    }
}

class LRUCache2 {
	private Map<Integer,Integer> items = new HashMap<>();
	private LinkedList<Integer> lists = new LinkedList<>();
	private int cap = 0;
	private int count = 0;
    
    public LRUCache2(int capacity) {
        this.cap = capacity;
        if(this.cap == 0) this.cap = 3;
    }
    
    public int get(int key) {
        if(items.keySet().contains(Integer.valueOf(key))) {
        	Integer item = items.get(key);
        	lists.remove(item);
        	lists.addLast(item);
        	
        	return item.intValue();
        }
        
        return -1;
    }
    
    public void set(int key, int value) {
        if(items.containsKey(key)) {
        	get(key);
        } else {
        	if(count == cap){
        		Integer item = lists.removeFirst();
        		items.remove(item);
        		
        		count--;
        	}
        	
        	count++;
        	items.put(key, value);
        	
        	lists.addLast(key);
        }
    }
}
package exam;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {

	public static void main(String[] args) {
		System.out.println(UndirectedGraphNode.serialize(UndirectedGraphNode.deserialize("0,1,2#1,2#2,2")));
	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	
	public void addNeighbors(UndirectedGraphNode... args) {
		for(UndirectedGraphNode x: args) {
			neighbors.add(x);
		}
	}
	
	public String toString() {
		return String.valueOf(label);
	}
	
	public static UndirectedGraphNode deserialize(String str) {
		UndirectedGraphNode start = null;
		Map<Integer, UndirectedGraphNode> mapping = new HashMap<Integer, UndirectedGraphNode>();
		String[] nodeStrs = str.split("#");
		for(String nodeString: nodeStrs) {
			String[] ss = nodeString.split(",");
			int label = Integer.parseInt(ss[0]);
			
			UndirectedGraphNode x = new UndirectedGraphNode(label);
			mapping.put(label, x);
			
			if(start == null) start = x;
		}
		
		for(String nodeString: nodeStrs) {
			String[] ss = nodeString.split(",");
			
			UndirectedGraphNode node = mapping.get(Integer.parseInt(ss[0]));
			for(int i=1; i<ss.length; i++) {
				int label = Integer.parseInt(ss[i]);
				node.addNeighbors(mapping.get(label));
			}
		}
		
		return start;
	}
	
	public static String serialize(UndirectedGraphNode start) {
		if(start == null) return "";
		
		Set<Integer> set = new HashSet<Integer>();
		Queue<UndirectedGraphNode> q = new ArrayDeque<UndirectedGraphNode>();
		StringBuffer sbf = new StringBuffer();
		
		q.add(start);

		while(!q.isEmpty()) {
			UndirectedGraphNode n = q.poll();
			if(set.contains(n.label)) continue;
			sbf.append(n.label);
			set.add(n.label);
			
			for(UndirectedGraphNode p: n.neighbors) {
				sbf.append(",").append(p.label);
				q.add(p);
			}
			sbf.append("#");
		}
		sbf.deleteCharAt(sbf.length()-1);	
		return sbf.toString();
	}
};
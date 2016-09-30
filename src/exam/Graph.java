package exam;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {

	public static void main(String[] args) {
		Graph g = new Graph();
		//System.out.println(UndirectedGraphNode.serialize(UndirectedGraphNode.deserialize("0,1,2#1,2#2,2")));

		//System.out.println(UndirectedGraphNode.serialize(UndirectedGraphNode.deserialize("0,1,2#1,2#2,2").clone()));
		
		System.out.println("------------" + g.wordLadder(//endWord, others)g.ladderLength(new String[]{
//				"hot",
//				"dog",
//				"dot"}));
				
		"cet",
		"ism",
		
		"cot",
		"con",
		"ion",
		"inn",
		"ins",
		"its",
		"ito",
		"ibo",
		"ibm",
		
		
		
		
		
		
		"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa",
		"pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","bid","ali","pay",
		"col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump",
		"dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie",
		"noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski",
		"ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft",

		"rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and",
		
		"yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe",
	
		"six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox",
		
		"hey","saw","vim","sec","ltd","you",
		
		"tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut",
	
		"woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two",
		
		"ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"
	));
		/*
				"kiss",
				"tusk",
				"miss","dusk","musk","diss","disk","sang","ties","muss"}));*/
						
						
				//"a", "c", "b"})); //"hit", "cog", "hot", "dot", "dog", "lot", "log"}));
		
		g.getIndirectNode(UndirectedGraphNode.deserialize("0,1,2,3,11#1,0,4,5#2,0,5,6,9#3,0,9,8#4,1,10#5,1,2,10#6,2,7#7,6,9,11#8,3#9,2,3,7#10,4,5,11#11,7,10,0"));
	}
	
	//Social relationship
	public List<UndirectedGraphNode> getIndirectNode(UndirectedGraphNode node) {
		List<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
		Set<UndirectedGraphNode> accessed = new HashSet<UndirectedGraphNode>();
		Set<UndirectedGraphNode> directNodes = new HashSet<UndirectedGraphNode>();
		
		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		q.offer(node);
		accessed.add(node);
		directNodes.add(node);
		for(UndirectedGraphNode nn: node.neighbors) {
			directNodes.add(nn);
		}
		
		while(q.size() > 0) {
			int nr = q.size();
			
			for(int i=0; i<nr; i++) {
				UndirectedGraphNode n = q.poll();
				System.out.println("#A: " + n.label);
				if(!directNodes.contains(n)) nodes.add(n);
				
				for(UndirectedGraphNode nn: n.neighbors) {
					if(!accessed.contains(nn)) {
						q.offer(nn);
						accessed.add(nn);
						System.out.println("Add: " + nn.label);
					}
				}
			}
		}
		
		System.out.print("Social nodes: " + nodes);
		return nodes;
	}
	
	public List<UndirectedGraphNode> getIndirectNodeX(UndirectedGraphNode node) {
		List<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
		Set<UndirectedGraphNode> accessed = new HashSet<UndirectedGraphNode>();
		Set<UndirectedGraphNode> directNodes = new HashSet<UndirectedGraphNode>();
		
		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		q.offer(node);
		accessed.add(node);
		directNodes.add(node);
		int nr = 1;
		int level = 0;
		
		while(q.size() > 0) {
			UndirectedGraphNode n = q.poll();
			
			System.out.println("#A: " + n.label);
			if(level !=1 && !directNodes.contains(n)) nodes.add(n);
			nr--;
			
			for(UndirectedGraphNode nn: n.neighbors) {
				if(!accessed.contains(nn)) {
					q.offer(nn);
					accessed.add(nn);
					System.out.println("Add: " + nn.label);
				}
				
				if(nn.equals(node)) directNodes.add(nn);
			}
			
			if(nr == 0) {
				nr = q.size();
				level++;
			}
		}
		
		System.out.print("Social nodes: [");
		for(UndirectedGraphNode n: nodes) {
			System.out.print(" " + n.label);
		}
		System.out.println("]");
		return nodes;
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node != null)
			return node.clone();
		return null;
	}
	
	public int wordLadder(String beginWord, String endWord, String... others) {
		Set<String> dict = new HashSet<String>();
		for(String s: others) dict.add(s);
		dict.add(endWord);
		
		HashSet<String> hash = new HashSet<String>();
		

        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        hash.add(beginWord);
        
        int length = 1;
        while(!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord: getNextWords(word, dict)) {
                    if (hash.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(endWord)) {
                        return length;
                    }
                    
                    hash.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
		
		return 0;
	}
	
	private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    
    // get connections with given word.
    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
    // it will return ['hit', 'hog']
    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
	
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		wordList.add(beginWord);
		wordList.add(endWord);

		int len = wordList.size();
		String[] strs = new String[len];
		strs[0]=beginWord;
		strs[1]=endWord;

		int k=2;
		for(String s: wordList) 
			if(!(s.equals(beginWord) || s.equals(endWord))) strs[k++] = s;

		return ladderLength(strs);
	}
	public int ladderLength(String[] strs) {
		int len = strs.length;
		
		int wlen = strs[0].length();
		int[][] mapping = new int[len][len];
		for(int i=0; i<len; i++) {
			for(int j=i+1; j<len; j++) {
				String s1 = strs[i];
				String s2 = strs[j];
				
				if(s1.length() == wlen && wlen == s2.length()) {
					int c = 0;
					for(int k=0; k<wlen; k++) {
						c = c + ((s1.charAt(k) - s2.charAt(k) == 0)?1:0);
					}
					if(c == wlen-1) {
						mapping[i][j] = 1;
						mapping[j][i] = 1;
						
						//System.out.println("## " + i + " - " + j);
					}
				}
			}
		}
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		Set<Integer> s = new HashSet<Integer>();
		q.add(0);
		s.add(0);
		int w = 1;
		int level = 1;
	
		while(!q.isEmpty()) {
			int cc = q.poll().intValue();
			
			w--;
			if (mapping[cc][1] == 1 || mapping[1][cc] == 1) {
				System.out.println("=========" + s.size() + " " + strs[cc]);
				return level + 1;
			}
			
			System.out.print("----Child--" + cc + "[");
			int m = 0;
			for(int i=0; i<len; i++) {
				if(mapping[cc][i] == 1 && !s.contains(i)) {
					q.add(i);
					s.add(i);
					m++;
					System.out.print(" " + i + ":" + strs[i]);
				}
			}
			System.out.println("] " + m + " " + w + " " + q.size());
			if(w == 0) {
				level++;
				w = q.size();
				System.out.println("==33333333333333333333333333333==Level:" + level);
				
			}
		}
		System.out.println("====" + s.size());
		return 0;
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

	public UndirectedGraphNode clone() {
		UndirectedGraphNode node = this;

		Map<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		List<UndirectedGraphNode> lists = new ArrayList<UndirectedGraphNode>();
		lists.add(node);
		while(lists.size() > 0) {
			UndirectedGraphNode p = lists.remove(0);

			if(mapping.keySet().contains(p)) continue;
			UndirectedGraphNode q = new UndirectedGraphNode(p.label);

			mapping.put(p, q);
			for(UndirectedGraphNode x: p.neighbors) {
				lists.add(x);
			}
		}

		for(UndirectedGraphNode p: mapping.keySet()) {
			UndirectedGraphNode q = mapping.get(p);

			for(UndirectedGraphNode x: p.neighbors) {
				q.addNeighbors(mapping.get(x));
			}
		}

		return mapping.get(node);
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
				node.neighbors.add(mapping.get(label));
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
				sbf.append(",")
					.append(p.label);
				q.add(p);
			}
			sbf.append("#");
		}
		sbf.deleteCharAt(sbf.length()-1);	
		return sbf.toString();
	}
};
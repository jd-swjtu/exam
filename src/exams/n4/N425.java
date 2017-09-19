package exams.n4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 Given a set of words (without duplicates), find all word squares you can build from them.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.

b a l l
a r e a
l e a d
l a d y
Note:
There are at least 1 and at most 1000 words.
All words will have the exact same length.
Word length is at least 1 and at most 5.
Each word contains only lowercase English alphabet a-z.
Example 1:

Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
Example 2:

Input:
["abat","baba","atan","atal"]

Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).

 */
public class N425 {
	public List<List<String>> wordSquares(String[] words) {
        List<List<String>> results = new ArrayList<>();
        int l = words[0].length();
        Set<String> w = new HashSet<>();
        for(String s: words) w.add(s);
        
        List<String> result = this.getNext(null, 0, l, w);
        for(String s: result) {
        	List<String> tmp = new ArrayList<>();
        	tmp.add(s);
        	System.out.println(this.getNext(result, 1, l, w));
        	break;
        }

        return results;
    }
	
	private List<String> getNext(List<String> result, int i, int l, Set<String> words) {
		List<String> results = new ArrayList<>();
		if(i==0) {
			for(String s: words) results.add(s);
			return results;
		}
		
		char[] str = new char[i];
		for(int k=0; k<i; i++) {
			str[k] = result.get(k).charAt(k);
		}
		System.out.println("#1" + results);
		for(String s: words) {
			System.out.println(new String(str) + " " + s);
			if(s.startsWith(new String(str)));
			results.add(s);
		}
		System.out.println("#" + results);
		return results;
	}
	
	public static void main(String[] args) {
		new N425().wordSquares(new String[]{"abat","baba","atan","atal"});
	}

}

package exams.n0;

import java.util.ArrayList;
import java.util.List;

public class N68 {

	public static void main(String[] args) {
		System.out.println(new N68().fullJustify(new String[]{
				"This", "is", "an", "example", "of", "text", "justification."
		}, 15));
		
		System.out.println(new N68().fullJustify(new String[]{
				""
		}, 2));
		
		System.out.println(new N68().fullJustify(new String[]{
		"What","must","be","shall","be."
		},	10));
	}

	/*
	 *  Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:

[
   "This    is    an",
   "example  of text",
   "justification.  "
]

	 */

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> results = new ArrayList<String>();

		int len = words.length;
		int start = 0;
		int count = 0;
		int clen = 0;
		for(int j=0; j < len; j++) {
			if(clen + count - 1 + words[j].length() + 1 > maxWidth) {
				results.add(output(words, start, count, clen, maxWidth));
				
				start = j;
				clen=words[j].length();
				count=1;
			} else {
				clen += words[j].length();
				count++;
			}
		}
		
		results.add(output(words, start, count, clen, maxWidth));

		return results;
	}
	
	private String output(String[] words, int start, int count, int clen, int maxWidth) {
		int blanks = maxWidth - clen;
		int avg = (count==1)?blanks:(blanks / (count-1));
		int extra = (count==1)?0:(blanks - (count-1) * avg);

		StringBuffer sbf = new StringBuffer();
		sbf.append("#");
		for(int i=0; i<count; i++) {
			sbf.append(words[i + start]);
			
			if(i < count - 1) {
				for(int k=0; k<avg; k++)
					sbf.append(" ");
				if(extra > 0) {
					sbf.append(" ");
					extra--;
				}
			}
		}
		int l = maxWidth - sbf.length() + 1; //+1 because of first "#"
		while(l>0) {
			sbf.append(" ");
			l--;
		}
		sbf.append("#");
		
		return sbf.toString();
	}
}

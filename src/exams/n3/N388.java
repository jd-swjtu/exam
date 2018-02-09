package exams.n3;

import java.util.Stack;

/**
 Suppose we abstract our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system. If there is no file in the system, return 0.

Note:
The name of a file contains at least a . and an extension.
The name of a directory or sub-directory will not contain a ..
Time complexity required: O(n) where n is the size of the input string.

Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.

 
 * @author jichen
 *
 */
public class N388 {
	class Item {
		String name;
		int totalLen = 0;
		
		Item(String name, int l) {
			this.name = name;
			this.totalLen = l;
		}
		
		Item(String name) {
			this(name, 0);
		}
		
		public String toString() {
			return name + " : " + totalLen;
		}
	}
	
	public int lengthLongestPath2(String input) {
		if (input == null || input.startsWith("\n")) return 0;
		
		int max = 0;
		Stack<Integer> s = new Stack<>();
		s.push(0);
		for(String line: input.split("\n")) {
			int p = 0;

			int level = 0;
			while (line.startsWith("\t")) {
				level++;
				line = line.substring("\n".length());
			}

				while (s.size() > level+1) {
					s.pop();
				}


				p = s.peek();
			

			int len = line.length();
			int dot = line.indexOf(".");
			if (dot < len && dot >= 0) {
				// This is a file
				int xlen = len + p;
				if (xlen > max)
					max = xlen;
			} else {
				// this is a folder
				s.push(len+p);
			}
		}
		return max;
	}
	
	public int lengthLongestPath(String input) {
		if (input == null || input.startsWith("\n")) return 0;
		
		int max = 0;

		Stack<Item> s = new Stack<>();
		s.push(new Item("*", 0));
		for (String line : input.split("\n")) {
			Item p = null;

			int level = 0;
			while (line.startsWith("\t")) {
				level++;
				line = line.substring("\n".length());
			}

			//if (level != 0) {
				while (s.size() > (level + 1)) {
					s.pop();
				}
			//}

			//if (!s.isEmpty()) {
				p = s.peek();
			//}

			int len = line.length();
			int dot = line.indexOf(".");
			//TODO: need a method to judge whether it is a file or folder
			if (dot < len && dot >= 0) {
				// This is a file
				int xlen = len + ((p != null) ? (p.totalLen) : 0);
				System.out.println("File: " + line + " : " + xlen + " " + ((p != null) ? (p.toString()) : "EMPTY"));
				if (xlen > max)
					max = xlen;
			} else {
				// this is a folder
				Item x = new Item(p.name + "-" + line, len);
				if (p != null) {
					x.totalLen = p.totalLen + len;
				}
				s.push(x);
				System.out.println("Item = " + x);
			}
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new N388().lengthLongestPath("qqqqqqqqqqqqqqq.txt\ndir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
		System.out.println(new N388().lengthLongestPath2("qqqqqqqqqqqqqqq.txt\ndir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
	}

}

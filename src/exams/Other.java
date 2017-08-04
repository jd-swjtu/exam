package exams;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import exams.utils.TreeNode;

public class Other {

	public static void main(String[] args) throws Exception {


		new Other().printDiagonals2(new int[][]{
			{1,2,3,10},
			{4,5,6, 11},
			{7,8,9, 12},
			{13,14,15,16}
		});

		System.out.println(new Diamond(4));
		System.out.println(new Diamond(5));
		/*printDiamond2(4);


		System.out.println(new Other().fib3(5));
		System.out.println(isPalid("aba"));*/

		//System.out.println(new Other().fib4(1,1, 5));

		new Other().category("d1:i1, i2, i3\n"
				+ "d2: i2, i3, i4\n"
				+ "d3: i4, i5\n"
				+ "d4: i6, i7\n");

		System.out.println(new Other().isInt("+1"));
		System.out.println(new Other().isInt("+-1"));
		System.out.println(new Other().isInt("1"));
		System.out.println(new Other().isInt("-1"));
		System.out.println(new Other().isInt("+123.0"));
		System.out.println(new Other().isInt("+0.0.1"));
		System.out.println(new Other().isInt("+.0001"));
		System.out.println(new Other().isInt("+1.0000"));
		System.out.println(new Other().isInt("-1..0"));

		/*List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,2,3,4,4,5));
		//System.out.println(list);
		for(int i=0; i<100000; i++) {
			list.add(i);list.add(i);
		}
		long t1 = System.currentTimeMillis();
		new Other().delete(list);
		System.out.println(System.currentTimeMillis() - t1);
		//System.out.println(list);

		HashMap<Integer,String> map = new HashMap<Integer,String>();
		String str1 = new String("abc");
		String str2 = new String("abce");
		map.put(1,  str1);
		map.put(1,  str2);
		System.out.println(map);*/

		new Other().shitOddEven(1234);
		new Other().shitOddEvenX(1234);

		List<Integer> tmp = new ArrayList<Integer>();
		TreeNode t = TreeNode.deserialize("20,10,30,5,15,25,35,3,8,13,17,27,29,34,38");
		
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		new Other().searchSum(t, results, tmp, 30);
		System.out.println(results);
	}


	public void searchSum(TreeNode root, List<List<Integer>> results, List<Integer> tmp, int sum) {
		if(root == null) {
			return;
		}
		
		tmp.add(root.val);
		if(root.val > sum) {
			if(tmp.size() > 1) {
				int prev = tmp.remove(0);
				searchSum(root.left, null, new ArrayList<Integer>(tmp), sum + prev - root.val);
			}
		}else if(sum == root.val) {
			System.out.println(tmp);
		} else {
			searchSum(root.left, results, tmp, sum - root.val);
			searchSum(root.right, results, tmp, sum - root.val);
		}
		if(tmp.size() > 0)
			tmp.remove(tmp.size() - 1);
	}
	
	public void searchSumx(TreeNode root, List<List<Integer>> results, List<Integer> tmp, int sum) {
		if(root == null) {
			return;
		}

		tmp.add(root.val);
		if(sum == root.val) {
			if(root.left == null || root.right == null) {
				results.add(new ArrayList<Integer>(tmp));
				System.out.println("##" + tmp);
			}
		} else {
			searchSumx(root.left, results, tmp, sum - root.val);
			searchSumx(root.right, results, tmp, sum - root.val);
		}
		tmp.remove(tmp.size() - 1);
	}

	public int shitOddEven(int n) {
		int nn = 0;
		for(int i=0; i<32; i+=2) {
			nn |=  ((n & (0x1 << i)) << 1)  | ((n & ( 0x1 << (i+1))) >> 1);
		}
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(nn));
		return nn;
	}

	public int shitOddEvenX(int n) {
		System.out.println(Integer.toBinaryString(n));
		int nn = 0;
		for(int i=0; i<16; i++) {
			int x = (n&0x1)<<1 | (n&0x2)>>1;
			nn = (x << (i*2)) | nn;

			n = n >> 2;
		}
		System.out.println(Integer.toBinaryString(nn));
		return nn;
	}

	public void delete(List<Integer> list) {
		int size = list.size();
		if(size == 0) return;

		/*if(ArrayList.class.getClass().isAssignableFrom(list.getClass())) {
			int tmp = list.get(size-1);
			for(int i=size-2; i>=0; i--) {
				int cur = list.get(i);
				if(cur == tmp) {
					list.remove(i);
				}
				tmp = cur;
			}
		} else */{
			Iterator<Integer> it = list.iterator();
			int tmp = it.next();

			while(it.hasNext()) {
				int cur = it.next();

				if(cur == tmp) {
					it.remove();
				} else {
					tmp = cur;
				}
			}
		}
	}

	public void delete3(LinkedList<Integer> list) {
		int size = list.size();
		if(size == 0) return;

		int tmp = list.removeFirst();
		list.addLast(tmp);
		while(size > 1) {
			int cur = list.removeFirst();

			if(cur != tmp) {
				list.addLast(cur);
				tmp = cur;
			}
			size--;
		}
	}

	public void delete2(LinkedList<Integer> list) {
		int size = list.size();
		if(size == 0) return;

		Iterator<Integer> it = list.iterator();
		int tmp = it.next();

		while(it.hasNext()) {
			int cur = it.next();

			if(cur == tmp) {
				it.remove();
			} else {
				tmp = cur;
			}
		}
	}

	public boolean isInt(String s) {
		if(s == null) return false;
		s = s.trim();
		int flag = 0;
		if(s.startsWith("+")) {
			s = s.substring(1);
			flag = 1;
		}

		if(s.startsWith("-")) {
			if(flag == 1) return false;
			s = s.substring(1);
			flag = 1;
		}


		if(s.equals("")) return false;

		//char[] a = s.toCharArray();
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c == '.') {
				if(flag == 2) return false;
				flag = 2;
				continue;
			}

			if(!(c >= '0' && c <='9')) return false;

			//if(flag == 2 && c != '0') return false;
		}

		return true;
	}

	public static void printDiamond(int m) {
		int max = m%2==0?m-1:m;

		for(int i=0; i<(m+1)/2; i++) {
			for(int j=0; j<m; j++) {
				if(j == max/2 - i || j == max/2 + i) {
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		for(int i=m/2-1; i>=0; i--) {
			for(int j=m-1-(m%2==0?1:0); j>=0; j--) {
				if(j == max/2 - i || j == max/2 + i) {
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static void printDiamond2(int m) {
		int row = m;
		int col = m%2==0?m-1:m;
		//int[][] matrix = new int[row][col];

		for(int i=0; i<row; i++) {
			int x = i>=row/2?(row-i-1):i;
			for(int j=0; j<col; j++) {
				if(j == col/2 - x || j == col/2 + x) {
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public void printDiagonals(int[][] matrix) {
		int n = matrix.length;

		for(int i=n-1; i>=0; i--) {
			int startRow = i;
			int startCol = 0;

			for(int j=0; j<n-i; j++) {
				//System.out.print("[" + startRow + ", " + startCol + "]");
				System.out.print(matrix[startRow][startCol] + " ");
				startRow++;
				startCol++;
			}
			System.out.println();
		}

		for(int i=1; i<n; i++) {
			int startRow = 0;
			int startCol = i;

			for(int j=0; j<n-i; j++) {
				//System.out.print("[" + startRow + ", " + startCol + "]");
				System.out.print(matrix[startRow][startCol] + " ");
				startRow++;
				startCol++;
			}
			System.out.println();
		}
	}

	public void printDiagonals2(int[][] matrix) {
		int r = matrix.length;
		int c = matrix[0].length;

		for(int i=r-1; i>=0; i--) {
			int startRow = i;
			int startCol = 0;

			while(startRow < r) {
				//System.out.print("[" + startRow + ", " + startCol + "]");
				System.out.print(String.format("%02d ", matrix[startRow][startCol]));
				startRow++;
				startCol++;
			}
			System.out.println();
		}

		for(int i=1; i<c; i++) {
			int startRow = 0;
			int startCol = i;

			while(startCol < c) {
				//System.out.print("[" + startRow + ", " + startCol + "]");
				System.out.print(String.format("%02d ", matrix[startRow][startCol]));
				startRow++;
				startCol++;
			}
			System.out.println();
		}
	}

	public int fib(int n) {
		if(n == 1) return 1;
		if(n == 0) return 1;

		return fib(n-1) + fib(n-2);
	}

	public int fib2(int n) {
		if(n<0) return 0;
		if(n<2) return 1;

		int f0 = 1;
		int f1 = 1;

		for(int i=2; i<=n; i++) {
			int f2 = f0 + f1;
			f0 = f1;
			f1 = f2;
		}

		return f1;
	}

	public int fib3(int n) {
		if(n<0) return 0;
		if(n<2) return 1;

		int[] f = new int[n+1];
		f[0] = 1;
		f[1] = 1;


		for(int i=2; i<=n; i++) {
			f[i] = f[i-1] + f[i-2];
		}

		return f[n];
	}

	public int fib4(int f0, int f1, int n) {
		if(n == 0) return f0;
		if(n == 1) return f1;

		return fib4(f1, f0+f1, n-1);
	}

	public static boolean isPalid(String s) {
		if(s == null || s.equals("")) return false;
		int len = s.length();
		if(len == 1) return true;

		int start = 0;
		int end = len - 1;
		while(start < end) {
			if(s.charAt(start) != s.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}

	public void category(String str) throws Exception {
		BufferedReader br = new BufferedReader(new StringReader(str));
		String line = null;

		Map<String,Set<String>> dish = new HashMap<String,Set<String>>();
		while((line=br.readLine()) != null) {
			String[] s1 = line.trim().split(":");

			Set<String> ing = new HashSet<String>();
			for(String s: s1[1].split(",")) {
				ing.add(s.trim());
			}
			dish.put(s1[0].trim(), ing);
		}
		br.close();

		String[] keys = new String[dish.size()];
		dish.keySet().toArray(keys);

		for(int i=0; i<keys.length; i++) {
			String k1 = keys[i];
			for(int j=i+1; j<keys.length; j++) {
				String k2 = keys[j];

				//if(Sets.intersection(dish.get(k1), dish.get(k2)).size() > 0)
				if(hasInt(dish.get(k1), dish.get(k2)))
					System.out.println("(" + k1 + ", " + k2 + ")");
			}
		}
	}

	private boolean hasInt(Set<String> s1, Set<String> s2) {
		for(String ss1: s1) {
			if(s2.contains(ss1)) return true;
		}
		return false;
	}
}

class Diamond {
	private int row;
	private int col;

	public Diamond(int r) {
		row = r;
		col = (row%2==0)?row-1:row;
	}

	public int getRowCount() {
		return row;
	}

	public String getRow2(int i) {
		int space = i;
		if(i>(row/2-1)) space = row - i - 1;

		System.out.println(i + " " + space);
		StringBuffer sbf = new StringBuffer();
		for(int j=0; j<col; j++) {
			if(j == col/2 - space || j == col/2 + space) {
				sbf.append("#");
			} else {
				sbf.append(" ");
			}
		}
		return sbf.toString();
	}

	public String getRow(int r) {
		if(r>(row-1)/2) {
			r = row - 1 - r;
		}
		int spaces = col/2 - r;

		char[] rowChars = new char[col];
		for(int i=0; i<col; i++) {
			rowChars[i] = ' ';
		}
		rowChars[spaces]='#';
		rowChars[col-1-spaces]='#';

		return new String(rowChars);
	}

	public String toString() {
		StringBuffer sbf = new StringBuffer();
		for(int i=0; i<row; i++) {
			sbf.append(this.getRow(i)).append("\n");
		}
		return sbf.toString();
	}
}

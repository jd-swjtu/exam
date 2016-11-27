package exams;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets;

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
		int[][] matrix = new int[row][col];
		
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
				
				if(Sets.intersection(dish.get(k1), dish.get(k2)).size() > 0)
				//if(hasInt(dish.get(k1), dish.get(k2)))
					System.out.println("(" + k1 + ", " + k2 + ")");
			}
		}
	}
	/*
	private boolean hasInt(Set<String> s1, Set<String> s2) {
		for(String ss1: s1) {
			if(s2.contains(ss1)) return true;
		}
		return false;
	}*/
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

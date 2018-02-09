package exams.n0;

import java.util.ArrayList;
import java.util.List;

/*
 Spiral Matrix

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].


 */
public class N54 {

	public static void main(String[] args) {
		System.out.println(new N54().spiralOrder(new int[][]{
			{1},{2}
			//{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}
		}));

	}
	
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rows = matrix.length;
        if(rows == 0) return res;
        
        int cols = matrix[0].length;
        if (cols == 0) return res;
        
        int left = 0;
        int right = cols-1;
        int top = 0;
        int bottom = rows - 1;
        while(top <= bottom && left <= right) {
            for(int i=left; i<=right; i++) {
                res.add(matrix[top][i]);
            }
            
            for(int i=top+1; i<=bottom-1; i++) {
                res.add(matrix[i][right]);
            }
            if(bottom > top) {
                for(int i=right; i>=left; i--) {
                    res.add(matrix[bottom][i]);
                }
            }
            if(left<right) {
                for(int i=bottom-1; i>=top+1; i--) {
                    res.add(matrix[i][left]);
                }
            }
            top += 1;
            bottom -= 1;
            left += 1;
            right -= 1;
        }
        return res;
    }
	
public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        this.helper(matrix, 0, 0, matrix[0].length-1, matrix.length-1, results);
        return results;
    }

	void helper(int[][] matrix, int left, int top, int right, int bottom, List<Integer> results) {
		if(left > right || top > bottom) return;
		
		if(left == right) {
			for(int i=top; i<=bottom; i++)
				results.add(matrix[i][left]);
				return;
		}
		
		if(top == bottom) {
			for(int i=left; i<=right; i++)
				results.add(matrix[top][i]);
				return;
		}
		
		for(int i=left; i<=right; i++) {
			results.add(matrix[top][i]);
		}
		for(int i=top+1; i<=bottom; i++) {
			results.add(matrix[i][right]);
		}
		for(int i=right-1; i>=left; i--) {
			results.add(matrix[bottom][i]);
		}
		for(int i=bottom-1; i>=top+1; i--) {
			results.add(matrix[i][left]);
		}
		
		helper(matrix, left+1, top+1, right-1, bottom-1, results);
	}
}

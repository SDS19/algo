package leetcode;

import org.junit.Test;

/** 240. Search a 2D Matrix II
 * Constraints: 1。 All integers in each row are sorted in ascending order.
 *              2. All integers in each column are sorted in ascending order.
 */
public class Search_240 {
    /**
     * Time complexity:  O(m*n)
     * Space complexity: O(1)
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int n = row * col ;
        for (int i = 0; i < n; i++) {
            if (matrix[i/col][i%col]==target) return true;
        }
        return false;
    }
    /**
     * Time complexity:  O(m+n)
     * Space complexity: O(1)
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length-1;
        while (row<matrix.length && col>=0) {
            int num = matrix[row][col];
            if (num==target) return true;
            else if (num>target) col--;
            else row++;
        }




        return false;
    }

    @Test
    public void test(){
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix2(matrix,5));
    }
}

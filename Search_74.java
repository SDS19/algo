package leetcode;

import org.junit.Assert;
import org.junit.Test;

/** 74. Search a 2D Matrix
 * m*n Matrix m=3 n=4
 *  1,  2,  3,  4
 *  5,  6,  7,  8
 *  9,  10, 11, 12
 * Matrix[x][y] => A[x*n+y]
 * A[x] => Matrix[x/n][x%n]
 */
public class Search_74 {
    public boolean search(int[][] matrix, int target) {
        int m = matrix.length - 1, n = matrix[0].length - 1;
        int low = 0, high = m, mid;
        while (low <= high) {
            if (high==0) break;
            mid = (low + high) >> 1;
            if (matrix[mid][0] == target) return true;
            if (matrix[mid][0] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        int left = 0, right = n;
        while (left <= right) {
            if (right==0 && matrix[0][0]==target) return true;
            mid = (left + right) >> 1;
            if (matrix[high][mid] == target) return true;
            if (matrix[high][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
    /**
     * Time complexity:  O(log(m*n))
     * Space complexity: O(1)
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0) return false;
        int rows = matrix.length, cols = matrix[0].length;
        int start = 0, end = rows*cols-1;
        while (start<=end) {
            int mid = (start+end)>>1;
            int num = matrix[mid/cols][mid%cols];
            if (num==target) return true;
            else if (num<target) start=mid+1;
            else end=mid-1;
        }
        return false;
    }
    /**
     * Time complexity:  O(m+n)
     * Space complexity: O(1)
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0) return false;
        int rows = 0, cols = matrix[0].length-1;
        while (rows<matrix.length && cols>=0) {
            if (matrix[rows][cols]==target) return true;
            if (matrix[rows][cols]<target) rows++;
            else cols--;
        }
        return false;
    }

    @Test
    public void test(){
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] m = {{1}};
        Assert.assertEquals(true,searchMatrix2(matrix,1));
    }
}

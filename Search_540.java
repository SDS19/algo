package leetcode;

import org.junit.Test;

/** 540. Single Element in a Sorted Array
 * Constraints: 1<=nums.length<=100000
 * nums.length is odd number <-> even number
 */
public class Search_540 {
    /**
     * Time complexity:  O(n)
     * Space complexity: O(1)
     */
    public int single1(int[] nums) {
        int n = nums.length;
        if (n==1) return nums[0];
        for (int i = 0; i < n-2; i+=2) {
            if (nums[i]!=nums[i+1]) return nums[i];
        }
        return nums[n-1];
    }
    /**
     * Time complexity:  O(log(n))
     * Space complexity: O(1)
     */
    public int single2(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l<r) {
            int m = (l+r)>>1;
            if (m%2==0) { //even number
                if (nums[m]!=nums[m+1]) r = m;
                else l = m+1;
            } else { //odd number
                if (nums[m]==nums[m+1]) r = m;
                else l = m+1;
            }
        }
        return nums[l];
    }
    @Test
    public void test() {
        int[] arr = {1,1,2,3,3,4,4,8,8};
        int[] arr1 = {1,2,2};
        int[] arr2 = {3,3,7,7,10,11,11};
        System.out.println(single2(arr2));
    }
}

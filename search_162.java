package leetcode;

import org.junit.Test;

/** 162. Find Peak Element
 * Constraints: 1. 1<=nums.length<=1000
 *              2. nums[i]!=nums[i+1] for all valid i
 * {1,2,1,3,4,5,6}, {6,5,4,3,1,2,1}
 */
public class search_162 {
    /**
     * Time complexity:  O(n)
     * Space complexity: O(1)
     */
    public static int linearScan(int[] nums) {
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i]<nums[i+1]&&nums[i+1]>nums[i+2]) return i+1;
            if (nums[i]>nums[i+1]) return i;
        }
        return 0;
    }

    /** iterative
     * Time complexity:  O(log(n))
     * Space complexity: O(1)
     */
    public static int binarySearch(int[] nums) {
        int l = 0, r = nums.length-1, mid;
        while (l<r) {
            mid = (l+r)>>1;
            if (nums[mid]<nums[mid+1]) {
                l = mid+1;
            } else r = mid;//if r=mid-1, miss the peak when nums[mid] is the peak
        }
        return l;
    }

    /** recursive
     * Time complexity:  O(log(n))
     * Space complexity: O(1)
     */
    public int findPeakElement(int[] nums) {
        return binarySearch(nums,0, nums.length-1);
    }
    public static int binarySearch(int[] nums,int l, int r) {
        if (l==r) return l;
        int mid = (l+r)>>1;
        if (nums[mid]<nums[mid+1]) {
            return binarySearch(nums,mid+1,r);
        } else return binarySearch(nums,l,mid);
    }

    @Test
    public void test(){
        int[] arr1 = {2,1};
        int[] arr2 = {3,5,4,3,1,2,1};
        System.out.println(findPeakElement(arr2));
    }

}

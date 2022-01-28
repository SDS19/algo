package leetcode;

import org.junit.Assert;
import org.junit.Test;

/** 1095. Find in Mountain Array
 * Constraints: 3 <= arr.length() <= 10000
 * Submissions making more than 100 calls to get() will be judged Wrong Answer.
 * O(log(n)) -> log(10000) = 13~14
 */
public class Search_1095 {
    /**
     * Time complexity:  O(n)
     * Space complexity: O(1)
     */
    public static int linearSearch(int target, int[] arr) {
        /** Step 1: linear search the peak index */
        int peak = -1;
        for(int i=0;i<arr.length-1; i++){
            if(arr[i]>arr[i+1]){
                peak = i;
                break;
            }
        }
        /** Step 2: linear search before the peak index */
        for(int i=0; i<=peak; i++){
            if (arr[i]==target) {
                return i;
            }
        }
        /** Step 3: linear search after the peak index */
        for(int i=peak+1; i<arr.length; i++){
            if (arr[i]==target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * if else can save get() invoke times
     * Time complexity:  O(log(n))
     * Space complexity: O(1)
     */
    public static int binarySearch(int target, int[] arr) {
        int l = 0, r = arr.length-1, mid, peak = -1;
        /** Step 1: binary search the peak index */
        while (l<r) {
            mid = (l+r)>>1;
            if (arr[mid]<arr[mid+1]) l = peak = mid+1;
            else r=mid;
        }
        /** Step 2: binary search the target index before the peak index */
        l = 0;
        r = peak;
        while (l<=r) {
            mid = (l+r)>>1;
            if (arr[mid] < target) l = mid+1;
            else if (arr[mid] > target) r = mid-1;
            else return mid;
        }
        /** Step 3: binary search the target index before the peak index */
        l = peak;
        r = arr.length-1;
        while (l<=r) {
            mid = (l+r)>>1;
            if (arr[mid] < target) r = mid-1;
            else if (arr[mid] > target) l = mid+1;
            else return mid;
        }
        return -1;
    }

    private static int bs(int[] arr,int l,int r,int target){
        while (l<=r){
            int mid=(l+r)/2;
            if (arr[mid]==target) return mid;
            if (arr[mid]<target) l=mid+1;
            if (arr[mid]>target) r=mid-1;
        }
        return -1;
    }
    @Test
    public void arr1(){
        int[] arr = {1,2,3,4,5,3,1};
        Assert.assertEquals(2,binarySearch(3,arr));
    }
    @Test
    public void arr2(){
        int[] arr = {0,1,2,4,2,1};
        Assert.assertEquals(-1,binarySearch(3,arr));
    }
    @Test
    public void arr3(){
        int[] arr = {1,4,2};
        Assert.assertEquals(0,binarySearch(1,arr));
    }
}

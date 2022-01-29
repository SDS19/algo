package leetcode;

public class Search_278 {
    private boolean isBadVersion(int index){return true;}
    /**
     * Time complexity:  O(n)
     * Space complexity: O(1)
     */
    public int linearScan(int n){
        for (int i = 1; i < n; i++) if (isBadVersion(i)) return i;
        return n;
    }
    /**
     * Tip: To quickly prove the correctness of binary search algorithm, we just need to test an input of size 2.
     *      Check if it reduces the search space to a single element (which must be the answer).
     * Use left+(right-left)/2 to avoid overflow bug instead of (left+right)/2
     *
     * Time complexity:  O(log(n))
     * Space complexity: O(1)
     *
     */
    public int findBadVersion(int n){
        int l=1,r=n,mid;
        while (l<r) {
            mid = l+(r-l)>>1;
            if (isBadVersion(mid)) r = mid;
            else l = mid+1;
        }
        return l;
    }
}

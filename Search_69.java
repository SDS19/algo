package leetcode;

import org.junit.Test;

/** 69. Sqrt(x)
 * Constraints: 0=<x<=2(31)-1 (2(31)-1 = 2147483647)
 */
public class Search_69 {
    /** Newton's method
     * x(n+1) = x(n) - f(x(n))/f`(x(n))
     * Time complexity:  O(log(n))
     * Space complexity: O(1)
     */
    public int sqrt1(int x) {
        if (x==0) return 0;
        long r = x;
        while (r*r>x) {
            r = (r+x/r)/2;
        }
        return (int) r;
    }
    /**
     * Time complexity:  O(log(n))
     * Space complexity: O(1)
     */
    public int sqrt2(int x) {
       if (x==0) return 0;
       int l = 1, r = x;
       while (l<r) {
           int m = l+(r-l)/2;
           if ((m+1)>x/(m+1) && m<=x/m) return m;//Math.pow((m+1),2);
           else if (m>x/m) r=m;//why m*m>x != m>x/m
           else l=m+1;
       }
       return l;
    }

    /** brute force
     *  Time complexity:  O(sqrt(n))
     *  Space complexity: O(1)
     */
    public int sqrt3(int x) {
        if (x == 0) return 0;
        for (int i = 1; i <= x/i; i++) {
            if (i<=x/i && (i+1)>x/(i+1)) return i;
        }
        return -1;
    }
    @Test
    public void test() {
        double n1 = Math.sqrt(8);
        System.out.println(n1);
        double n2 = Math.pow(8,0.5);
        System.out.println(n2);
        System.out.println(sqrt3(2147395600));
    }
}

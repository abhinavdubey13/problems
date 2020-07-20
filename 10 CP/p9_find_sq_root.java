import java.util.*;

/**
 * 
 * leetcode id : 69
 * 
 * Given a non-negative integer x, compute and return the square root of x.
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 *  
 */

/**
 * 
 * Instead of using fancy Newton's method, this plain binary search approach also works.
 *
 * 
 * 
 * TC = log(n)
 * SC = 1
 * 
 */

class p9_find_sq_root {

    public static void main(String[] args) {

        int n = 25; //5
        // int n = 10; //expected : 4
        int answer = Solution.function(n);
        System.out.println(answer);
    }
}

class Solution {

    static int function(int x) {
        if (x == 0)
            return 0;

        int start = 1, end = x;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1))// Found the result
                return mid;
            else if (mid > x / mid)// Keep checking the left part
                end = mid;
            else
                start = mid + 1;// Keep checking the right part
        }
        return start;
    }

}
import java.util.*;

/**
 * leetcode id : 935  https://leetcode.com/problems/knight-dialer/
 * 
 *
 * The chess knight has a unique movement, it may move two squares vertically and one square horizontally, 
 * or two squares horizontally and one square vertically (with both forming the shape of an L).  
 *
 * 
 * 
 * Given an integer n, return how many distinct phone numbers of length n we can dial.
 * You are allowed to place the knight on any numeric cell initially and then you should perform n - 1 jumps to dial a number of length n. 
 * All jumps should be valid knight jumps.
 * As the answer may be very large, return the answer modulo 10^9 + 7.

 * ===========
 * example -1
 * ===========
 * 
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * 
 * https://leetcode.com/problems/knight-dialer/discuss/190787/How-to-solve-this-problem-explained-for-noobs!!!
 * 
 * 
 * We can think of this problem as the total number of unique paths the knight can travel making n hops because to dial distinct numbers, the path taken by the knight must be unique.
 * In this post I want to explain how I came up with a solution to this problem. 
 * This approach can be used to solve other similar problems such as Unique Paths, Minimum Path Sum etc.
 * Imagine an 8 x 8 chess board with Knight (k) sitting at some index (i, j)
 * 
 * [0] If k is at index (i, j), then in a single hop, k can move to 8 possible positions which are below.
 * [1] Conversely, you can also say that in a single hop, there are 8 possible places (a,b,c,d,e,f,g,h) from which you can move to k.
 * 
 * Consider a function paths(i, j, n) which calculates the total number of unique paths to reach index (i, j) for a given n, where n is the number of hops. 
 * From [0] or [1], we can recusively define paths(i, j, n) for all non-trivial (n > 1, that is, more than one hop) cases as follows,
 * paths(i, j, n) = 
 * paths(i - 1, j - 2, n - 1) + paths (i - 2, j - 1, n - 1) + paths (i - 2, j + 1, n - 1) + paths (i - 1, j + 2, n - 1) + 
 * paths (i + 1, j + 2, n - 1) + paths  (i + 2, j + 1, n - 1) + paths (i + 2, j - 1, n - 1) + paths (i + 1, j - 2, n - 1)
 * 
 * 
 * If we translate this to plain english, all we are saying is "the total number of unique paths to (i, j) 
 * for certain hops n is equal to the sum of total number of unique paths to each valid position from which (i, j) can be reached using n - 1 hops".
 * If you are confused why it is n - 1 hops, note that when we are at (i, j), we already made one hop and we have n - 1 hops more to take.
 * 
 * For the trivial case (n = 1, that is no hops), the problem states that this must be considered as one path. Therefore, paths(i, j, n) = 1, for n = 1.
 *  
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 */

class x9_knight_paths {

    public static void main(String[] args) {

        //expected=20
        // int jumps = 1;

        //expected=10
        int jumps = 0;

        int answer = function(jumps);

        System.out.println(answer);
    }

    static int function(int jumps) {

        //10^9 + 7
        int mod = 1000000007;

        int answer = 0;

        Map<String, Integer> dp = new HashMap<>();

        //do N hops from every i, j index (the very requirement of the problem)
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 3; col++) {
                answer = (answer + paths(row, col, jumps, dp)) % mod;
            }
        }

        return answer;

    }

    static int paths(int row, int col, int jumps_left, Map<String, Integer> dp) {

        //10^9 + 7
        int mod = 1000000007;

        // if the knight hops outside of the matrix or to * return 0 
        // as there are no unique paths from here
        if (row < 0 || row > 3 || col < 0 || col > 2 || (row == 3 && col != 1)) {
            return 0;
        }

        //trivial case
        if (jumps_left == 0) {
            return 1;
        }

        String key = row + "_" + col + "_" + jumps_left;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        //non trivial case
        int count = (paths(row - 2, col + 1, jumps_left - 1, dp) % mod)
                + (paths(row - 2, col - 1, jumps_left - 1, dp) % mod)
                + (paths(row - 1, col + 2, jumps_left - 1, dp) % mod)
                + (paths(row - 1, col - 2, jumps_left - 1, dp) % mod)
                + (paths(row + 1, col - 2, jumps_left - 1, dp) % mod)
                + (paths(row + 1, col + 2, jumps_left - 1, dp) % mod)
                + (paths(row + 2, col - 1, jumps_left - 1, dp) % mod)
                + (paths(row + 2, col + 1, jumps_left - 1, dp) % mod);

        //update dp map
        dp.put(key, count);
        return count;

    }

}

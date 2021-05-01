
import java.util.*;

/**
 *
 * leetcode id : 967
 * 
 * Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.
 * 
 *  Note that every number in the answer must not have leading zeros. For example, 01 has one leading zero and is invalid.
 * 
 * You may return the answer in any order
 * 
 * =========
 * example :
 * =========
 *
 *
 *
 */

/**
 *
 *
 * =============
 * APPROACH :
 * =============
 *
 * 
 * back tracking
 * 
 * 
 */

class x34_pacific_atlantic {

    public static void main(String[] args) {

        int n = 2;
        int k = 0;

        int[] answer = new Solution().function(n, k);

        System.out.println(answer);
    }

}

class Solution {

    public int[] function(int n, int k) {

        Set<Integer> hset = new HashSet<>();

        for (int i = 1; i <= 9; i++) {
            dfs(0, i, n, k, hset);
        }

        int[] answer = new int[hset.size()];

        Iterator<Integer> it = hset.iterator();

        int i = 0;
        while (it.hasNext()) {
            answer[i++] = it.next();
        }

        Arrays.sort(answer);
        return answer;

    }

    void dfs(int till_now, int curr, int dig_left, int k, Set<Integer> hset) {
        if (curr > 9 || curr<0) {
            return;
        }
        if (dig_left == 0) {
            hset.add(till_now);
            return;
        }
        int now = till_now * 10 + curr;
        dfs(now, curr + k, dig_left-1, k, hset);
        dfs(now, curr - k, dig_left-1, k, hset);
    }
}

import java.util.*;

/**
 * leetcode id : 368
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 * 
 * 1. Si % Sj = 0 , OR
 * 2. Sj % Si = 0.
 * 
 * If there are multiple solutions, return any subset is fine.
 * 
 *
 * 
 * ===========
 * example -1
 * ===========
 * 
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 * 
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * similar to maximum-sum suarray , after we sort the input array
 *  
 *  
 * 
 * ============
 * TC = O(n.n)
 * SC = O(n)
 * 
 * 
 * 
 */

class zz_sample {

    public static void main(String[] args) {

        // int[] arr = { 1, 2, 3 }; //expected = {1,2} or {1,3}
        // int[] arr = { 1, 2, 4, 8 }; //expected = {1,2,4,8}
        int[] arr = { 3, 4, 16, 8 }; //expected = {4,8,16}

        List<Integer> answer = function(arr);

        for (Integer i : answer) {
            System.out.print(i.intValue() + " ");
        }
        System.out.println();
    }

    static List<Integer> function(int[] arr) {

        if (arr.length == 0) {
            return new ArrayList<>();
        }

        if (arr.length == 1) {
            List<Integer> a = new ArrayList<>();
            a.add(arr[0]);
            return a;
        }

        if (arr.length == 2) {
            List<Integer> a = new ArrayList<>();
            Arrays.sort(arr);
            a.add(arr[0]);
            if (arr[1] % arr[0] == 0) {
                a.add(arr[1]);
            }
            return a;
        }

        Arrays.sort(arr);
        int n = arr.length;
        int[][] dp = new int[2][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
            dp[1][i] = i;
        }

        for (int i = 1; i < n; i++) {
            int a = arr[i];

            for (int j = 0; j < i; j++) {
                int b = arr[j];
                int remainder = a % b;
                if (remainder == 0) {
                    boolean isUpdateRequired = dp[0][i] < (1 + dp[0][j]);
                    if (isUpdateRequired) {
                        dp[0][i] = 1 + dp[0][j];
                        dp[1][i] = j;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        int max_idx = 0;

        for (int i = 0; i < n; i++) {
            max_idx = (dp[0][i] > dp[0][max_idx]) ? i : max_idx;
        }

        int i = max_idx;
        int j = dp[1][max_idx];

        while (i != j) {
            ans.add(arr[i]);
            i = j;
            j = dp[1][j];
        }

        ans.add(arr[i]);

        return ans;

    }

}

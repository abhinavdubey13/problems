import java.util.*;

/**
 * leetcode id : 1395
 * 
 * There are n soldiers standing in a line. Each soldier is assigned a unique rating value.
 * 
 * You have to form a team of 3 soldiers amongst them under the following rules:
 * 
 * Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
 * 
 * A team is valid if:  (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
 * 
 * Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).
 *  
 * ===========
 * example -1
 * ===========
 * Input: rating = [2,5,3,4,1]
 * Output: 3
 * Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1). 
 * 
 * 
 * Input: rating = [2,1,3]
 * Output: 0
 * Explanation: We can't form any team given the conditions
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 * 
 * BruteForce, check all possibilities.
 * 
 * ============
 * TC = O(n^3)
 * SC = O(1)
 * 
 * 
 * ============
 * approach : 2
 * ============
 * 
 * for each i'th index , find 4 values , and store in 2 auxillaray arrays : less[2] nd more[2]
 * 
 * 1. number of soldiers having less rating on LHS of i => less[0]
 * 2. number of soldiers having less rating on RHS of i => less[1]
 * 
 * 3. number of soldiers having more rating on LHS of i => more[0]
 * 4. number of soldiers having more rating on RHS of i => more[1]
 * 
 * 
 * ============
 * TC = O(n^2)
 * SC = O(1)
 * 
 * 
 * 
 */

class x31_soldier_pairing {

    public static void main(String[] args) {

        int[] arr = { 2, 5, 3, 4, 1 };
        // int[] arr = { 2,1,3 };

        // int answer = function_brute_force(arr);

        int answer = function_optimal(arr);

        System.out.println(answer);
        // for (int i = 0; i < len; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();
    }

    static int function_optimal(int[] arr) {

        int n = arr.length;

        if (n < 3) {
            return 0;
        }

        if (n == 3) {
            return ((arr[0] < arr[1] && arr[1] < arr[2]) || (arr[0] > arr[1] && arr[1] > arr[2])) ? 1 : 0;
        }

        int[] less = new int[2];
        int[] more = new int[2];

        int count = 0;

        for (int i = 1; i <= n - 2; i++) {

            less[0] = less[1] = more[0] = more[1] = 0;

            for (int j = 0; j < n; j++) {

                //0 index is for LHS and 1 is for RHS
                less[0] += (j < i && arr[j] < arr[i]) ? 1 : 0;
                less[1] += (j > i && arr[j] < arr[i]) ? 1 : 0;
                more[0] += (j < i && arr[j] > arr[i]) ? 1 : 0;
                more[1] += (j > i && arr[j] > arr[i]) ? 1 : 0;
            }

            count = count + (less[0] * more[1] + less[1] * more[0]);

        }

        return count;

    }

    static int function_brute_force(int[] arr) {

        int n = arr.length;

        if (n < 3) {
            return 0;
        }

        if (n == 3) {
            return ((arr[0] < arr[1] && arr[1] < arr[2]) || (arr[0] > arr[1] && arr[1] > arr[2])) ? 1 : 0;
        }

        int count = 0;

        for (int i = 0; i <= n - 3; i++) {
            for (int j = i + 1; j <= n - 2; j++) {
                for (int k = j + 1; k <= n - 1; k++) {
                    count += ((arr[i] < arr[j] && arr[j] < arr[k]) || (arr[i] > arr[j] && arr[j] > arr[k])) ? 1 : 0;
                }
            }
        }
        return count;
    }

}

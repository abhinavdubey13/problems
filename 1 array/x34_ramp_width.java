import java.util.*;

/**
 * leetcode id : 962
 * 
 * find maximum of (j-i) , such that :
 * 1. i < j
 * 2. arr[i] <= arr[j]
 * 
 * 
 * If not possible , return 0.
 * 
 * ===========
 * example -1
 * ===========
 * 
 * Input: [6,0,8,2,1,5]
 * Output: 4
 * 
 * Explanation: The maximum (j-1) = (5-1)
 * arr[1] = 0 and arr[5] = 5.
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
 *
 * The idea is that for a tuple (i, j) such that j > i and arr[i] <= arr[j], 
 * if we can find an element arr[k] on the right of arr[j] (in other words k > j) such that arr[k] >= arr[i], 
 * we can then consider the tuple (i, k) since it increases our width.
 * 
 * Similarily for arr[i], if we can find an element arr[k] on the left of arr[i] (k < i) such arr[k] <= arr[j], 
 * we can then consider the tuple (k, j) 
 * since it increases our width
 *  
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 */

class x34_ramp_width {

    public static void main(String[] args) {

        int[] arr = { 6, 0, 8, 2, 1, 5 };

        int answer = function(arr);

        System.out.println(answer);

    }

    static int function(int[] arr) {
        int n = arr.length;

        int[] rMax = new int[n];
        rMax[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], arr[i]);
        }

        int i = 0, j = 0;
        int ans = 0;

        while (i < n && j < n) {

            if (arr[i] <= rMax[j]) {
                ans = Math.max(ans, j - 1);
                j++; // there can be more elements on right satisfying the constraint arr[i]<=arr[j], thus move j to right
            } else {
                i++; // all elements on left of arr[i] are bigger, thus move i to right
            }

        }

        return ans;

    }

}

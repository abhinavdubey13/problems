
import java.util.*;

/**
 * Given an array of integers. 
 * 
 * A subsequence is called Bitonic if it is first increasing then decreasing.
 * 
 * find SUM of such sub-seq , such that SUM is maximum
 * 
 * =========
 * example :
 * =========
 * arr = { 2, 3, 4, 3 , 5, 1 }
 * 
 * bitonic-seq = 2,3,4,5,1
 * sum = 15
 * 
 *   
 * 
 * 
 */

/**
 * dp-array = 1D (2 such arrays needed)
 * array-filling => i= from 1 to n  &&  for each i : j = fom 0  to i-1
 * 
 * concept => using longest increasing subseq 2 times :
 * 
 * 1st time => considering A[0......n-1] 
 * 2nd time => considering A[n-1...---0]  ie. reversed array
 * 
 * ================================
 * TC = O(n^2)
 * SC = O(n)
 *  
 * 
 */

class p18_maxSumBitonicSeq {

    public static void main(String[] args) {
        // int[] arr = { 1, 15, 51, 45, 33, 100, 12, 18, 9 }; 
        int[] arr = { 2, 3, 4, 3, 5, 1 };

        int answer = calulator(arr);
        System.out.println(answer);
    }

    static int calulator(int[] arr) {
        int[] max_sum_subseq_front = new int[arr.length];
        int[] max_sum_subseq_rear = new int[arr.length];

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            max_sum_subseq_front[i] = arr[i];
            max_sum_subseq_rear[i] = arr[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                boolean condition1 = (arr[i] > arr[j]) ? true : false;
                boolean condition2 = (max_sum_subseq_front[j] + arr[i] > max_sum_subseq_front[i]) ? true : false;

                if (condition1 && condition2) {
                    max_sum_subseq_front[i] = max_sum_subseq_front[j] + arr[i];
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                boolean condition1 = (arr[i] > arr[j]) ? true : false;
                boolean condition2 = (max_sum_subseq_rear[j] + arr[i] > max_sum_subseq_rear[i]) ? true : false;
                if (condition1 && condition2) {
                    max_sum_subseq_rear[i] = max_sum_subseq_rear[j] + arr[i];
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int val = max_sum_subseq_front[i] + max_sum_subseq_rear[i] - arr[i]; //arr[i] is counted twice , so subtract it once 
            max = Math.max(val, max);
        }

        return max;

    }
}
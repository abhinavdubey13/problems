
//Given an array of integers. A subsequence is called Bitonic if it is first increasing then decreasing.
//find SUM of such sub-seq , such that SUM is maximum

/**
 *  dp-array = 1D (2 such arrays needed)
 * array-filling => i= from 1 to n  &&  for each i : j = fom 0  to i-1
 * 
 * concept => using longest increasing subseq 2 times 
 * 1st time => considering A[0...n-1] 
 * 2nd time => considering A[n-1...0]
 *  
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;

class p18_maxSumBitonicSeq {

    public static void main(String[] args) {
        // int[] arr = { 1, 15, 51, 45, 33, 100, 12, 18, 9 }; 
        int[] arr = { 2, 3, 4, 5, 1 };

        int answer = calulator(arr);
        System.out.println(answer);
    }

    static int calulator(int[] arr) {
        int[] maxSumSubseqFront = new int[arr.length];
        int[] maxSumSubseqRear = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            maxSumSubseqFront[i] = arr[i];
            maxSumSubseqRear[i] = arr[i];
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                boolean condition1 = (arr[i] > arr[j]) ? true : false;
                boolean condition2 = (maxSumSubseqFront[j] + arr[i] > maxSumSubseqFront[i]) ? true : false;
                if (condition1 && condition2) {
                    maxSumSubseqFront[i] = maxSumSubseqFront[j] + arr[i];
                }
            }
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = arr.length - 1; j > i; j--) {
                boolean condition1 = (arr[i] > arr[j]) ? true : false;
                boolean condition2 = (maxSumSubseqRear[j] + arr[i] > maxSumSubseqRear[i]) ? true : false;
                if (condition1 && condition2) {
                    maxSumSubseqRear[i] = maxSumSubseqRear[j] + arr[i];
                }
            }
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int val = maxSumSubseqFront[i] + maxSumSubseqRear[i] - arr[i];
            max = Math.max(val, max);
        }

        return max;

    }
}
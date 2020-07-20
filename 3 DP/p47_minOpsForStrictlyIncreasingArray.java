
/**
 * 
 * Problem : https://www.geeksforgeeks.org/convert-to-strictly-increasing-integer-array-with-minimum-changes/
 * 
 * 
 * given an array of n integers. Write a program to find minimum number of changes in array so that array is strictly increasing of integers.
 * In strictly increasing array A[i] < A[i+1] for 0 <= i < n
 *
 * 
 */

/**
 * ==========
 * APPROACH :
 * ==========
 * 
 * variation of LI Sub-seq problem
 * 
 * dp-array = 1D 
 * 
 * answer = #elements - ( LIS in which diff of elements > diff of indices) 
 *
 * 
 *
 * 
 */

public class p47_minOpsForStrictlyIncreasingArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 6, 5, 4 };
        int answer = calculator(arr);
        System.out.println(answer);
    }

    static int calculator(int arr[]) {
        int table[] = new int[arr.length];
        int maxLis = 0;

        for (int i = 0; i < arr.length; i++) {
            table[i] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && i - j <= arr[i] - arr[j]) {

                    table[i] = Math.max(table[i], 1 + table[j]);

                    maxLis = Math.max(table[i], maxLis);
                }
            }
        }

        return arr.length - maxLis;
    }

}
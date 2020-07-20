
/**
 * 
 * Given an array of sorted numbers having no duplicates ,  write a program to find the length of the Longest Arithmetic Progression (LLAP) in it.
 *
 * ============
 * Example : 1
 * ============
 * Arr[]= {1 , 7 , 10 , 13 , 14 , 19}
 * 
 * output = 4 
 * 
 * AP = 1,7,13,19
 * common-diff = 6
 * 
 * 
 * ============
 * Example : 2
 * ============
 * Arr[] = {2 , 4 , 6 , 8 , 10}
 * 
 * output = 5
 * common-diff = 2
 * 
 */

/**
 * ==========
 * APPROACH :
 * ==========
 * 
 * similar to longest-increasing-subseq 
 * 
 * but another condition is to be checked , ie. diff between 2 consecutive must be same
 * 
 * table_len[i] = LLAP ending with arr[i]
 * table_common_diff[i] = common differnce for calulating  LLAP ending with arr[i]
 * 
 * 
 * ========================
 * let input array size = n
 * tc = O(n^2)
 * sc = O(n)
 *
 * 
 */

public class p44_longestAP {
    public static void main(String[] args) {

        // int[] arr = { 1, 7, 10, 13, 14, 19 };
        // int[] arr = { 2, 4, 6, 8, 10, 12 };
        int[] arr = { 1, 3, 5, 12 };

        int answer = calculator(arr);
        System.out.println(answer);
    }

    static int calculator(int[] arr) {

        int[] table_len = new int[arr.length];
        int[] table_common_diff = new int[arr.length];

        //init the dp tables
        for (int i = 0; i < arr.length; i++) {
            table_len[i] = (i == 0) ? 1 : 2;
            table_common_diff[i] = arr[i] - arr[0];
        }

        //core logic
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {

                boolean isThisAnAP = (j == 0 || arr[j] + table_common_diff[j] == arr[i]) ? true : false;
                if (isThisAnAP) {
                    table_len[i] = Math.max(table_len[i], 1 + table_len[j]);
                    table_common_diff[i] = (j == 0) ? arr[i] - arr[0] : table_common_diff[j];
                }
            }
        }

        //find max from table
        int maxLen = 0;
        for (int i = 0; i < table_len.length; i++) {
            maxLen = Math.max(maxLen, table_len[i]);
        }
        return maxLen;
    }

}
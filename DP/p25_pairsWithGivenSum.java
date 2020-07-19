// Given an array of integers A[] and a number k . You can pair two number of array if difference between them is strictly less than k. 
// find maximum possible sum of all such disjoint pairs

//example A[]= { 3, 5, 10, 15, 17, 12, 9 } and diff = 4
//possible pairs = {3,5} , {9,12} , {12,15} , {9,10} , {10,12} , {15,17}
//dis-joint pairs from the above are : (1.) {3,5} , {9,10} : but sum here (3+5+9+10 = 27) is NOT MAXIMUM 

/**
 * dp = not required , it is more of a greedy approach
 * sort A[] and then {3,5,9,10,12,15,17}
 * 
 * start scanning from behind ,
 * if last 2 element's diff < K : include both and reduce size by 2
 * else : dont include last , decrease size by 1 
 * 
 * 
 */

import java.util.Arrays;

class p25_pairsWithGivenSum {

    public static void main(String[] args) {
        int[] arr = { 3, 5, 10, 15, 17, 12, 9 };
        int diff = 4;
        int answer = calulator(arr, diff);
        System.out.println(answer);
    }

    static int calulator(int[] arr, int diff) {
        Arrays.sort(arr);
        int ans = 0;
        for (int i = arr.length - 1; i > 0;) {

            if (arr[i] - arr[i - 1] < diff) {
                ans = ans + arr[i] + arr[i - 1];
                i -= 2;
            } else {
                i--;
            }

        }

        return ans;
    }
}
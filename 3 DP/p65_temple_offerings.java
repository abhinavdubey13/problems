import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/temple-offerings/
 * 
 * Consider a devotee wishing to give offerings to temples along a mountain range. 
 * 
 * The temples are located in a row at different heights. 
 * 
 * Each temple should receive at least one offering. 
 * 
 * If two adjacent temples are at different altitudes, then the temple that is higher up should receive more offerings than the one that is lower down. 
 * 
 * If two adjacent temples are at the same height, then their offerings relative to each other does not matter. 
 * 
 * Given the number of temples and the heights of the temples in order, find the minimum number of offerings to bring. 
 * 
 * =========
 * example:
 * =========
 *
 * 
 * Input  : 1 2 2
 * Output : 4
 * All temples must receive at-least one offering. Now, the second temple is at a higher altitude compared to the first one. 
 * Thus it receives one extra offering.  The second temple and third temple are at the  same height, so we do not need to modify the offerings. 
 * Offerings given are therefore: 1, 2,1 giving a total of 4.
 * 
 * Input  : 1 4 3 6 2 1
 * Output : 10
 * We can distribute the offerings in the followingway, 1, 2, 1, 3, 2, 1. 
 * The second temple has to receive more offerings than the first due to its height being higher. 
 * The fourth must receive more than the fifth, which in turn must receive more than the sixth. 
 * Thus the total becomes 10.
 *
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
 *  We notice that each temple can either be above, below, or at the same level as the temple next to it. 
 * 
 * The offerings required at each temple is equal to the maximum length of the chain of temples at lower height as shown in the image. 
 * 
 * find the number of contiguous elements lower than the current elements on both sides
 *
 *
 * ===========
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 * 
 */

public class p65_temple_offerings {

    public static void main(String[] args) {

        int[] arr = { 1, 4, 3, 6, 2, 1 };//expected =10

        // int[] arr = { 1, 2, 2 };//expected = 4

        int answer = function(arr);
        System.out.println("answer : " + answer);
    }

    static int function(int[] arr) {

        int n = arr.length;

        if (n < 2) {
            return n;
        }

        int[] dp_left = new int[n];
        int[] dp_right = new int[n];

        int[] offerings = new int[n];

        for (int i = 1; i < n; i++) {
            boolean is_prev_lesser = (arr[i - 1] < arr[i]) ? true : false;
            dp_left[i] = (is_prev_lesser) ? dp_left[i - 1] + 1 : 0;
        }

        for (int i = n - 2; i >= 0; i--) {
            boolean is_next_lesser = (arr[i + 1] < arr[i]) ? true : false;
            dp_right[i] = (is_next_lesser) ? dp_right[i + 1] + 1 : 0;
        }

        for (int i = 0; i < n; i++) {
            offerings[i] = 1 + Math.max(dp_left[i], dp_right[i]);
        }


        int answer = 0;
        for(int i:offerings){
            answer+=i;
        }

        return answer;

    }

}
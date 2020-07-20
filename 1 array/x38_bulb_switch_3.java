import java.util.*;

/**
 * leetcode id : 1375
 * 
 * There is a room with n bulbs, numbered from 1 to n, arranged in a row from left to right. Initially, all the bulbs are turned off.
 * 
 * At moment k (for k from 0 to n - 1), we turn on the light[k] bulb. 
 * 
 * A bulb change color to blue only if it is on and all the previous bulbs (to the left) are turned on too.
 * 
 * Return the number of moments in which all turned on bulbs are blue. * 
 *
 * 
 * ===========
 * example -1
 * ===========
 * Input: light = [2,1,3,5,4]
 * 
 * Output: 3
 * 
 * Explanation: All bulbs turned on, are blue at the moment i=1, i=2 and i=4 (i is zero based index in input array)
 * 
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 2
 * ============
 * 
 * keep track of max_lit_bulb and number_of_lit_bulbs
 * 
 * when equal , increment counter
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class x38_bulb_switch_3 {

    public static void main(String[] args) {

        // int[] arr = { 2, 1, 3, 5, 4 }; //expected = 3
        int[] arr = { 4, 1, 2, 3 }; //expected =1

        int answer = function(arr);

        System.out.println(answer);

    }

    static int function(int[] arr) {

        int instances = 0;
        int number_of_lit_bulbs = 0;

        int max_lit_bulb = 0;

        for (int i = 0; i < arr.length; i++) {

            number_of_lit_bulbs++;
            max_lit_bulb = Math.max(max_lit_bulb, arr[i]);

            if (max_lit_bulb == number_of_lit_bulbs) {
                instances++;
            }

        }

        return instances;

    }

}

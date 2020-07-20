import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/maximum-difference-zeros-ones-binary-string-set-2-time/
 * 
 * Given a binary string of 0s and 1s. 
 * 
 * The task is to find the maximum difference between the number of 0s and number of 1s in any sub-string of the given binary string. 
 * 
 * That is maximize ( number of 0s – number of 1s ) for any sub-string in the given binary string.
 * 
 * =========
 * example:
 * =========
 *
 * Input : S = "11000010001"
 * Output : 6
 * From index 2 to index 9, there are 7 0s and 1 1s, so number of 0s - number of 1s is 6
 * 
 * Input : S = "1111"
 * Output : -1
 *
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 *  using kadane algorithm
 * 
 * https://www.youtube.com/watch?v=_k_Codwq1ls&ab_channel=Pepcoding
 * 
 * consider 
 * 1 as -1
 * and
 * 0 as +1
 * 
 * then apply kadane's algorithm
 * 
 * ===========
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 * 
 */

public class p58_max_diff_in_number_of_0s_and_1s_in_binary_string {

    public static void main(String[] args) {
        //expected = 6
        // String str = "11000010001";

        //expected = -1
        String str = "1111";

        int answer = function(str);
        System.out.println(answer);
    }

    static int function(String str) {

        int answer = 0;
        int curr = 0;

        int n = str.length();

        for (int i = 0; i < n; i++) {

            int modified_val = 1;
            if (str.charAt(i) == '1') {
                modified_val = -1;
            }

            curr = Math.max(modified_val, curr + modified_val);
            answer = Math.max(answer, curr);
        }


        //if answer = 0 : imples no 0 is there in input
        //return -1 in that case
        return (answer == 0) ? -1 : answer;

    }

}
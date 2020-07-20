import java.util.*;

/**
 * 
 * leetcode id :
 * 
 * 
 * convert : aaabbbccc to a3b3c3
 * 
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 * 
 * 1 for loop
 * 
 *
 * 
 * 
 * ============
 * TC : O(n)
 * SC : O(1)
 * 
 *  
 */

class p21_running_encoding {

    public static void main(String[] args) {

        // String input = "abcdef";

        // String input = "a";

        // String input = "abccccz";


        String input = "aaa";

        String answer = Solution.function(input);
        System.out.println(answer);

    }

}

class Solution {

    static String function(String input) {

        StringBuffer answer = new StringBuffer();
        int n = input.length();

        // answer.append(input.charAt(0));

        int count = 1;

        for (int i = 1; i < n; i++) {
            char curr = input.charAt(i);
            char prev = input.charAt(i - 1);

            if (curr == prev) {
                count++;
            } else {
                answer.append(prev);
                answer.append(count);
                count = 1;
            }
        }

        answer.append(input.charAt(n - 1));
        answer.append(count);

        return answer.toString();
    }

}

import java.util.*;

/**
 * 
 * leetcode id : 73
 * 

 * 
 *  
 */

/**
 * 
 * 
 * 
 * 
 * 
 * TC = r.c
 * SC = 1
 * 
 */

class p24_atoi {

    public static void main(String[] args) {
        String s = "  -42";
        // String s = "words and 987";
        // String s = "4193 with words";
        // String s = "-91283472332";
        // String s = "42.90  34";
        // String s = "42";
        // String s = "+-12";

        int answer = Solution.function(s);
        System.out.println(answer);
        // System.out.println();
    }

}

class Solution {

    static int function(String input) {
        boolean is_negative = false;
        boolean started = false;

        int answer = 0;
        int start_idx = -1;
        // int first = -1;

        int n = input.length();

        for (int i = 0; i < n; i++) {

            char curr = input.charAt(i);
            char nxt = (i + 1 < n) ? input.charAt(i + 1) : '@';

            if (curr == '.' || is_char(curr)) {
                if (!started) {
                    return 0;
                } else {
                    break;
                }
            } else if (curr == ' ' || curr == '+') {

                if ( curr == '+' && nxt == '-') {
                    return 0;
                }
                if (started) {
                    break;
                } else {
                    continue;
                }
            } else if (curr == '-') {
                if (nxt == '+') {
                    return 0;
                }
                if (started) {
                    break;
                } else {
                    is_negative = true;
                }
            }

            else if (curr - '0' >= 0 && curr - '0' <= 9) {
                if (!started) {
                    start_idx = i;
                    started = true;
                }

                int digit = curr - '0';

                if (Integer.MAX_VALUE / 10 < answer
                        || Integer.MAX_VALUE / 10 == answer && Integer.MAX_VALUE % 10 < digit)
                    return is_negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

                answer = answer * 10 + digit;

            }
        }

        if (is_negative) {
            answer = -1 * answer;
        }

        return answer;

    }

    static boolean is_char(char curr) {
        return (curr - 'a' >= 0 && curr - 'a' < 26 || curr - 'A' >= 0 && curr - 'A' < 26);
    }

}

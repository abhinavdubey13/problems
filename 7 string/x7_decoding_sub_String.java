import java.util.*;

/**
 * 
 * 
 * leetcode id : 394
 * 
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], 
 * 
 * where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. 
 * 
 * For example, there won't be input like 3a or 2[4].
 * 
 * 
 * Example 1:
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * 
 * 
 * Example 2:
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * 
 */

/**
 * =============
 * APPROACH : 
 * =============
 * 
 * stack + DFS
 *  
 * 
 * 
 */

public class x7_decoding_sub_String {

    public static void main(String[] args) {

        // String input = "3[a]2[bc]"; //aaabcbc

        // String input = "3[2[c]]"; //6 times c

        String input = "2[abc]3[cd]ef"; //6 times c
        String expected = "abcabccdcdcdef";

        // String input = "10[a]"; //6 times c

        Solution solution = new Solution();

        String answer = solution.function(input);

        System.out.println(answer);

        System.out.println(answer.equals(expected));

    }

}

class Stk_helper {

    String element;
    boolean is_num;

    Stk_helper(String e, boolean b) {
        element = e;
        is_num = b;
    }

    Stk_helper(char c, boolean b) {
        element = String.valueOf(c);
        is_num = b;
    }

}

class Solution {

    String output;

    String function(String input) {
        input = "1[" + input + "]"; //at last we need to do some operation so we do this step : input = 1[input]
        output = "";
        Stack<Stk_helper> stk = new Stack<>();
        dfs(0, input, input.length(), stk);
        return output;
    }

    void dfs(int idx, String input, int n, Stack<Stk_helper> stk) {

        if (idx >= n) {
            //do final step
            set_final_output(stk);
            return;
        } else {

            char curr = input.charAt(idx);
            boolean is_digit = is_digit(curr);
            boolean is_alphabet = ((curr >= 'a') && (curr <= 'z'));
            boolean is_closing_brace = (curr == ']');

            //if we find a digit , we find the int value , ie number of times to be replicated
            if (is_digit) {
                int num = 0;
                while (input.charAt(idx) != '[') {
                    num = num * 10 + input.charAt(idx) - '0';
                    idx++;
                }
                stk.push(new Stk_helper(String.valueOf(num), true));
                dfs(idx + 1, input, n, stk);
            }

            else if (is_alphabet) {
                stk.push(new Stk_helper(String.valueOf(curr), false));
                dfs(idx + 1, input, n, stk);
            }

            //at closing brace , we replicate stack values
            else if (is_closing_brace) {
                update_stk(stk);
                dfs(idx + 1, input, n, stk);
            }

        }

    }

    void set_final_output(Stack<Stk_helper> stk) {
        while (stk.size() > 0) {
            output = stk.pop().element + output;
        }
    }

    void update_stk(Stack<Stk_helper> stk) {

        String new_str = "";
        String temp = "";
        while (!stk.peek().is_num) {
            String popped = stk.pop().element;
            temp = popped + temp;
        }

        int times = Integer.parseInt(stk.pop().element);

        while (times > 0) {
            times--;
            new_str += temp;
        }

        for (int i = 0; i < new_str.length(); i++) {
            stk.push(new Stk_helper(new_str.charAt(i), false));
        }

    }

    boolean is_digit(char c) {
        return ((c - '0' >= '0' - '0') && (c - '0' <= '9' - '0'));
    }

}

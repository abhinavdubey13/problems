import java.util.*;

import sun.net.www.content.audio.basic;

/**
 * 
 * check if a given VALID expression has redundant brackets
 * 
 * 
 * ========
 * example
 * ========
 * 
 * ((a+b)+ (c+d))  : false, the content btwn each pair of braces is unique
 * 
 * (a+b) + ((c+d)) : true , the content btwn last 2 pairs of braces is same ie c+d
 * 
 * 
 * 
 */

/**
 * 
 * using stack
 * 
 * 
 * push if we see : operator , operand , (
 * 
 * if we see ) , the we start popping, untill we see (
 * if the 1st item on poppingis (  , it means this is a redundatn bracket
 * 
 * https://www.youtube.com/watch?v=aMPXhEdpXFA&ab_channel=Pepcoding
 * 
 * 
 * ============
 * TC = n
 * SC = n
 * 
 * 
 */

class x58_check_redundant_braces {

    public static void main(String[] args) {

        String exp = "((a+b)+(c+d))";//false
        // String exp = "(a+b)+((c+d))"; //true

        try {
            boolean answer = Solution.function(exp);
            System.out.println(answer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}

class Solution {

    static boolean function(String expression) throws Exception {

        int n = expression.length();

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < n; i++) {

            char curr = expression.charAt(i);

            if (curr == ' ') {
                continue;
            }

            //operator / operand / (
            else if (is_operand(curr) || is_operator(curr) || curr == '(') {
                stk.push(curr);
            }

            //closing brace
            else if (curr == ')') {

                int pop_count = 0;
                while (stk.size() > 0 && stk.peek() != '(') {
                    pop_count++;
                    stk.pop();
                }

                stk.pop(); //remove ( at last

                //if 1st item to be popped is ( , then its a redundant bracket
                if (pop_count == 0) {
                    return true;
                }
            }

        }

        return false;

    }

    static boolean is_operand(char x) {
        if (x >= '0' && x <= '9' || x >= 'a' && x <= 'z' || x >= 'A' && x <= 'Z') {
            return true;
        }
        return false;
    }

    static boolean is_operator(char x) {
        if (x == '^' || x == '+' || x == '-' || x == '*' || x == '/') {
            return true;
        }
        return false;
    }
}

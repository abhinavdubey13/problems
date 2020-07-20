import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/postfix-to-infix/
 * 
 * convert postfix to infix expression 
 * 
 * 
 * 
 */

/**
 * 
 * using stack ,
 * 
 * similar to evaluating postfix expression , but here we add string to the stack
 * 
 * 
 * 
 * ============
 * TC = n
 * SC = n
 * 
 * 
 */

class x57_postfix_to_infix {

    public static void main(String[] args) {

        // String exp = "abc++";
        String exp = "ab*c+";
        // String exp = "(a+b)*c";

        try {
            String answer = Solution.function(exp);
            System.out.println(answer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}

class Solution {

    static String function(String expression) throws Exception {

        int n = expression.length();

        Stack<String> stk = new Stack<>();

        for (int i = 0; i < n; i++) {

            char curr = expression.charAt(i);

            if (curr == ' ') {
                continue;
            }

            //digit
            else if (is_operand(curr)) {
                stk.push(String.valueOf(curr));
            }

            //operator
            else if (is_operator(curr)) {
                if (stk.size() < 2) {
                    throw new Exception("invalid input");
                }

                String b = stk.pop();
                String a = stk.pop();
                stk.push("(" + a + curr + b + ")");
            }

        }

        while (stk.size() > 1) {
            throw new Exception("invalid input");
        }

        return stk.peek();

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

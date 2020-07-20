import java.util.*;

/**
 * 
 * leetcode id : 150
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 *
 */

/**
 * 
 * 
 * using stack
 * 
 */

class p37_evaluate_reverse_polish_notation {

    public static void main(String[] args) {

        // String[] arr = { "2", "1", "+", "3", "*" };
        String[] arr = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        int answer = Solution.function(arr);
        System.out.println(answer);

    }
}

class Solution {

    static int function(String[] arr) {

        Stack<String> stk = new Stack<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            String curr = arr[i];

            if (is_operator(curr)) {
                String op2 = stk.pop();
                String op1 = stk.pop();

                int x = Integer.parseInt(op1);
                int y = Integer.parseInt(op2);
                int z = 0;

                if (curr.equals("*")) {
                    z = x * y;
                } else if (curr.equals("+")) {
                    z = x + y;
                } else if (curr.equals("-")) {
                    z = x - y;
                } else if (curr.equals("/")) {
                    z = x / y;
                }

                stk.push(String.valueOf(z));

            } else {
                stk.push(curr);
            }
        }

        while (stk.size() > 1) {

            String operator = stk.pop();

            String op2 = stk.pop();
            String op1 = stk.pop();

            int x = Integer.parseInt(op1);
            int y = Integer.parseInt(op2);
            int z = 0;

            if (operator.equals("*")) {
                z = x * y;
            } else if (operator.equals("+")) {
                z = x + y;
            } else if (operator.equals("-")) {
                z = x - y;
            } else if (operator.equals("/")) {
                z = x / y;
            }

            stk.push(String.valueOf(z));

        }

        int ans = Integer.parseInt(stk.pop());
        return ans;
    }

    static boolean is_operator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

}
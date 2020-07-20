import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
 * 
 * evaluation of postfix expression
 *
 * 
 */

/**
 * 
 * using stack
 * 
 * push digits 
 * 
 * on encountering an operator , pop last 2 operands from stack and push the resultant into stack
 * 
 * at last there should be 1 entry in stack
 *
 * ============
 * TC = n
 * SC = n
 * 
 * 
 */

class x55_evaluate_postfix_expression {

    public static void main(String[] args) {

        String exp = "231*+9-";

        try {
            int answer = Solution.function(exp);
            System.out.println(answer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}

class Solution {

    static int function(String expression) throws Exception {

        int n = expression.length();

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < n; i++) {

            char curr = expression.charAt(i);

            if (curr == ' ') {
                continue;
            }

            //digit
            else if (Character.isDigit(curr)) {
                stk.push(Integer.valueOf(String.valueOf(curr)));
            }

            //operator
            else {

                if (stk.size() < 2) {
                    throw new Exception("illegal expression");
                }

                int val2 = stk.pop();
                int val1 = stk.pop();

                switch (curr) {
                    case '+':
                        stk.push(val1 + val2);
                        break;

                    case '-':
                        stk.push(val1 - val2);
                        break;

                    case '*':
                        stk.push(val1 * val2);
                        break;

                    case '/':
                        stk.push(val1 / val2);
                        break;
                }
            }

        }

        if (stk.size() == 1) {
            return stk.pop();
        }

        throw new Exception("illegal expression");

    }

}

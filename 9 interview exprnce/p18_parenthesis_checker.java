import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 * 
 * Given an expression string exp,
 * write a program to examine whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.
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
 * Declare a character stack S.
 * 
 * Now traverse the expression string exp. 
 * 
 * If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack.
 * 
 * If the current character is a closing bracket (‘)’ or ‘}’ or ‘]’) then pop from stack and 
 * if the popped character is the matching starting bracket then fine else brackets are not balanced.
 * 
 * After complete traversal, if there is some starting bracket left in stack then “not balanced”
 * 
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 *  
 */

class p18_parenthesis_checker {

    public static void main(String[] args) {

        String input = "[()]{}{[()()]()}";

        boolean answer = Solution.function(input);

        if (answer) {
            System.out.println("Balanced");
        } else {
            System.out.println("NOT Balanced");
        }

    }

}

class Solution {

    static boolean function(String input) {

        int n = input.length();

        if (n == 0) {
            return true;
        }

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < n; i++) {

            char curr = input.charAt(i);

            //push opening brace
            if (curr == '{' || curr == '[' || curr == '(') {
                stk.push(curr);
            }

            else {

                //if closing brace comes , stack must not be empty
                if (stk.empty()) {
                    return false;
                }

                //opposite suite brace
                else if (curr == '}') {
                    char popped = stk.pop();
                    if (popped == '[' || popped == '(') {
                        return false;
                    }
                }

                else if (curr == ']') {
                    char popped = stk.pop();
                    if (popped == '{' || popped == '(') {
                        return false;
                    }
                }

                else if (curr == ')') {
                    char popped = stk.pop();
                    if (popped == '[' || popped == '{') {
                        return false;
                    }
                }

            }
        }

        return (stk.size() == 0);

    }

}

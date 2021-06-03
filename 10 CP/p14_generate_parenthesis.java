import java.util.*;

/**
 * 
 * LC id : 22
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * Input: n = 3
 * 
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * 
 * 
 * 
 * https://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/
 * 
 * 
 *  
 */

/**
 * 
 * ==============
 * brute force
 * =============
 * using backtrack
 * keep track of open and closed braces used so far
 * and when equal to N , check if valid and add to list
 * 
 * 
 * 
 * ==========
 * optimised
 * ==========
 *  current char can be 
 * 1. opening brace : iff count_open < N
 * 2. closing brace : iff count_open > count_close
 *
 * here we can avoid validity check
 * 
 * 
 * 
 */

class p14_generate_parenthesis {

    public static void main(String[] args) {

        int n = 2;//expected : 2
        // int n = 3;//expected : 5

        // List<String> answer = new Solution().function(n);
        List<String> answer = new Solution_optimised().function(n);

        for (String s : answer) {
            System.out.println(s);
            System.out.println();
        }
        System.out.println("answer length : " + answer.size());
    }
}

class Solution {

    List<String> answer;

    List<String> function(int n) {
        answer = new ArrayList<>();
        fun("", 0, 0, n);
        return answer;
    }

    void fun(String till_now, int open, int close, int n) {

        if (open > n || close > n) {
            return;
        }

        else if (open == n && close == n) {

            if (is_valid(till_now)) {
                answer.add(till_now);
            }
        }

        else {

            if (open < n) {
                fun(till_now + "(", n, open + 1, close);
            }

            if (close < n) {
                fun(till_now + ")", n, open, close + 1);
            }

        }

    }

    boolean is_valid(String input) {

        int n = input.length();

        if (n == 0) {
            return true;
        }

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < n; i++) {

            char curr = input.charAt(i);
            if (curr == '{' || curr == '[' || curr == '(') {
                stk.push(curr);
            }

            else {
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

class Solution_optimised {

    List<String> answer;

    List<String> function(int n) {
        answer = new ArrayList<>();
        fun("", 0, 0, n);
        return answer;
    }

    void fun(String till_now, int open, int close, int n) {

        if (close == n) {
            answer.add(till_now);
            return;
        } else {

            //the only condition under which we can place a closing brace
            if (open > close) {
                String here = till_now + ")";
                fun(here, open, close + 1, n);
            }

            //the only condition under which we can place an opening brace
            if (open < n) {
                String here = till_now + "(";
                fun(here, open + 1, close, n);
            }

        }

    }

}

class Solution_optimised_Revision {

    List<String> answer;

    List<String> function(int n) {
        answer = new ArrayList<>();
        fun(0, 0, n, "");
        return answer;
    }

    void fun(int opn, int cls, int n, String curr) {

        if (opn > n || cls > n) {
            return;
        }

        if (opn == n && cls == n) {
            ans.add(curr);
            return;
        }

        String s1 = curr + "(";
        dfs(opn + 1, cls, n, s1);

        if (opn > cls) {
            String s2 = curr + ")";
            dfs(opn, cls + 1, n, s2);
        }
    }

}

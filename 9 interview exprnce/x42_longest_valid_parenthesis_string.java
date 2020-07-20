import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
 *
 * 
 * Given a string consisting of opening and closing parenthesis, find the length of the longest valid parenthesis substring.
 *
 *
 * 
 */

/**
 * 
 * using dp
 * 
 * 1) Create an array longest of length n (size of the input string) initialized to zero. 
 * The array will store the length of the longest valid substring ending at that index.
 * 
 * 
 * 2) Initialize result as 0.
 * 
 * 3) Iterate through the string from second character
 * a) If the character is '(' set longest[i]=0 as no valid sub-string will end with '('.
 * 
 * b) Else
 * i) if s[i-1] = '(' set longest[i] = longest[i-2] + 2
 * ii) else
 * set longest[i] = longest[i-1] + 2 + 
 * longest[i-longest[i-1]-2]
 * 
 * 4) In each iteration update result as the maximum of  result and longest[i]
 * 
 * 5) Return result
 * 
 * 
 * TC=n
 * SC=n
 * 
 * 
 * 
 * ======================
 * without dp
 * 
 * The idea to solve this problem is to traverse the string on and keep track of the count of open parentheses and close parentheses 
 * with the help of two counters left and right respectively.
 * 
 * 
 * First, the string is traversed from the left towards the right and for every “(” encountered, the left counter is incremented by 1 
 * and for every “)” the right counter is incremented by 1.
 * 
 * Whenever the left becomes equal to right, the length of the current valid string is calculated and 
 * if it greater than the current longest substring, then value of required longest substring is updated with current string length.
 * 
 * If the right counter becomes greater than the left counter, then the set of parentheses has become invalid and hence 
 * the left and right counters are set to 0.
 * 
 * 
 * After the above process, the string is similarly traversed from right to left and similar procedure is applied.
 * 
 * 
 * TC=n
 * SC=1
 * 
 * 
 * 
 * 
 *
 *
 * 
 * 
 */

class x42_longest_valid_parenthesis_string {

    public static void main(String[] args) {

        // String s = "()()()()";//expected : 8
        // String s = "()(()))))";//expected : 6
        String s = ")()())";//expected : 4

        int ans1 = Solution_dp.function(s);
        int ans2 = Solution_optimal.function(s);
        System.out.println(ans1);
        System.out.println(ans2);

    }

}

class Solution_dp {

    static int function(String str) {

        int n = str.length();
        int answer = 0;
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            char c = str.charAt(i);

            if (c == ')') {
                if (str.charAt(i - 1) == '(') {
                    dp[i] = 2 + ((i - 2 >= 0) ? dp[i - 2] : 0);
                }

                else {
                    int len = dp[i - 1];//length of prev index longest string
                    if (i - len - 1 >= 0 && str.charAt(i - len - 1) == '(') {
                        dp[i] = 2 + dp[i - 1]; //due to current (......)
                        dp[i] += (i - dp[i] >= 0) ? dp[i - dp[i]] : 0; //due to prev valid string also : ()(.......)

                    }
                }
            }

            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}

class Solution_optimal {

    public static int function(String str) {

        int n = str.length();
        int count_open = 0, count_close = 0;
        int answer = 0;

        // Iterating the string from count_open to count_close
        for (int i = 0; i < n; i++) {

            if (str.charAt(i) == '(')
                count_open++;
            else
                count_close++;

            // Whenever count_open is equal to count_close,it signifies that the subsequence is valid
            if (count_open == count_close)
                answer = Math.max(answer, 2 * count_close);

            // Reseting the counters when the subsequence becomes invalid
            else if (count_close > count_open)
                count_open = count_close = 0;
        }

        count_open = count_close = 0;

        // Iterating the string from count_close to count_open
        for (int i = n - 1; i >= 0; i--) {

            if (str.charAt(i) == '(')
                count_open++;
            else
                count_close++;

            if (count_open == count_close)
                answer = Math.max(answer, 2 * count_open);

            // Reseting the counters when the subsequence becomes invalid
            else if (count_open > count_close)
                count_open = count_close = 0;
        }

        return answer;
    }

}
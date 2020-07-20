import java.util.*;

/**
 * 
 * leetcode id : 125
 * 
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * 
 *
 * 
 *  
 */

/**
 * 
 * 
 * convert char and number to a uniform code
 * and compare front and last
 * 
 * use 2 pointer technique
 * 
 * 
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 */

class p7_valid_palindrome {

    public static void main(String[] args) {

        // String s = "A man, a plan, a canal: Panama"; //true
        // String s = "race a car"; //false
        String s = "ABHIANV vnaihba"; //true
        // String s = "0P"; //false
        // String s = " apG0i4maAs::sA0m4i0Gp0"; //false

        boolean answer = Solution.function(s);
        System.out.println(answer);

    }

}

class Solution {

    static boolean function(String s) {

        int n = s.length();

        if (n < 2) {
            return true;
        }

        int i = 0;
        int j = n - 1;

        while (i < j) {

            char ci = s.charAt(i);
            char cj = s.charAt(j);

            int cii = is_char(ci);
            int cjj = is_char(cj);

            if (cii == -1) {
                i++;
            }

            if (cjj == -1) {
                j--;
            }

            if (cii != -1 && cjj != -1) {
                if (cii != cjj) {
                    return false;
                }
                i++;
                j--;
            }

        }

        return true;

    }

    static int is_char(char c) {

        // System.out.println(c - 'a');
        // System.out.println(c - 'A');

        if (c - 'a' >= 0 && c - 'a' <= 25) {
            return c - 'a';
        } else if (c - 'A' >= 0 && c - 'A' <= 25) {
            return c - 'A';
        } else if (c - '0' >= 0 && c - '0' <= 9) {
            return 90 + (c - '0'); //if we donot do this , 0 and A will be same on comparison
        } else {
            return -1;
        }
    }

}

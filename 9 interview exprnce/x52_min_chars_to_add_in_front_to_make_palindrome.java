import java.util.*;

/**
 *
 * https://www.geeksforgeeks.org/minimum-characters-added-front-make-string-palindrome/
 * 
 * 
 * Given a string str we need to tell minimum characters to be added at front of string to make string palindrome.
 * 
 * 
 */

/**
 * ===========
 * approach 1
 * ============
 * Start checking the string each time if it is a palindrome and if not, then delete the last character and check again. 
 * When the string gets reduced to wither a palindrome or empty then 
 * the number of characters deleted from the end till now will be the answer 
 * as those characters could have been inserted at the beginning of the original string in the order which will make the string a palindrome.
 *
 * 
 * ============
 * TC = n^2
 * 
 * 
 * 
 * ===========
 * approach 2
 * ============
 * 
 * using lps array of KMP algorithm. 
 * 
 * First we concat string by concatenating given string, a special character and reverse of given string 
 * 
 * then we will get lps array for this concatenated string, 
 * recall that each index of lps array represent longest proper prefix which is also suffix.
 *  We can use this lps array for solving the problem. 
 * 
 * 
 * Here we are only interested in the last value of this lps array 
 * because it shows us the largest suffix of the reversed string that matches the prefix of the original string 
 * i.e these many characters already satisfy the palindrome property. 
 * Finally minimum number of character needed to make the string a palindrome is length of the input string minus last entry of our lps array. 
 * 
  ============
 * TC = n
 * 
 * 
 */

class x52_min_chars_to_add_in_front_to_make_palindrome {

    public static void main(String[] args) throws Exception {

        String str = "ABC";//2

        int answer1 = Solution.function(str);
        System.out.println(answer1);

        int answer2 = Solution_optimised.function(str);
        System.out.println(answer2);

    }

}

class Solution {

    static int function(String s) {

        int count = 0;
        int flag = 0;

        while (s.length() > 0) {
            // if string becomes palindrome then break 
            if (is_palindrome(s)) {
                flag = 1;
                break;
            } else {
                count++;

                // erase the last element of the string 
                s = s.substring(0, s.length() - 1);
            }
        }

        // print the number of insertion at front 
        if (flag == 1) {
            return count;
        }

        return 0;

    }

    static boolean is_palindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

class Solution_optimised {

    static int function(String str) {
        int n = str.length();
        if (n < 2) {
            return 0;
        }
        int[] LPS = get_lps(str);
        return n - LPS[LPS.length - 1];
    }

    static int[] get_lps(String s) {

        StringBuffer reversed = new StringBuffer(s);
        reversed.reverse();

        String required = s + "$" + reversed.toString();

        int[] LPS = new int[required.length()];
        LPS[0] = 0;

        int i = 1;//end of suffix
        int j = 0; //end of prefix

        while (i < required.length()) {

            if (required.charAt(i) == required.charAt(j)) {

                LPS[i] = j + 1;
                j++;
                i++;

            } else {
                if (j > 0) {
                    j = LPS[j - 1];
                } else if (j == 0) {
                    LPS[i] = 0;
                    i++;
                }

            }

        }

        return LPS;

    }

}

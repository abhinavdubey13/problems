
import java.util.*;

/**
 * leetcode id : 
 * 
 * Example: Let the input string be “i.like.to.very.much”. 
 * 
 * The function should change the string to “much.very.to.like.i”
 * 
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * 
 * Initially, reverse the individual WORDS of the given string one by one, 
 * 
 * for the above example, after reversing individual words the string should be “i ekil siht margorp yrev hcum”.
 * 
 * Reverse the whole string from start to end to get the desired output “much very program this like i” in the above example.
 *
 *  
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class p3_reverse_words {

    public static void main(String[] args) {
        // String input = "i like to very much";
        // char seperator = ' ';

        String input = "i.like.to.very.much";
        char seperator = '.';

        String answer = function(input, seperator);
        System.out.println(answer);

        String answer2 = Practise.fun(input, seperator);
        System.out.println(answer2);

    }

    static String function(String str, char seperator) {

        char[] arr = str.toCharArray();
        int n = arr.length;

        int start = 0, end = 0;

        while (end < n) {

            if (end + 1 == n || arr[end + 1] == seperator) {
                reverse(arr, start, end);

                end += 2;
                start = end;
            } else {
                end++;
            }

        }

        reverse(arr, 0, n - 1);

        return String.valueOf(arr);
    }

    static void reverse(char[] arr, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

}

class Practise {

    static String fun(String str, char seperator) {

        int i = 0;

        char[] arr = str.toCharArray();
        int n = arr.length;

        while (i < n) {
            for (int j = i; j < n; j++) {
                if (j == n - 1 || arr[j + 1] == seperator) {
                    p3_reverse_words.reverse(arr, i, j);
                    i = j + 2;
                    j = j + 2;
                }
            }
        }

        p3_reverse_words.reverse(arr, 0, n-1);
        String ret = String.valueOf(arr);
        return ret;
    }

}

import java.util.*;

/**
 * leetcode id : 
 * 
 * Example: Let the input string be “i.like.to.very.much”. 
 * 
 * The function should change the string to "i.ekil.ot.yrev.hcum”
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
 * reverse the individual WORDS of the given string one by one, using seperator
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

class p4_reverse_each_word_only {

    public static void main(String[] args) {
        // String input = "i like to very much";
        // char seperator = ' ';

        String input = "i.like.to.very.much";
        char seperator = '.';

        String answer = function(input, seperator);
        System.out.println(answer);

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

        // just skip this step from previous problem
        // reverse(arr, 0, n - 1);

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

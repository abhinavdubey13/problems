import java.util.*;

/**
 * leetcode id : 
 * 
 * Encrypy a given string as follows : 
 * Every substring of identical letters is replaced by a single instance of that letter followed by the number of occurences of that letter.
 * Then, the string thus obtained is further encrypted by reversing it.
 * 
 *  
 * =========
 * example 
 * =========
 * i/p : aabc
 * o/p : 1c1b2a
 * 
 * 
 * i/p : aa
 * o/p : 2a
 * 
 *  
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 *  simple traversal
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class p20_encrypt_string {

    public static void main(String[] args) {
        // String input = "aaabbbccc";
        // String input = "abc";
        String input = "aaa";

        String answer = function(input);
        System.out.println(answer);

        String answer2 = Practise.function(input);
        System.out.println(answer2);
    }

    static String function(String input) {

        char[] arr = input.toCharArray();
        int n = arr.length;
        StringBuffer answer = new StringBuffer();
        int i = 0, j = 1;
        while (j < n) {
            if (arr[j] == arr[j - 1]) {
                j++;
            } else {
                answer.append(arr[i]);
                answer.append(j - i);
                i = j;
                j++;
            }
        }

        answer.append(arr[i]);
        answer.append(j - i);
        return answer.reverse().toString();
    }
}

class Practise {

    static String function(String input) {

        char[] arr = input.toCharArray();
        int n = arr.length;

        StringBuffer answer = new StringBuffer();

        answer.append(arr[0]);
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                answer.append(count);
                answer.append(arr[i]);
                count = 1;
            }
        }

        answer.append(count);
        return answer.reverse().toString();
    }
}

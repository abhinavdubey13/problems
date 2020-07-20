import java.util.*;

/**
 * leetcode id : 
 * 
 * 
 * 
 *  
 * =========
 * example 
 * =========
 * i/p : 
 * o/p : 
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
 * https://www.youtube.com/watch?v=4jY57Ehc14Y&t=1047s&ab_channel=LogicFirst
 * 
 * in naive (brute force) algo , we go back in the text 
 * but in KMP algo , we go back in the pattern , not in the text
 * 
 * using longest prefix suffix approach
 * 
 * ============
 * TC = O(text+pattern)
 * SC = O(text+pattern)
 * 
 * 
 * 
 */

class p15_KMP_matching {

    public static void main(String[] args) {
        String text = "this is a sample text";

        String pattern = "sample";

        //answer is set of indices which begin with the pattern
        Set<Integer> answer_indices = function(text, pattern);
        System.out.println(answer_indices);
    }

    static Set<Integer> function(String text, String pattern) {

        char[] text_arr = text.toCharArray();
        char[] patt_arr = pattern.toCharArray();

        int[] LPS = get_LPS(pattern);

        Set<Integer> answer = new HashSet<>();

        int i = 0;
        int j = 0;

        while (i < text_arr.length) {

            //some match is there(match is when we reach end of pattern) ,  add it to the set
            if (j == patt_arr.length) {
                answer.add(i - patt_arr.length);
                j = LPS[LPS.length - 1];
                continue;
            }

            //match
            if (text_arr[i] == patt_arr[j]) {
                i++;
                j++;
            }

            //mismatch
            else {

                //if we cannot drag back in the pattern
                if (j == 0) {
                    i++;
                } else {
                    j = LPS[j - 1];
                }

            }

        }

        return answer;

    }

    static int[] get_LPS(String input) {

        char[] arr = input.toCharArray();
        int n = arr.length;

        int[] LPS = new int[n];
        LPS[0] = 0;

        int end_of_prefix = 0;
        int end_of_suffix = 1;

        while (end_of_suffix < n) {
            if (arr[end_of_prefix] == arr[end_of_suffix]) {

                LPS[end_of_suffix] = end_of_prefix + 1;
                end_of_prefix++;
                end_of_suffix++;

            } else {
                if (end_of_prefix == 0) {
                    LPS[end_of_suffix] = 0;
                    end_of_suffix++;
                } else {
                    end_of_prefix = LPS[end_of_prefix - 1];
                }

            }
        }

        return LPS;

    }

}

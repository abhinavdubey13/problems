import java.util.*;

/**
 * leetcode id : 
 * 
 * 
 * Given a string of characters, find the length of the longest proper prefix which is also a proper suffix.
 *  
 * =========
 * example 
 * =========
 * i/p : abab
 * o/p : 2 (answer = ab)
 * 
 * 
 * i/p : aaaa
 * o/p : 3 (answer = aaa)
 * 
 *  
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * we maintain 2 pointers , 
 * 1. end_of_prefix (eop) , and 
 * 2. end_of_suffix (eos)
 * 
 * and try to fill LPS[] at index eos : LPS[i] represents the length of maximum subarray which is prefix and suffix , ending at i as suffix
 * 
 * if arr[eos] and arr[eop] match 
 *      1. set LPS[eos] as eop+1  : bcz length will be eop+1
 *      2. increment both (eos,eop)
 * 
 * else :  basically , we need to drag eop back 
 *      1. if eop is already 0 , we can not drag it back , LPS[eos]=0 and increment eos
 *      2. else set eop = LPS[eop-1]
 * 
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 */

class p14_longest_prefix_suffix {

    public static void main(String[] args) {
        String input = "abcaby";

        int answer = function(input);
        System.out.println(answer);
    }

    static int function(String input) {

        int n = input.length();

        if (n < 2) {
            return 0;
        }

        char[] arr = input.toCharArray();

        int[] LPS = new int[n];
        LPS[0] = 0; //bcz for 1 character , we cannot have prefix and suffix , as both of them will be same

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

        int answer = 0;
        for (int i = 0; i < LPS.length; i++) {
            answer = Math.max(answer, LPS[i]);
        }
        return answer;

    }

}

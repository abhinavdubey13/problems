
import java.util.*;

/**
 * leetcode id : 
 * 
 * Given a string S. The task is to print all permutations of a given string.
 *
 * 
 * ===========
 * example -1
 * ===========
 * INPUT  : ABC
 * 
 * output : ABC ACB BAC BCA CAB CBA (total 6 permutations)
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
 * 
 *
 *  
 * 
 * ============
 * TC = O(n!)
 * SC = O(n!)
 * 
 * 
 * 
 */

class p1_all_permutations_of_string {

    static String INPUT = "ABCD";
    static int COUNT = 0;

    public static void main(String[] args) {

        int left = 0;
        int right = INPUT.length() - 1;

        permute(left, right);

        System.out.println("number of permutations : " + COUNT);

    }

    static void permute(int left, int right) {

        if (left == right) {
            // System.out.println(INPUT);
            COUNT++;
            return;
        }

        for (int i = left; i <= right; i++) {
            swap(left, i);//swap
            permute(left + 1, right);
            swap(left, i); //reset 
        }

    }

    static void swap(int i, int j) {
        char[] input_arr = INPUT.toCharArray();
        char temp = input_arr[i];
        input_arr[i] = input_arr[j];
        input_arr[j] = temp;
        INPUT = String.valueOf(input_arr);
    }

}

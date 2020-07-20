import java.util.*;

/**
 * You are given a sorted unique integer array nums.
 * 
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. 
 * That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 * 
 * Each range [a,b] in the list should be output as:
 * 
 * "a->b" if a != b
 * 
 * "a" if a == b
 * 
 * ========
 * example
 * ========
 * Input: nums = [0,1,2,4,5,7]
 * 
 * Output: ["0->2","4->5","7"]
 * 
 * 
 */

/**
 *  
 * ============
 * approach : 
 * ============
 * using 1 for loop
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 */

class x2_summary_ranges {

    static void print_array(List<String> arr) {
        for (String i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input = { 0, 1, 2, 4, 5, 7 };
        List<String> output = function(input);
        print_array(output);
    }

    static List<String> function(int[] input) {
        List<String> answer_list = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {

            int a = input[i];

            while (i + 1 < input.length && input[i + 1] == input[i] + 1) {
                i++;
            }

            if (a == input[i]) {
                answer_list.add(a + "");
            } else {
                answer_list.add(a + "->" + input[i]);

            }

        }

        return answer_list;

    }

}

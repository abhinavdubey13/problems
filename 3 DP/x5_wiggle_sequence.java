import java.util.*;


/**
 * 
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. 
 * 
 * The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.
 * 
 * 
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. 
 * 
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. 
 * A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, 
 * leaving the remaining elements in their original order.
 *
 */

/**
 * =============
 * APPROACH : 1
 * =============
 * same as longest inceasing subseq
 *  
 * ===========
 * TC = O(n^2)
 * SC = O(n)
 * 
 * 
 * 
 * 
 * =============
 * APPROACH : 2
 * =============
 * optimal 
 *  
 * ===========
 * TC = O(n)
 * SC = O(1)
 * 
 */

class Helper {
    int len;
    String next_sign;

    Helper(int l, String s) {
        this.len = l;
        this.next_sign = (s != null) ? new String(s) : null;
    }
}

public class x5_wiggle_sequence {

    public static void main(String[] args) {

        // int[] arr = { 2,2,2,2,3,4,3,4,3,4,3 };
        // int[] arr = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };

        // int[] arr = { 1, 7, 4, 9, 2, 5 };

        int[] arr = { 33, 53, 12, 64, 50, 41, 45, 21, 97, 35, 47, 92, 39, 0, 93, 55, 40, 46, 69, 42, 6, 95, 51, 68, 72,
                9, 32, 84, 34, 64, 6, 2, 26, 98, 3, 43, 30, 60, 3, 68, 82, 9, 97, 19, 27, 98, 99, 4, 30, 96, 37, 9, 78,
                43, 64, 4, 65, 30, 84, 90, 87, 64, 18, 50, 60, 1, 40, 32, 48, 50, 76, 100, 57, 29, 63, 53, 46, 57, 93,
                98, 42, 80, 82, 9, 41, 55, 69, 84, 82, 79, 30, 79, 18, 97, 67, 23, 52, 38, 74, 15 };

        int answer = function(arr);
        System.out.println(answer);

    }

    static int function(int[] arr) {

        Helper[] table = new Helper[arr.length];

        for (int i = 0; i < arr.length; i++) {
            table[i] = new Helper(1, null);
        }

        for (int i = 1; i < arr.length; i++) {

            for (int j = 0; j < i; j++) {

                if (j != 0) {

                    if (table[j].next_sign.equals("+") && arr[i] > arr[j]) {
                        String sign = "-";
                        int len = Math.max(table[i].len, 1 + table[j].len);
                        table[i] = new Helper(len, sign);
                    } else if (table[j].next_sign.equals("-") && arr[i] < arr[j]) {
                        String sign = "+";
                        int len = Math.max(table[i].len, 1 + table[j].len);
                        table[i] = new Helper(len, sign);
                    }

                } else {
                    if (arr[i] > arr[j]) {
                        String sign = "-";
                        table[i] = new Helper(2, sign);
                    } else if (arr[i] < arr[j]) {
                        String sign = "+";
                        table[i] = new Helper(2, sign);
                    }
                }

            }
        }

        return table[arr.length - 1].len;

    }

    //optimal answer
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;

        return Math.max(up, down);
    }

}
import java.util.*;

/**
 *
 * 
 * https://www.geeksforgeeks.org/minimum-swaps-bracket-balancing/
 * 
 * given a string containing equal number of opening and closing braces
 * 
 * 
 * find min number of swaps to make it valid
 * we can swap only adjacent elements
 * 
 * https://www.youtube.com/watch?v=Ylz6mwghDrU&ab_channel=CodeLibrary
 * 
 * 
 * 
 */

/**
 * ===========
 * approach 1
 * ============
 * 
 * maintain a list of index of opening braces
 * no , whenever a fault is found , swap indices of curr and idx from above list
 * 
 * 
 * ============
 * TC = n
 * SC = n
 * 
 * 
 * 
 * ===========
 * approach 2
 * ============
 * 
 * maintain openCounter , closeCounter , faultCounter
 * 
 * 
 * the below check happens only if opening brace is foun
 * if(fault>0){
 *  add somehing to final answer
 * }
 * 
 * ============
 * TC = n
 * SC = 1
 * 
 * 
 */

class x51_min_adjacent_swaps_for_balanced_parenthesis_expression {

    public static void main(String[] args) throws Exception {
        // String str = "]][[";//3
        // String str = "[]][][";//2
        String str = "[][]";//0

        int swaps = Solution.function(str);
        System.out.println(swaps);

        int swaps2 = Solution_optimised.function(str);
        System.out.println(swaps2);

    }

}

class Solution {

    static int function(String str) {

        int n = str.length();

        int num_swaps = 0;

        int counter = 0;

        List<Integer> idx_opening = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '[') {
                idx_opening.add(i);
            }
        }

        //only iterates over list of opening braces
        int idx = 0;

        for (int i = 0; i < n; i++) {
            char curr = str.charAt(i);
            if (curr == '[') {
                counter++;
                idx++;
            } else {
                counter--;
                if (counter < 0) {
                    num_swaps += Math.abs(idx_opening.get(idx) - i);
                    str = swap(idx_opening.get(idx), i, str);
                    idx++;
                    counter = 1; //this is important , cannot set it to zero , bcz i'th char is [ now after swap
                }
            }
        }

        return num_swaps;

    }

    static String swap(int i, int j, String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();

    }

}

class Solution_optimised {

    static int function(String str) {

        int n = str.length();
        int num_swaps = 0;

        int fault = 0;
        int open = 0;
        int close = 0;

        for (int i = 0; i < n; i++) {
            char curr = str.charAt(i);
            if (curr == ']') {
                close++;
                fault = (close - open);
            } else {
                open++;
                if (fault > 0) {
                    num_swaps += fault;
                    fault--;
                }

            }
        }

        return num_swaps;

    }

}

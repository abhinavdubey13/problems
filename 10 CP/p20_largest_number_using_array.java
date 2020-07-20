import java.util.*;

/**
 * 
 * leetcode id : 179
 * 
 * Given a list of non-negative integers nums, arrange them such that they form the largest number.
 * 
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 * 
 *  
 */

/**
 * 
 * 
 * convert to string array
 * then , use custom comparator , to sort string in lexicographic order (a+b , b+a)
 * 
 * 
 * 
 * TC = n.logn
 * SC = n
 * 
 */

class p20_largest_number_using_array {

    public static void main(String[] args) {

        // int[] arr = { 3, 30, 34, 5, 9 };
        int[] arr = { 0, 0, 0, 1 };

        String answer = Solution.function(arr);
        System.out.println(answer);

        Collections.swap(list, i, j);
    }
}

class Solution {

    static String function(int[] arr) {

        String[] arr2 = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arr2[i] = String.valueOf(arr[i]);
        }

        Arrays.sort(arr2, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return -1 * s1.compareTo(s2);
            }
        });

        String ans = "";
        for (String s : arr2) {
            ans += s;
        }

        //below logic handles prefix zeros
        int i;
        for (i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) == '0') {
                continue;
            } else {
                break;
            }
        }

        if (i == ans.length()) {
            return "0";
        } else {
            return ans.substring(i);
        }

    }

}

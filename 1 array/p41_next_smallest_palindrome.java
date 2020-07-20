import java.util.*;

/**
 * 
 * 
 * https://www.geeksforgeeks.org/given-a-number-find-next-smallest-palindrome-larger-than-this-number/
 * 
 * Given a number, find the next smallest palindrome larger than this number. 
 * 
 * ========
 * example 
 * ========
 * i/p : 2 3 5 4 5 
 * o/p : 2 3 6 3 2
 * 
 * i/p : 9 9 9
 * o/p : 1 0 0 1
 * 
 * 
 * 
 */

/**
 *  
 * ============
 * approach : 
 * ============
 *  
 * There can be three different types of inputs that need to be handled separately
 * 
 * 1) The input number is palindrome and has all 9s. For example “9 9 9”. Output should be “1 0 0 1”
 * 2) The input number is palindrome and doesn’t have all 9s. For example “1 2 2 1”. Output should be “1 3 3 1”.
 * 3) The input number is not palindrome. For example “1 2 3 4”. Output should be “1 3 3 1”
 * 
 * 
 * for case-1 : answer is simple : first and last digits as 1 and in between all are 0
 * 
 * for remaining 2 cases 
 * Left  Side : The left half of given number. Left side of “1 2 3 4 5 6”   is “1 2 3” and left side of “1 2 3 4 5” is “1 2”
 * Right Side : The right half of given number. Right side of “1 2 3 4 5 6” is “4 5 6” and right side of “1 2 3 4 5” is “4 5”
 * 
 * for case-2 : add 1 to left side and keep on taking carry forward , them taker mirror image of LHS to get RHS
 * for case-3 : find the point of mismatch <i,j>
 * 
 * if arr[i]>arr[j] : take mirror image of LHS into RHS
 * else             : add 1 to left side and keep on taking carry forward , them taker mirror image of LHS to get RHS
 * 
 * 
 * ================ 
 * TC= O(N)
 * SC= O(N) 
 * 
 */

class p41_next_smallest_palindrome {

    public static void main(String[] args) {
        int[] arr = { 1,2,5,3,2,2 };
        // int[] arr = { 7,1,3,3,2,2 };
        // int[] arr = { 1, 2, 3, 4, 6, 2, 8 };

        // int[] arr = { 9, 9, 9 };

        // boolean result = Helper.is_palindrome(test, 2, 4);
        // System.out.println(result);

        int[] result = function(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static int[] function(int[] arr) {

        if (arr.length == 0) {
            int[] answer = { 1 };
            return answer;
        }

        //if input has only 1 digit
        if (arr.length == 1) {
            if (arr[0] == 9) {
                int[] answer = { 1, 1 };
                return answer;
            } else {
                int[] answer = { arr[0] + 1 };
                return answer;
            }
        }

        //if all digits are 9 (atleast two 9's)
        boolean all_9 = Helper.is_all_9(arr);
        if (all_9) {
            int[] answer = new int[arr.length + 1];
            answer[0] = answer[answer.length - 1] = 1; //set 1st and last digits as 1 , rest as 0
            return answer;
        }

        int i, j;
        int n = arr.length;
        if (n % 2 == 0) {
            i = n / 2 - 1;
            j = n / 2;
        } else {
            i = n / 2 - 1;
            j = n / 2 + 1;
        }

        boolean is_already_palindrome = Helper.is_palindrome(arr, i, j);

        //if input arr is already palindromic 
        //there is a seperate case handling it
        if (is_already_palindrome) {
            return Helper.handle_palindromic_case(arr);
        }

        //if not palindromic , we find the 1st mis-match i,j pair
        while (i >= 0 && j < arr.length) {
            if (arr[i] != arr[j]) {
                break;
            }
            i--;
            j++;
        }

        // if left is smaller
        //handle with palindromic case
        if (arr[i] < arr[j]) {
            return Helper.handle_palindromic_case(arr);
        }

        //if left is bigger
        //take mirror image of left into the right side
        while (i >= 0) {
            arr[j] = arr[i];
            i--;
            j++;
        }

        return arr;
    }

}

class Helper {

    static boolean is_all_9(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 9) {
                return false;
            }
        }
        return true;
    }

    static boolean is_palindrome(int[] arr, int i, int j) {
        while (i >= 0 && j < arr.length) {
            if (arr[i] != arr[j]) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    static int[] handle_palindromic_case(int[] arr) {
        int i;
        int n = arr.length;
        if (n % 2 == 0) {
            i = n / 2 - 1;
        } else {
            i = n / 2;
        }

        List<Integer> return_list = new ArrayList<>();

        int add = 0;
        int carry = 1;
        int rem = 0;

        while (i >= 0) {
            add = arr[i] + carry;
            carry = add / 10;
            rem = add % 10;
            return_list.add(0, rem);
            i--;
        }

        if (carry > 0) {
            return_list.add(0, carry);
        }

        int[] return_arr = new int[2 * return_list.size()];
        i = return_list.size() - 1;
        int j = i + 1;

        for (; i >= 0; i--) {
            return_arr[i] = return_list.get(i);
            return_arr[j] = return_arr[i];
            j++;
        }

        return return_arr;
    }

}

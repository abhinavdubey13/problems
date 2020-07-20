import java.util.*;

/**
 * leetcode id : 
 * 
 * Given two positive numbers as strings. 
 * 
 * The numbers may be very large (may not fit in long long int)
 * 
 * the task is to find product of these two numbers.
 * 
 *  
 * =========
 * example 
 * =========
 * i/p : 4154 , 51454
 * o/p : 213739916
 * 
 *  
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * using simple multiplications and shifting(ie adding zeros at last)
 * 
 * when we multiply 2 numbers : result wil have at-most 2*m*n digits
 * ============
 * TC = O(m.n)
 * SC = O(m+n)
 * 
 * 
 * 
 */

class p17_multiply_2_strings {

    public static void main(String[] args) {
        String A = "1000";
        String B = "99";

        // String A = "4154";
        // String B = "51454";

        //AxB = BxA
        String answer = function(A, B);
        System.out.println(answer);
    }

    static String function(String A, String B) {
        char[] a_arr = A.toCharArray();
        char[] b_arr = B.toCharArray();

        List<Integer> answer = new ArrayList<>();

        // when we multiply 2 numbers
        // result wil have at-most 2*m*n digits
        for (int i = 0; i < 2 * a_arr.length * b_arr.length; i++) {
            answer.add(0, 0);
        }

        for (int j = b_arr.length - 1; j >= 0; j--) {

            int carry = 0;
            List<Integer> curr = new ArrayList<>();

            //adding trailing zeros at-last if required 
            for (int z = 0; z < b_arr.length - 1 - j; z++) {
                curr.add(0, 0);
            }

            for (int i = a_arr.length - 1; i >= 0; i--) {

                int dig_a = a_arr[i] - '0';
                int dig_b = b_arr[j] - '0';

                int mul = (dig_a * dig_b + carry);

                int rem = mul % 10;
                carry = mul / 10;

                curr.add(0, rem);

            }

            curr.add(0, carry);
            // System.out.println(curr);

            //adding current to the final answer
            add_lists(answer, curr);

        }

        String return_ans = remove_zeros(answer);
        return return_ans;

    }

    static void add_lists(List<Integer> answer, List<Integer> curr) {

        int carry = 0;
        int rem = 0;
        int added = 0;

        int i = answer.size() - 1;
        int j = curr.size() - 1;

        for (; j >= 0; i--, j--) {

            int a = answer.get(i).intValue();
            int b = curr.get(j).intValue();

            added = a + b + carry;
            carry = added / 10;
            rem = added % 10;

            answer.set(i, rem);
        }

        added = answer.get(i).intValue() + carry;

        if (i >= 0) {
            answer.set(i, added % 10);
        }
        if (added > 9) {
            answer.set(i - 1, added / 10);

        }

    }

    static String remove_zeros(List<Integer> answer) {
        int i;
        for (i = 0; i < answer.size(); i++) {
            if (answer.get(i) != 0) {
                break;
            }
        }

        if (i == answer.size() - 1) {
            return " ";
        }

        StringBuffer str = new StringBuffer();
        while (i < answer.size()) {
            str.append(answer.get(i).intValue());
            i++;
        }

        return str.toString();
    }

}

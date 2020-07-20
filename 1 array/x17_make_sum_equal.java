import java.util.*;

/**
 * Alice and Bob have candy bars of different sizes:
 * 
 * A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.
 * 
 * Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
 * 
 * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.
 * 
 * If there are multiple answers, you may return any one of them. 
 * It is guaranteed an answer exists.
 * 
 *
 * 
 * =========
 * examples
 * =========
 * 
 * Input: A = [1,1], B = [2,2]
 * Output: [1,2]
 * 
 * Example 2:
 * Input: A = [1,2], B = [2,3]
 * Output: [1,2]
 * 
 * 
 * Example 3:
 * input: A = [2], B = [1,3]
 * Output: [2,3]
 *
 * 
 *  Example 4:
 * Input: A = [1,2,5], B = [2,4]
 * Output: [5,4]
 * 
 */

/**
 *  
 * ============
 * approach : 
 * ============
 *
 * derive relation b/w the sum of the 2 arrays , the pair of element required
 * 
 * use hashset 
 *
 *  
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class x17_make_sum_equal {

    public static void main(String[] args) {
        int[] A = { 1, 2, 5 };
        int[] B = { 2, 4 };
        int[] answer = function(A, B);

        // System.out.println(answer);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();
    }

    static int[] function(int[] A, int[] B) {

        int sum_a = 0, sum_b = 0;

        for (int i : A) {
            sum_a += i;
        }

        for (int i : B) {
            sum_b += i;
        }

        if (sum_a < sum_b) {
            return function(B, A);
        }

        int[] answer = new int[2];

        int k = (Math.abs(sum_a - sum_b)) / 2;

        Set<Integer> set = new HashSet<Integer>();
        for (int i : B) {
            set.add(i);
        }

        for (int i = 0; i < A.length; i++) {
            if (set.contains(A[i] - k)) {
                answer[0] = A[i];
                answer[1] = A[i] - k;
            }
        }

        return answer;

    }

}

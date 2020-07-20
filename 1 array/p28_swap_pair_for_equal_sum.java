import java.util.*;

/**
 * 
 * given 2 arrays
 * find if there is a pair , such that on exchanging them the sum of the 2 arrays become equal
 * 
 * https://www.geeksforgeeks.org/find-a-pair-swapping-which-makes-sum-of-two-arrays-same/
 * 
 * ===========
 * example -1
 * ===========
 * A[] = { 4, 1, 2, 1, 1, 2 };
 * B[] = { 3, 6, 3, 3 };
 * 
 * pair = {1,3}
 * 
 */

/**
 * ===========
 * approach :
 * ===========
 * 
 * form a mathematical relation : A-a+b = B-b+a 
 * A : sum of array A
 * B : sum of array B
 * a : element removed from A and added to B
 * b:  element removed from B and added to A
 * 
 * assuming : B > A , we have
 * b-a = (B-A)/2
 * 
 * ie. difference of sum must be even
 * 
 * after this we can use 2 approaches :
 * 
 *  1. using HashSet to store elements of 1 array and iterate over the next array and check if the relation satisfy
 *  2. sorting 2 arrays and using 2 pointers technique 
 * 
 * TC_1 = O(N)
 * SC_1 = O(N) 
 * 
 * TC_2 = O(N.logN + M.logM)
 * SC_2 = O(1) 
 * 
 */

class p28_swap_pair_for_equal_sum {

    public static void main(String[] args) {

        int A[] = { 4, 1, 2, 1, 1, 2 };
        int B[] = { 3, 6, 3, 3 };

        // good sample case : avoids some random brute force , which is not right anyways
        // there is no such pair
        // int A[] = { 1, 0, 1, 1 };
        // int B[] = { 2, 0, 2, 2 };

        function(A, B);
    }

    static void function(int A[], int[] B) {
        int req_diff = get_target_diff(A, B);

        if (req_diff == -1) {
            System.out.println("NOT POSSIBLE");
            return;
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0, j = 0;

        //a-b = req_diff

        while (i < A.length && j < B.length) {

            int found_diff = A[i] - B[j];

            if (found_diff == req_diff) {
                System.out.println("Pair(a,b) : " + A[i] + " , " + B[j]);
                break;
            }

            else if (found_diff > req_diff) {
                j++;
            }

            else if (found_diff < req_diff) {
                i++;
            }
        }

    }

    static int get_target_diff(int[] A, int[] B) {

        int sum_a = 0;
        int sum_b = 0;

        for (int i : A) {
            sum_a += i;
        }

        for (int i : B) {
            sum_b += i;
        }

        if (sum_a - sum_b % 2 == 1) {
            return -1;
        }

        return (sum_a - sum_b) / 2;

    }

}
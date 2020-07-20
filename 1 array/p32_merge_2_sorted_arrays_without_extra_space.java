import java.util.*;

/**
 * 
 * given 2 sorted arrays , merge them in same input arrays such that space cmplexity = O(1)
 * 
 * https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
 * 
 * 
 */

/**
 *  
 * ============
 * approach : 
 * ============
 * 
 * We can use Insertion Sort type of insertion for this
 * (B.length <= A.length)
 * 
 * 
 * for each element in B , using insertion sort find the right place for B[i] in A[]
 *
 * TC= O(N.M)
 * SC= O(1)
 * 
 * 
 * 
 * 
 */

class p32_merge_2_sorted_arrays_without_extra_space {

    public static void main(String[] args) {
        int[] A = { 3, 9, 15, 16 };
        int[] B = { 5, 10 };
        
        function(A, B);

        //printing only
        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : B) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void function(int A[], int B[]) {

        if (B.length > A.length) {
            function(B, A);
        }

        // now B.len <= A.len

        int i, j;
        for (i = B.length - 1; i >= 0; i--) {

            int last_in_A = A[A.length - 1];
            int val_to_be_inserted = B[i];

            for (j = A.length - 2; j >= 0; j--) {
                if (A[j] < val_to_be_inserted) {
                    A[j + 1] = val_to_be_inserted;
                    B[i] = last_in_A;
                    break;
                } else {
                    A[j + 1] = A[j];
                }

            }
        }

    }

}
import java.util.*;

/**
 * 
 * given an array and a sum  , check if there exist a pair with that sum
 * 
 * ==========
 * example :
 * ==========
 * 
 * arr = { 0, -1, 2, -3, 1 };
 * req_sum = -2;
 * 
 * 
 * yes : (-3,1)
 * 
 * 
 */

/**
 * =============
 * approach : 1
 * =============
 * 
 *
 * using 2 pointers : sort the input array and check for sum , move left/right pointers if sum not found 
 * 
 * TC=(N.logN)
 * SC=O(N)
 * for merge-sort
 * 
 * TC=(N^2)
 * SC=O(1)
 * for quick-sort
 * 
 * =============
 * approach : 2 
 * =============
 * 
 *
 * using Hashing : for each element do :
 * 
 * 1. iterate over the array and check if (SUM-currenElement) is in haashmap , 
 * 2. insert currenElement in hashmap
 * 
 * TC=(N)
 * SC=O(N)
 * 
 * 
 * 
 * 
 */

class p9_pair_with_given_sum {
    
    public static void main(String[] args) {

        int[] arr = { 0, -1, 2, -3, 1 };
        int req_sum = -2;

        // two_pointer_method(arr, req_sum);
        hash_method(arr, req_sum);

    }

    static void hash_method(int[] arr, int SUM) {
        boolean RESULT = false;

        Map<Integer, Boolean> my_map = new HashMap<>();

        for (int i : arr) {
            int required_element = SUM - i;

            if (my_map.get(required_element) != null) {
                RESULT = true;
            }
            my_map.put(i, true);
        }

        if (RESULT) {
            System.out.println("pair exists");
        } else {
            System.out.println("NO such pair exists");
        }
    }

    static void two_pointer_method(int[] arr, int SUM) {
        boolean RESULT = false;

        Arrays.sort(arr);

        int i = 0, j = arr.length - 1;

        while (i < j) {
            int x = arr[i];
            int y = arr[j];
            if (x + y == SUM) {
                RESULT = true;
                break;
            }

            else if (x + y < SUM) {
                i++;
            } else if (x + y > SUM) {
                j--;
            }
        }

        if (RESULT) {
            System.out.println("pair exists");
        } else {
            System.out.println("NO such pair exists");
        }

    }

}
import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/count-possible-groups-size-2-3-sum-multiple-3/
 *
 * 
 * Given an unsorted integer (positive values only) array of size ‘n’, we can form a group of two or three, 
 * the group should be such that the sum of all elements in that group is a multiple of 3. 
 * 
 * Count all possible number of groups that can be generated in this way.
 * 
 * ==========
 * example :
 * ==========
 * Input: arr[] = {3, 6, 7, 2, 9}
 * Output: 8
 * 
 * Groups are {3,6}, {3,9}, {9,6}, {7,2}, 
 * {3,6,9}, {3,7,2}, {7,2,6}, {7,2,9}
 * 
 * Input: arr[] = {2, 1, 3, 4}
 * Output: 4
 * Groups are {2,1}, {2,4}, {2,1,3}, {2,4,3} 
 * 
 */

/**
 * ============
 * approach : 
 * =============
 * 
 * The idea is to see remainder of every element when divided by 3. 
 * 
 * A set of elements can form a group only if sun of their remainders is multiple of 3
 * 
 * 1. Hash all elements in a count array based on remainder, i.e, for all elements a[i], do c[a[i]%3]++;
 * 
 * 2. Now c[0] contains the number of elements which when divided by 3 leave remainder 0 and similarly c[1] for remainder 1 and c[2] for 2.
 * 
 * 3. Now for group of 2, we have 2 possibilities
 * a. 2 elements of remainder 0 group. Such possibilities are c[0]*(c[0]-1)/2
 * b. 1 element of remainder 1 and 1 from remainder 2 group Such groups are c[1]*c[2].
 * 
 * 4. Now for group of 3,we have 4 possibilities
 * a. 3 elements from remainder group 0. No. of such groups are c[0]C3   (combinatorics)
 * b. 3 elements from remainder group 1. No. of such groups are c[1]C3
 * c. 3 elements from remainder group 2. No. of such groups are c[2]C3
 * d. 1 element from each of 3 groups.   No. of such groups are c[0]*c[1]*c[2].
 * 
 * ===============
 * TC = O(n)
 * SC = O(1) : a number when divided by 3 can have only 3 remainders
 * 
 * 
 */

class p51_possible_groups_of_size_2_and_3 {

    public static void main(String[] args) {
        int arr[] = { 3, 6, 7, 2, 9 }; //answer = 8

        int answer = function(arr);
        System.out.println(answer);
    }

    static int function(int[] arr) {

        int[] c = { 0, 0, 0 };

        for (int i : arr) {
            c[i % 3]++;
        }

        int size_2_count = 0;
        int size_3_count = 0;

        // Case 3.a: Count groups of size 2 from 0 remainder elements 
        size_2_count += (c[0] - 1 > 0) ? ((c[0] * (c[0] - 1)) >> 1) : 0;

        // Case 3.b: Count groups of size 2 with one element with 1 
        // remainder and other with 2 remainder 
        size_2_count += c[1] * c[2];

        // Case 4.a: Count groups of size 3 with all 0 remainder elements 
        size_3_count += (c[0] - 2 > 0) ? (c[0] * (c[0] - 1) * (c[0] - 2)) / 6 : 0;

        // Case 4.b: Count groups of size 3 with all 1 remainder elements 
        size_3_count += (c[1] - 1 > 0) ? (c[1] * (c[1] - 1) * (c[1] - 2)) / 6 : 0;

        // Case 4.c: Count groups of size 3 with all 2 remainder elements 
        size_3_count += (c[2] - 2 > 0) ? ((c[2] * (c[2] - 1) * (c[2] - 2)) / 6) : 0;

        // Case 4.c: Count groups of size 3 with different remainders 
        size_3_count += c[0] * c[1] * c[2];

        return size_2_count + size_3_count;

    }

}

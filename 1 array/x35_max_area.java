import java.util.*;

/**
 * leetcode id : 11
 * 
 * Given n non-negative integers a1, a2, ..., an , 
 * 
 * where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). 
 * 
 * Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
 * 
 * Notice that you may not slant the container.
 * 
 * ===========
 * example -1
 * ===========
 * 
 * input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
 * 
 * In this case, the max area of water (blue section) the container can contain is 49. 
 * 
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * 
 * problem reduces to find : Max( j-i * min( arr[i] , arr[j] ))
 * 
 * this can be done by 2 pointers
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class x35_max_area {

    public static void main(String[] args) {

        int[] arr = { 6, 0, 8, 2, 1, 5 };

        int answer = function(arr);

        System.out.println(answer);

    }

    static int function(int[] arr) {
        int n = arr.length;

        int answer = 0;

        int i = 0, j = n - 1;

        while (i < j) {

            int width = j - i;
            int height = Math.min(arr[i], arr[j]);
            int new_area = width * height;

            answer = Math.max(answer, new_area);

            if (arr[i] < arr[j]) {
                i++;
            } else {
                j--;
            }

        }

        return answer;

    }

}

import java.util.*;

/**
 * 
 * leetcode id : 84
 * 
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 * 
 * ==========
 * example :
 * ==========
 * 
 * i/p : 
 * o/p : 
 * 
 */

/**
 * ============
 * approach : 2
 * =============
 * 
 * using stack
 * 
 * ===============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

class p1_max_histogram_area {

    public static void main(String[] args) {

        // int[] arr = { 6, 2, 5, 4, 5, 1, 6 }; //expected =12

        int[] arr = { 7, 2, 8, 9, 1, 3, 6, 5 }; //expected = 16

        // int answer = Brute_force.function(arr);

        int answer = Optimal.function(arr);

        System.out.println(answer);

    }

}

class Brute_force {

    static long function(long[] arr, long n) {

        if (n == 0) {
            return 0;
        }

        else if (n == 1) {
            return arr[0];
        }

        else if (n == 2) {
            return Math.min(arr[0], arr[1]) * 2;
        }

        long answer = 0;
        for (int i = 0; i < n; i++) {

            int prev = i;
            int next = i;

            long curr_ht = arr[i];

            while (prev - 1 >= 0 && arr[prev - 1] >= curr_ht) {
                prev--;
            }

            while (next + 1 < n && arr[next + 1] >= curr_ht) {
                next++;
            }
            long width = next - prev + 1;
            long area_new = curr_ht * width;
            answer = Math.max(answer, area_new);

        }

        return answer;

    }

}

class Optimal {

    static int function(int[] arr) {

        if (arr.length == 0) {
            return 0;
        }

        int n = arr.length;
        Stack<Integer> stk = new Stack<Integer>();

        stk.push(-1);//index of left most , initially

        int answer = 0;

        for (int i = 0; i < n; i++) {

            int curr_ht = arr[i];

            //basic idea : in each iteration , either the area contribution of topmost element will be checked , or not 
            while (stk.peek() > -1) {
                if (curr_ht < arr[stk.peek()]) {

                    int top = stk.pop();
                    int right = i; //right limit is i , bcz the i'th (or curr) height is smaller than the stk top height , ie topmost height can expand further
                    int left = stk.peek(); //left limit is peek element , bcz when we were pushing , we pushed in increasing order or heights

                    int height = arr[top];
                    int width = right - left - 1;
                    int area = height * width;

                    answer = Math.max(answer, area);
                } else {
                    break;
                }
            }

            stk.push(i);
        }

        while (stk.peek() != -1) {

            int top = stk.pop();

            int right = n;
            int left = stk.peek();

            int height = arr[top];
            int width = right - left - 1;
            int area = height * width;

            answer = Math.max(answer, area);
        }
        return answer;

    }

}

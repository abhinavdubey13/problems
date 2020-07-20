import java.util.*;

/**
 * 
 * leetcode id : 
 * 
 * There are N ticket sellers each of whom has a certain amount of tickets. 
 * The price of a ticket is the number of tickets remaining with the ticket seller. They can sell a total of K tickets. 
 * Find the maximum amount they can earn by selling K tickets. 
 * The amount of tickets of each seller is provided in array A. Give the answer modulo 109 + 7
 *
 * 
 * ==========
 * example :
 * ==========
 * 
 * Input: N = 5, K = 3
 * A = {4, 3, 6, 2, 4}
 * Output: 15
 * Explaination: Consider 0 based indexing. 
 * For first two turns the 2nd seller sells. 
 * For the third turn either 0th or 2nd 
 * seller can sell. So the total becomes 
 * 
 * 6 + 5 + 4 = 15. 
 * 
 */

/**
 * ============
 * approach : 1
 * =============
 * using max-heap (priority-queue)
 * 
 * ===============
 * TC = O(n.logn)
 * SC = O(n)
 * 
 * 
 */

class p49_ticket_seller {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int tickets = 3;

        int answer = function(arr, tickets);
        System.out.println(answer);

    }

    static int function(int[] arr, int tickets) {

        int n = arr.length;

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());

        // Insert each array element 
        // into the priority queue 
        for (int i = 0; i < n; i++) {
            heap.add(arr[i]);
        }

        // To store the total number of tickets sold 
        int ticketSold = 0;

        int ans = 0;

        // While tickets sold are less than N and q.top > 0 then update the collected 
        // amount with the top of the priority queue 
        while (ticketSold < tickets && heap.peek() > 0) {
            ans = ans + heap.peek();
            int temp = heap.peek();
            heap.poll();
            heap.add(temp - 1);
            ticketSold++;
        }
        return ans;

    }

}

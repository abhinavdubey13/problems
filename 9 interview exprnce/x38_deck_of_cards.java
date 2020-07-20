import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/find-the-number-on-the-card-that-remains-in-the-end-after-performing-the-given-operations/
 * 
 * Given an integer N which represents the number of cards in a deck. The deck is ordered from 1 to N 
 * where 1 is the topmost card and N is at the bottom. You take out the topmost card from the deck and insert it at the bottom and 
 * throw the next card that appears at the top of the deck. 
 * 
 * Again you do the same thing until a single card remains. The task is to find the number of the card that remains at the end.
 * 
 * 
 * Examples:
 * Input: N = 4 
 * Output: 1
 * 1 2 3 4
 * ^     ^
 * Top   Bottom
 * 
 * Operation 1: 3 4 1 (1 got shifted to the bottom and 2 got removed)
 * Operation 2: 1 3 (3 got shifted and 4 got removed)
 * Operation 3: 1 (3 got removed after shifting 1)
 * 
 * Input: N = 10
 * Output: 5
 * 
 *
 * 
 */

/**
 * 
 *
 * using queue
 * 
 * while q.size > 1
 * 
 * 
 * 
 */

class x38_deck_of_cards {

    public static void main(String[] args) {
        int n = 10;//expected : 5
        int last_card = Solution.function(n);
        System.out.println(last_card);
    }

}

class Solution {

    static int function(int n) {

        //invalid case
        if (n < 0) {
            return -1;
        }

        if (n < 2) {
            return n;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        int state = 0;
        while (q.size() > 1) {
            int removed = q.poll();
            if (state == 0) {
                q.offer(removed);
            }
            state = 1 - state;
        }

        return q.peek();

    }
}

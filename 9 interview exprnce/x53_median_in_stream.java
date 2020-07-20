import java.util.*;

/**
 *
 * https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
 * 
 * Given that integers are read from a data stream. Find median of elements read so for in efficient way. 
 * 
 * For simplicity assume there are no duplicates. For example, let us consider the stream 5, 15, 1, 3 …
 * 
 * 
 */

/**
 * 
 * https://www.youtube.com/watch?v=dshWERdcAdg&t=600s&ab_channel=Pepcoding
 * 
 * ===========
 * approach 1
 * ============
 * insertion sort
 * ============
 * TC = n^2
 * 
 * 
 * 
 * ===========
 * approach 2
 * ============
 * AVL tree (balanced BST)
 * 
  ============
 * TC = nlogn
 * 
 * 
 * 
 * ===========
 * approach 3
 * ============
 * 
 * Heaps
 * 
 * maintain 2 heaps : min an max heap
 * 
 * if min_hp.size>=max_hp.size : min_heap's top is our median
 * else max_heap's top is our median
 * 
  ============
 * TC = nlogn
 * 
 * 
 */

class x53_median_in_stream {

    public static void main(String[] args) throws Exception {

        Solution s = new Solution();

        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(5);
        s.add(6);
        s.add(7);


        System.out.println(s.get_median());


    }

}

class Solution {

    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    Solution() {
        this.left = new PriorityQueue<>(Collections.reverseOrder()); //max heap
        this.right = new PriorityQueue<>(); //min heap
    }

    void add(int x) {

        //add in right PQ : if x > right.peek
        //for other cases add in left PQ
        if (right.size() > 0 && x > right.peek()) {
            right.offer(x);
        } else {
            left.offer(x);
        }

        //balancing
        if ((left.size() - right.size()) > 1) {
            right.offer(left.poll());
        } else if ((right.size() - left.size()) > 1) {
            left.offer(right.poll());
        }

    }

    int get_median() {
        if ((this.left.size() + this.right.size()) == 0) {
            System.out.println("underflow");
            return -1;
        }

        //if size equals , we prefer left max as median and not sum/2
        if (left.size() >= right.size()) {
            return left.peek();
        } else {
            return right.peek();
        }
    }

    int remove_median() {
        if ((this.left.size() + this.right.size()) == 0) {
            System.out.println("underflow");
            return -1;
        }

        //if size equals , we prefer left max as median and not sum/2
        if (left.size() >= right.size()) {
            return left.remove();
        } else {
            return right.remove();
        }

    }

}

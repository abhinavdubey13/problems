import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * shown below is min-heap and max-heap implementation using priority_queue
 * 
 * priority_queue : elements are added and deleted from a queue based on some priority 
 * 
 * 
 */

class heap_in_java {

    public static void main(String[] args) {
        int arr[] = { 10, 7, 11, 5, 2, 13, 1, 45 };

        min_heap(arr);
        // max_heap(arr);

    }

    static void min_heap(int[] arr) {

        // when we do not pass anything , it implies min-heap
        // PriorityQueue<Integer> min_heap = new PriorityQueue<>();

        //the below is used when each element of heap is a user-defined object 
        PriorityQueue<Integer> min_heap = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer first, Integer second) {
                return (first.intValue() - second.intValue());
            }
        });

        //adding new element and printing the min-element(top element) of the heap
        for (int i : arr) {
            min_heap.offer(i);
            System.out.print(min_heap.peek() + " ");
        }

        System.out.println();

        //removing and priniting min-element(top-element) from heap one-by-one
        for (int i = 0; i < arr.length; i++) {
            Integer popped = min_heap.poll();
            System.out.print(popped + " ");
        }

        System.out.println();
    }

    static void max_heap(int[] arr) {

        //by collections.reverse order we pass a comparator 
        // PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());

        //the below is used when each element of heap is a user-defined object 
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer first, Integer second) {
                return -1 * (first.intValue() - second.intValue());
            }
        });

        //adding new element and printing the max-element(top element) of the heap
        for (int i : arr) {
            max_heap.offer(i);
            System.out.print(max_heap.peek() + " ");
        }

        System.out.println();

        //removing and priniting max-element(top-element) from heap one-by-one
        for (int i = 0; i < arr.length; i++) {
            Integer popped = max_heap.poll();
            System.out.print(popped + " ");
        }

        System.out.println();

    }

}

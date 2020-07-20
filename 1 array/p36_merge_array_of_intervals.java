import java.util.*;

/**
 * Given a set of time intervals in any order, merge all overlapping intervals into one 
 * and output the result which should have only mutually exclusive intervals. 
 * 
 * Let the intervals be represented as pairs of integers for simplicity. 
 * 
 * 
 * For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8}}.
 * The intervals {1,3} and {2,4} overlap with each other, 
 * so they should be merged and become {1, 4}. 
 * Similarly, {5, 7} and {6, 8} should be merged and become {5, 8}
 * 
 * 
 * https://www.geeksforgeeks.org/merging-intervals/
 * 
 */

/**
 *  
 * ============
 * approach : 1
 * ============
 * 
 * 2 loops scan
 * 
 * TC= O(N^2)
 * SC= O(1)
 * 
 * ==============
 * approach : 2
 * ==============
 *  step-1 Sort all intervals in increasing order of start time.
 *  step-2 Traverse sorted intervals starting from first interval, 
 *    do following for every interval.
 * 
 *   a) If current interval is not first interval and it 
 *       overlaps with previous interval, then merge it with
 *       previous interval. Keep doing it while the interval
 *       overlaps with the previous one.         
 *    b) Else add current interval to output list of intervals.
 * 
 * 
 * TC= O(N.logN)
 * SC= O(1)
 * 
 * 
 * 
 */

class Interval {
    int start;
    int end;

    Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }
}

class p36_merge_array_of_intervals {

    public static void main(String[] args) {
        // Interval arr[] = new Interval[4];
        // arr[0] = new Interval(6, 8);
        // arr[1] = new Interval(1, 9);
        // arr[2] = new Interval(2, 4);
        // arr[3] = new Interval(4, 7);

        Interval arr[] = new Interval[3];
        arr[0] = new Interval(1, 3);
        arr[1] = new Interval(4, 9);
        arr[2] = new Interval(5, 6);

        function(arr);
    }

    static void function(Interval arr[]) {

        //sorting in ascending order of start
        Arrays.sort(arr, new Comparator<Interval>() {
            public int compare(Interval x, Interval y) {
                return (x.start - y.start);
            }
        });

        int begin_idx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].start <= arr[begin_idx].end) {
                arr[begin_idx].start = Math.min(arr[begin_idx].start, arr[i].start);
                arr[begin_idx].end = Math.max(arr[begin_idx].end, arr[i].end);
            } else {
                begin_idx++;
            }
        }

        System.out.print("The Merged Intervals are: ");
        for (int i = 0; i <= begin_idx; i++) {
            System.out.print("[" + arr[i].start + "," + arr[i].end + "]");
        }

        System.out.println();

    }

}

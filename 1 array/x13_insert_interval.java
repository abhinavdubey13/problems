import java.util.*;

/**
 * 
 * 
 * Given a set of non-overlapping intervals, and a new interval 
 * 
 * insert new interval into the intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * ===========
 * example -1
 * ===========
 * 
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 
 * Output: [[1,2],[3,10],[12,16]]
 * 
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10]
 * 
 * 
 */

/**
 *  
 * ===========
 * approach : 
 * ===========
 * make a list of all intervals , including new interval
 * 
 * sort the new list based on start time
 * 
 * compare i'th index with (i+1)th index and merge if required
 * 
 * 
 * 
 *  
 * ============
 * TC = O(n.logn)
 * SC = O(n)
 * 
 * 
 * 
 */

class Helper {

    int a;
    int b;

    Helper() {
        this.a = 0;
        this.b = 0;
    }

    Helper(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class x13_insert_interval {

    public static void main(String[] args) {
        // int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        // int[] new_interval = { 4, 8 };

        // int[][] intervals = {};
        // int[] new_interval = { 5, 7 };

        // int[][] intervals = {{1,5}};
        // int[] new_interval = { 2,3 };

        int[][] intervals = { { 1, 5 } };
        int[] new_interval = { 2, 7 };

        int[][] answer = function(intervals, new_interval);
        System.out.println(answer);
    }

    static int[][] function(int[][] intervals, int[] new_interval) {

        List<Helper> my_list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            my_list.add(new Helper(intervals[i][0], intervals[i][1]));
        }

        my_list.add(new Helper(new_interval[0], new_interval[1]));

        Collections.sort(my_list, new Comparator<Helper>() {
            public int compare(Helper o1, Helper o2) {
                return o1.a - o2.a;
            }
        });

        List<Helper> answer = new ArrayList<>();

        answer.add(new Helper(my_list.get(0).a, my_list.get(0).b));
        int j = 0;

        for (int i = 1; i < my_list.size(); i++) {
            Helper orig = my_list.get(i);
            Helper ans = answer.get(j);
            Helper newHelper = new Helper();

            if (orig.a <= ans.b) {
                newHelper.a = ans.a;
                newHelper.b = Math.max(orig.b, ans.b);
                answer.remove(j);
                answer.add(j, newHelper);
            } else {
                j++;
                newHelper.a = orig.a;
                newHelper.b = orig.b;
                answer.add(j, newHelper);

            }

        }

        int[][] ans = new int[answer.size()][2];

        for (int i = 0; i < answer.size(); i++) {
            ans[i][0] = answer.get(i).a;
            ans[i][1] = answer.get(i).b;
        }

        return ans;

    }

}

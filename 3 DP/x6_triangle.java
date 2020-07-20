import java.util.*;

/**
 * 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * 
 * =========
 * example :
 * =========
 * 
 * [
 *    [2],
 *   [3,4],
 *  [6,5,7],
 * [4,1,8,3]
 * ]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 *
 */

/**
 * =============
 * APPROACH : 
 * =============
 * use dp
 *  
 * ===========
 * TC = O(n2)
 * SC = O(n)
 * 
 * 
 * 
 */

public class x6_triangle {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> a0 = new ArrayList<Integer>();
        a0.add(2);
        arr.add(a0);

        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(3);
        a1.add(4);
        arr.add(a1);

        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(6);
        a2.add(5);
        a2.add(7);
        arr.add(a2);

        ArrayList<Integer> a3 = new ArrayList<Integer>();
        a3.add(4);
        a3.add(1);
        a3.add(8);
        a3.add(3);
        arr.add(a3);

        int answer = function(arr);
        System.out.println(answer);

    }

    static int function(List<ArrayList<Integer>> arr) {

        if (arr.size() == 1) {
            return arr.get(0).get(0);
        }

        if (arr.size() == 2) {
            return arr.get(0).get(0) + Math.min(arr.get(1).get(0), arr.get(1).get(1));

        }

        ArrayList<ArrayList<Integer>> table = new ArrayList<ArrayList<Integer>>(arr.size());

        ArrayList<Integer> a0 = new ArrayList<Integer>();
        a0.add(arr.get(0).get(0));
        table.add(a0);

        for (int i = 1; i < arr.size(); i++) {

            ArrayList<Integer> prev_list = table.get(i - 1);
            ArrayList<Integer> curr_list = arr.get(i);
            ArrayList<Integer> ai = new ArrayList<Integer>(curr_list.size());

            for (int j = 0; j < curr_list.size(); j++) {

                if (j == 0) {
                    ai.add(prev_list.get(0) + curr_list.get(0));
                } else if (j == curr_list.size() - 1) {
                    ai.add(prev_list.get(prev_list.size() - 1) + curr_list.get(curr_list.size() - 1));
                } else {
                    int choice_1 = curr_list.get(j) + prev_list.get(j - 1);
                    int choive_2 = curr_list.get(j) + prev_list.get(j);
                    ai.add(Math.min(choice_1, choive_2));
                }

            }

            table.add(ai);
        }

        ListIterator<Integer> it = table.get(table.size() - 1).listIterator();

        int answer = Integer.MAX_VALUE;

        while (it.hasNext()) {
            answer = Math.min(answer, it.next().intValue());
        }

        return answer;

    }

}
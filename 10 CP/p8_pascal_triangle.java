import java.util.*;

/**
 * 
 * leetcode id : 118
 * 
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * 
 * https://leetcode.com/problems/pascals-triangle/
 *
 * 
 *  
 */

/**
 * 
 * 
 * current[i] = prev[i] + prev[i-1]
 *
 * TC = optimal
 * SC = can be reduced
 * 
 */

class p8_pascal_triangle {

    public static void main(String[] args) {

        int n = 5;
        List<List<Integer>> answer = Solution.function(n);

        for (List<Integer> lst : answer) {
            for (Integer i : lst) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
    }
}

class Solution {

    static List<List<Integer>> function(int n) {

        List<List<Integer>> answer = new ArrayList<>();

        if (n == 0) {
            return answer;
        }

        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        answer.add(lst);
        if (n == 1) {
            return answer;
        }

        List<Integer> lst2 = new ArrayList<>();
        lst2.add(1);
        lst2.add(1);
        answer.add(lst2);
        if (n == 2) {
            return answer;
        }

        for (int i = 2; i < n; i++) {

            List<Integer> prev = answer.get(i - 1);

            List<Integer> curr = new ArrayList<>();
            curr.add(1);

            for (int j = 1; j <= prev.size(); j++) {

                if (j == prev.size()) {
                    curr.add(1);
                    break;
                } else {
                    curr.add(prev.get(j) + prev.get(j - 1));
                }
            }

            answer.add(curr);

        }

        // System.out.println(Math.floor(Math.sqrt(15)));
        return answer;

    }

}

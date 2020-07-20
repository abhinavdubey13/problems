import java.util.*;

/**
 * 
 * Problem : https://www.geeksforgeeks.org/ways-to-arrange-balls-such-that-adjacent-balls-are-of-different-types/
 * 
 * There are ‘p’ balls of type P, ‘q’ balls of type Q and ‘r’ balls of type R. 
 * 
 * Using the balls we want to create a straight line such that no two balls of same type are adjacent.
 *
 * 
 */

/**
 * =============
 * APPROACH : 
 * =============
 * 
 * The basic solution to this problem is a recursive solution. We recursively call for three cases
 * 1) Last ball required to be placed is of type P
 * 2) Last ball required to be placed is of type Q
 * 3) Last ball required to be placed is of type R
 * 
 * involve a dp map , to store the sub-problems already calculated
 * 
 * 
 *
 * ===========
 * TC = O(n^2)
 * SC = O(n)
 * 
 * 
 * 
 * 
 *
 * 
 */

public class p51_no_adjacent_balls {

    public static void main(String[] args) {

        int p = 1;
        int q = 1;
        int r = 1; //expctd = 6

        int answer = function_util(p, q, r);
        System.out.println(answer);
    }

    static int function_util(int p, int q, int r) {

        Map<String, Integer> dp = new HashMap<>();
        int answer = function(dp, p, q, r, 'p') + function(dp, p, q, r, 'q') + function(dp, p, q, r, 'r');
        return answer;
    }

    static int function(Map<String, Integer> dp, int p, int q, int r, char last_required) {

        //base case 1
        if (p < 0 || q < 0 || r < 0) {
            return 0;
        }

        //base case 2
        if (p == 1 && q == 0 && r == 0 && last_required == 'p') {
            return 1;
        }

        //base case 3
        if (p == 0 && q == 1 && r == 0 && last_required == 'q') {
            return 1;
        }

        //base case 4
        if (p == 0 && q == 0 && r == 1 && last_required == 'r') {
            return 1;
        }

        //if non-base case , check if already calculated
        String key = p + "-" + q + "-" + r + "-" + last_required;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        //if non-base and not already calculated , then recurse to find the solution
        //depending on what ball is needed at last
        int count = 0;
        if (last_required == 'p') {
            count = function(dp, p - 1, q, r, 'q') + function(dp, p - 1, q, r, 'r');
        } else if (last_required == 'q') {
            count = function(dp, p, q - 1, r, 'p') + function(dp, p, q - 1, r, 'r');
        } else if (last_required == 'r') {
            count = function(dp, p, q, r - 1, 'p') + function(dp, p, q, r - 1, 'q');
        }

        //update map before returning the count
        dp.put(key, count);
        return count;

    }

}
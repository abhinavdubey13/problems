import java.util.*;

/**
 * 
 * leetcode id : 2744
 * 
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. 
 * 
 * You begin the journey with an empty tank at one of the gas stations.
 * 
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, 
 * otherwise return -1. If there exists a solution, it is guaranteed to be unique
 * 
 * 
 * 
 * Example 1:
Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
 * 
 *  
 */

/**
 * 
 * brute force : 
 * 1. find net[] : net[i] = gas[i]-cost[i]
 * 2. iterate on net[i] : for a valid starting point : net[i] > 0 and all other stops must be iterable 
 *  
 * TC = n^2
 * SC = 1 (use gas[] as net[])
 * 
 * 
 * 
 * 
 * 
 * optimal : 
 * 1. if sum(gas)-sum(cost) >=0 : then solution exist : else return -1
 * https://leetcode.com/problems/gas-station/discuss/42667/Straightforward-Java-Linear-Solution-with-O(1)-space-explanation-and-Math-proof
 *  
 * TC = n
 * SC = 1 (use gas[] as net[])
 * 
 * 
 * 
 */

class p29_gas_station {

    public static void main(String[] args) {

        // int[] gas = { 1, 2, 3, 4, 5 };
        // int[] cost = { 3, 4, 5, 1, 2 };

        int[] gas = { 2, 3, 4 };
        int[] cost = { 3, 4, 3 };

        int answer = Solution.function(gas, cost);
        System.out.println(answer);
    }

}

class Solution {

    static int function(int[] gas, int[] cost) {

        int n = gas.length;

        if (n == 1) {
            return gas[0] >= cost[0] ? 0 : -1;
        }

        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[i] = gas[i] - cost[i];
        }

        for (int start = 0; start < n; start++) {

            if (temp[start] > 0) {

                int fuel_left = temp[start];
                int steps = 1;
                for (; steps <= n; steps++) {
                    int next_idx = (start + steps) % n;
                    fuel_left += temp[next_idx];
                    if (fuel_left < 0) {
                        break;
                    }
                }

                //if completed all steps : start point selected was valid answer
                if (steps == n + 1) {
                    return start;
                }

            }
        }

        //if no possible start point 
        return -1;

    }

}

class Optimal {

    public int function(int[] gas, int[] cost) {
        int tank = 0;
        for (int i = 0; i < gas.length; i++)
            tank += gas[i] - cost[i];
        if (tank < 0)
            return -1;

        int start = 0;
        int accumulate = 0;
        for (int i = 0; i < gas.length; i++) {
            int curGain = gas[i] - cost[i];
            if (accumulate + curGain < 0) {
                start = i + 1;
                accumulate = 0;
            } else
                accumulate += curGain;
        }

        return start;
    }
}

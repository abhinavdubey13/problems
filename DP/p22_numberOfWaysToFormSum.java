
// Given an array of integers and a SUM, the task is to count all subsets of given array with sum equal to given sum.

/**
 * x-axis = set elements
 * y-axis = sum to be formed
 * 
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom
 * 
 * this problem is similar to subset-sum , but here instead of boolean answer , we need to find number of solutions
 * 
 * table[i][j] represent the number of ways to form sum=j using A[0....i]
 * 
 * for table[i][j] , we have 2 choices :
 *      1. include A[i] , in the sum => number of ways to form sum=j will be : table[i-1][j-A[i]] 
 *      2. exclude A[i] , in the sum => number of ways to form sum=j will be : table[i-1][j] 
 * 
 * we need to sum up the above 2 cases every time
 */

class p22_numberOfWaysToFormSum {

    public static void main(String[] args) {
        int[] set = { 1, 2, 3, 4, 5 };
        int SUM = 10;
        int answer = calulator(SUM, set);
        System.out.println(answer);
    }

    static int calulator(int SUM, int[] set) {
        int[][] table = new int[set.length][SUM + 1];

        // 1st column
        for (int row = 0; row < set.length; row++) {
            table[0][row] = 1;
        }

        // 1st row (the only possible sum is the 1st element of set itself)
        for (int col = 1; col <= SUM; col++) {
            table[0][col] = (set[0] == col) ? 1 : 0;
        }

        for (int i = 1; i < set.length; i++) {
            for (int currentSum = 1; currentSum <= SUM; currentSum++) {

                // set element > current sum , the fetch from top ie ignore this element
                if (set[i] > currentSum) {
                    table[i][currentSum] = table[i - 1][currentSum];
                    continue;
                }

                table[i][currentSum] = table[i - 1][currentSum - set[i]] + table[i - 1][currentSum];
            }
        }

        return table[set.length - 1][SUM];
    }
}
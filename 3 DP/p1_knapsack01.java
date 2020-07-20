/**
 * Given weights and profits of N items, put these items in a knapsack of capacity W to get the maximum total profit in the knapsack. 
 * Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that 
 * 
 * sum of the weights of this subset is smaller than or equal to W.
 * 
 * NOTE : You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 * 
 */

/**
 * ==========
 * APPROACH : 
 * ==========
 * 
 * x-axis = weigthts(and corresponding profit) given as input parameter 
 * y-axis = total weight of knapsack considered 
 * 
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom  
 * 
 * 
 * table[i][currentWeight] => MAX(profit with current i'th element , profit without i'th element)
 * 
 *     profit without current i'th element => table[i-1][currentWeight] => the element just above
 *     profit with current i'th element => table[i-1][currentWeight-weight of i'th element]
 * 
 * =======================
 * total items = n
 * knapSack capacity = W
 * 
 * TC = O(n.W)
 * SC = O(n.W)
 * 
 * 
 */

class p1_knapsack01 {

    public static void main(String[] args) {
        int[] profits = new int[] { 60, 100, 120 };
        int[] weights = new int[] { 10, 20, 30 };
        int capacity = 50;

        int ans = calulator(capacity, weights, profits);
        System.out.println(ans);
    }

    static int calulator(int totalW, int weights[], int profits[]) {
        int[][] table = new int[weights.length][totalW + 1];

        //1st column : if knapSack = 0 , no profit
        for (int i = 0; i < profits.length; i++) {
            table[i][0] = 0;
        }

        for (int i = 0; i < profits.length; i++) { // i iterates over the weight []
            for (int currentWeight = 1; currentWeight <= totalW; currentWeight++) { // currentWeight increments the weight by 1

                int x_index = i - 1;

                // y_index =  remaining wt. after including current wt.
                int y_index = currentWeight - weights[i];

                int profit_with = 0;
                int profit_without = 0;

                if (x_index >= 0 && y_index >= 0) {
                    profit_with = profits[i] + table[x_index][y_index];
                }

                if (x_index >= 0) {
                    profit_without = table[x_index][currentWeight];
                }

                table[i][currentWeight] = Math.max(profit_with, profit_without);
            }
        }

        return table[profits.length - 1][totalW];

    }

}
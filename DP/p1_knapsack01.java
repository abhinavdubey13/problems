
/**
 * x-axis = weigthts(and corresponding profit) given as input parameter 
 * y-axis = total weight of knapsack considered
 * 
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom  
 * 
 * 
 * table[i][j] => MAX(profit with current i'th element , profit without i'th element)
 * 
 * profit without current i'th element => table[i-1][j] => the element just above
 * 
 * profit with current i'th element => table[i-1][j-weight of i'th element]
 * 
 * 
 */

class p1_knapsack01 {

    public static void main(String[] args) {
        int[] profits = new int[] { 60, 100, 120 };
        int[] weights = new int[] { 10, 20, 30 };
        int ans = calulator(50, weights, profits);
        System.out.println(ans);
    }

    static int calulator(int totalW, int weights[], int profits[]) {
        int[][] T = new int[weights.length][totalW + 1];

        for (int i = 0; i < profits.length; i++) { // i iterates over the weight []
            for (int j = 0; j <= totalW; j++) { // j increments the weight by 1

                if (j == 0) {
                    T[i][j] = 0;
                    continue;
                }

                int x_index = i - 1;
                int y_index = j - weights[i];
                int value_1 = 0;
                int value_2 = 0;

                if (x_index >= 0 && y_index >= 0 && j >= weights[i]) {
                    value_1 = profits[i] + T[x_index][y_index];
                }

                if (x_index >= 0) {
                    value_2 = T[i - 1][j];
                }

                int final_val = Math.max(value_1, value_2);
                T[i][j] = final_val;

            }
        }

        return T[profits.length - 1][totalW];

    }

}
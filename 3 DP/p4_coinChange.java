/**
 *  given  1. unlimited supply of every coin in a set of coins , and 
 *         2. SUM to be formed 
 * 
 * find minimum number of coins required to for the SUM
 * 
 * ==========
 * example :
 * ==========
 * set = {25,11,5,10}
 * sum = 110
 * 
 * min-coins = 5 (25 + 25 + 25 + 25 + 10)
 * 
 */

/**
 * 
 * x-axis = coins available
 * y-axis = SUM to be formed
 * 
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom
 * 
 * table[i][curr_sum] = min(#coins to form sum=curr_sum with current coin ,  #coins to form sum=curr_sum without current coin)
 * 
 * #coins to form sum=curr_sum without current coin = table[i-1][curr_sum]
 * #coins to form sum=curr_sum with current coin = table[i][curr_sum-currentCoin]  => since infinte coins are available , we dont go to previous row
 * 
 * TC = O(set-size . SUM)
 * SC = O(set-size . SUM)
 * 
 * 
 */

class p4_coinChange {

    public static void main(String[] args) {

        int SUM = 110;
        int[] coin_set = new int[] { 25, 10, 11, 5 };
        int answer = calulator(SUM, coin_set);
        System.out.println(answer);

    }

    static int calulator(int SUM, int coin_set[]) {

        final int INFINITY = 10000;

        int[][] table = new int[coin_set.length][SUM + 1];

        for (int i = 0; i < coin_set.length; i++) {
            for (int curr_sum = 0; curr_sum <= SUM; curr_sum++) {

                //1st column init : no coins are required if SUM to be formed =0 
                if (curr_sum == 0) {
                    table[i][curr_sum] = 0;
                }

                //init 1st row
                else if (i == 0) {
                    table[i][curr_sum] = (curr_sum - coin_set[0] >= 0) ? 1 + table[0][curr_sum - coin_set[0]]
                            : INFINITY;
                }

                //other cells except 1st row/col             
                else {
                    int without_i = table[i - 1][curr_sum];

                    //we do not do table[i-1][curr_sum-coinTocnsider[i]] here bcz supply of coins is infinite
                    int with_i = (curr_sum - coin_set[i] >= 0) ? 1 + table[i][curr_sum - coin_set[i]] : INFINITY;

                    table[i][curr_sum] = Math.min(without_i, with_i);
                }
            }
        }

        return table[coin_set.length - 1][SUM];
    }
}
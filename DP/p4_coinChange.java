//given unlimited supply of a set of coins and a sum to be made , find minimum number of required 

/**
 * 
 * x-axis = coins available
 * y-axis = sum to be formed
 * 
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom
 * 
 * table[i][j] = min(#coins to form sum with current coin ,  #coins to form sum without current coin)
 * 
 * #coins to form sum without current coin = table[i-1][j]
 * #coins to form sum with current coin = table[i][j-currentCoin]  => since infinte coins are available , we dont go to previous row
 * 
 * 
 */

class p4_coinChange {

    public static void main(String[] args) {

        int sum = 110;
        int[] coinsToConsider = new int[] { 25, 10, 11, 5 };
        int answer = calulator(sum, coinsToConsider);
        System.out.println(answer);

    }

    static int calulator(int sum, int coinsToConsider[]) {

        final int INFINITY = 10000;

        int[][] table = new int[coinsToConsider.length][sum + 1];

        for (int i = 0; i < coinsToConsider.length; i++) {
            for (int j = 0; j <= sum; j++) {

                //no coins are required if sum to be formed =0 (1st column init)
                if (j == 0) {
                    table[i][j] = 0;
                }

                //init 1st row
                else if (i == 0) {
                    table[0][j] = (j - coinsToConsider[0] >= 0) ? 1 + table[0][j - coinsToConsider[0]] : INFINITY;
                }

                //other cells except 1srrow/col             
                else {
                    int without_i = table[i - 1][j];
                    int with_i = (j - coinsToConsider[i] >= 0) ? 1 + table[i][j - coinsToConsider[i]] : INFINITY; //we donot do table[i-1][j-coinTocnsider[i]] here bcz supply of coins is infinite
                    table[i][j] = Math.min(without_i, with_i);
                }
            }
        }

        return table[coinsToConsider.length - 1][sum];
    }
}
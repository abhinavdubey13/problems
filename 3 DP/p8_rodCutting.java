/**
 * given length of a rod , and possible cuts' length (and profit for that cut) 
 * 
 * find maximum acheivable profit by cutting the rod in those cut lengths only
 * 
 * ==========
 * example :
 * ==========
 *  rod-size = 5
 *  possible-cuts =    { 1, 2, 3, 4 }
 *  possible-profits = { 2, 5, 7, 8 } 
 * 
 * max-profit = 12
 * cuts = 2,3  
 * 
 * (5 = 1+4 => profit : 10 )
 * (5 = 1+4 => profit : 12 )
 *  
 */

/**
 * x-axis : possible cuts (and their profits)
 * y-axis : length of rod considered
 * 
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom  
 * 
 *   
 * ==============================================
 * TC = O(rod-length . cuts)
 * SC = O(rod-length . cuts)
 * 
 * 
 */

class p8_rodCutting {

    public static void main(String[] args) {

        int rodSize = 5;
        int[][] prices = { { 1, 2, 3, 4 }, { 2, 5, 7, 8 } };
        //prices[0] => possible length into which we can cut the rod
        //prices[1] => profit of corresponding lenghts

        int answer = calulator(rodSize, prices);
        System.out.println(answer);

    }

    static int calulator(int rodSize, int[][] prices) {

        int n = prices[0].length;

        int[][] table = new int[n][rodSize + 1];

        for (int i = 0; i < n; i++) {
            for (int currentLength = 0; currentLength <= rodSize; currentLength++) {

                int size_i = prices[0][i];
                int profit_i = prices[1][i];
                int remainingRod = currentLength - size_i;

                // 1st column
                if (currentLength == 0) {
                    table[i][currentLength] = 0;
                    continue;
                }

                // 1st row
                if (i == 0) {
                    table[i][currentLength] = (remainingRod >= 0) ? profit_i + table[0][remainingRod] : 0;
                    continue;
                }

                // rest of the table
                int without = table[i - 1][currentLength];
                int with = (remainingRod >= 0) ? profit_i + table[i][remainingRod] : 0;
                table[i][currentLength] = Math.max(with, without);

            }
        }
        return table[n - 1][rodSize];
    }
}
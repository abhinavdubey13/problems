//given length of a rod , and possible cuts' lenght (and profit for that cut) , find maximum profit by cutting the rod in those cut lengths only

/**
 * x-axis : possible cuts (and their profits)
 * y-axis : length of rod considered
 * 
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom  
 * 
 * 
 * (this problem is similar to 01 knapsack concept)
 * 
 * 
 */

class p8_rodCutting {

    public static void main(String[] args) {

        int rodSize = 5;
        int[][] prices = { { 1, 2, 3, 4 }, { 2, 5, 7, 8 } };
        int answer = calulator(rodSize, prices);
        System.out.println(answer);

    }

    static int calulator(int rodSize, int[][] prices) {
        int[][] table = new int[prices[0].length][rodSize + 1];

        for (int i = 0; i < prices[0].length; i++) {
            for (int currentLength = 0; currentLength <= rodSize; currentLength++) {

                int currentSize = prices[0][i];
                int profitDueToCurrentSize = prices[1][i];
                int remainingRod = currentLength - currentSize;

                // 1st column
                if (currentLength == 0) {
                    table[i][currentLength] = 0;
                    continue;
                }

                // 1st row
                if (i == 0) {
                    table[i][currentLength] = (remainingRod >= 0) ? profitDueToCurrentSize + table[0][remainingRod] : 0;
                    continue;
                }

                // rest of the table
                int profitWithoutCurrentSize = table[i - 1][currentLength];
                int profitWithCurrentSize = (remainingRod >= 0) ? profitDueToCurrentSize + table[i][remainingRod] : 0;
                table[i][currentLength] = Math.max(profitWithCurrentSize, profitWithoutCurrentSize);

            }
        }
        return table[prices[0].length - 1][rodSize];
    }
}
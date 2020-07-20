/**
 * Given a square matrix where every cell has some cost. You are given some coins in the beginning .
 * Count number of ways to reach bottom right from top left WITH EXACTLY "K" COINS . 
 * NOTE : u can move to (i+1, j) and (i, j+1) from a cell (i, j).
 * 
 * 
 */

/**
 * 
 * 
 * time-complexity of below is exponential (recursive solution)
 * 
 * we can do in pseudo polynomial time using 2D dp table , table[i][j] will have set of possible cost left , after reaching [i][j] from [0][0]
 * 
 */

public class p36_numberOfPathsWithGivenCoins {
    public static void main(String[] args) {

        int coins_available = 12;
        int cost[][] = { { 1, 2, 3 }, { 4, 6, 5 }, { 3, 2, 1 } };

        // int coins_available = 16;
        // int cost[][] = { { 1, 2, 3 }, { 4, 6, 5 }, { 9,8,7 } };


        //we need to goto [2][2] form [0][0]
        int destination_row_number = 2;
        int destination_col_number = 2;

        int answer = calculator(coins_available, cost, destination_row_number, destination_col_number);
        System.out.println(answer);

    }

    static int calculator(int coins_available, int[][] cost, int dest_row_number, int dest_col_number) {

        if (dest_col_number < 0 || dest_row_number < 0) {
            return 0;
        }

        if (dest_row_number == 0 && dest_col_number == 0
                && (coins_available == cost[dest_row_number][dest_col_number])) {
            return 1;
        }

        int coins_left = coins_available - cost[dest_row_number][dest_col_number];

        int ways_to_reach_left_cell = calculator(coins_left, cost, dest_row_number - 1, dest_col_number);
        int ways_to_reach_above_cell = calculator(coins_left, cost, dest_row_number, dest_col_number - 1);

        return ways_to_reach_above_cell + ways_to_reach_left_cell;

    }
}
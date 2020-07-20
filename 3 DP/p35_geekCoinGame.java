
/***
 * 
 * Geek and his friend are playing a coin game. 
 * each coin has value = 1
 * At the beginning there are N coins. Given two numbers X and Y. In each move a player can pick 
 * 1. X coins or
 * 2. Y coins or 
 * 3. 1 coin
 * 
 * Geek always starts the game. 
 * 
 * The player who picks the last coin(s) wins the game. 
 * 
 * For a given value of N, find whether Geek will win the game or not if both are playing optimally.
 * 
 * 
 * ==============
 * example -1
 * ==============
 * total-coins = 5
 * pickups = {1,3,4}
 * 
 * answer = YES , A can win this
 * 
 * A picks 3 coins
 * B picks 1 coin
 * A picks 1 coin at Last
 * 
 * 
 * ==============
 * example -2
 * ==============
 * total-coins = 4
 * pickups = {1,2,3}
 * 
 * 
 * answer = NO , A can NOT win this one
 * 
 * A can pick 1 or 2 or 3 initially
 * B will pick remaining coins at last
 * 
 * 
 * 
 */

/**
 * 
 * 
 * dp-array = 1D
 * array-filling = left to right
 * 
 * table[i] = whether A can win with total-coins = i
 * 
 * logic : for table[i] to be true , atleast 1 of table[i-1] , table[i-num1] , table[i - num2] must be FALSE
 * 
 * ie to win current  , he must have lost atleast 1 previous
 * 
 * 
 * ==========================
 * let total coins = n
 * TC = O(n)
 * sc = O(n)
 * 
 * 
 * 
 */

public class p35_geekCoinGame {
    public static void main(String[] args) {

        int numCoins = 10;
        int NUM_1 = 3;
        int NUM_2 = 4;

        //false
        // int numCoins = 4;
        // int NUM_1 = 2;
        // int NUM_2 = 3;

        boolean answer = calculator(numCoins, NUM_1, NUM_2);
        System.out.println(answer);

    }

    static boolean calculator(int numCoins, int NUM_1, int NUM_2) {
        boolean table[] = new boolean[numCoins + 1];

        table[0] = true;

        for (int coins = 1; coins <= numCoins; coins++) {

            //case in which coins left is = 1 or NUM-1 or NUM-2
            if (coins - 1 == 0 || coins - NUM_1 <= 0 || coins - NUM_2 <= 0) {
                table[coins] = true;
            }

            else if (coins - 1 > 0) {
                table[coins] = table[coins] || (table[coins - 1] == false) ? true : false;
            }

            else if (coins - NUM_1 > 0) {
                table[coins] = table[coins] || (table[coins - NUM_1] == false) ? true : false;
            }

            else if (coins - NUM_2 > 0) {
                table[coins] = table[coins] || (table[coins - NUM_2] == false) ? true : false;
            }

            else {
                table[coins] = false;
            }
        }

        return table[numCoins];
    }
}

import java.util.*;

/**
 *  https://www.geeksforgeeks.org/stock-buy-sell/
 * 
 * 1 transaction = (1 buy + 1 sell) operation
 * 
 * buy should happen before selling
 * 
 */

/**
 * 
 * https://www.youtube.com/watch?v=4YjEHmw1MX0&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=31&ab_channel=Pepcoding
 * 
 * 
 * 
 * maintain min_so_far , 
 * and act each index : profit = arr[i]-min_so_far
 * 
 * check max profit
 * 
 * 
 * 
 * 
 */

class p1_stock_buy_n_sell_only_1_txn {

    public static void main(String[] args) {

        int arr[] = { 100, 180, 260, 310, 40, 535, 695 };
        int profit = Solution.function(arr);
        System.out.println(profit);
    }

}

class Solution {
    static int function(int[] arr) {

        int min_so_far = Integer.MAX_VALUE;
        int max_overall_profit = Integer.MIN_VALUE;

        for (int i : arr) {
            min_so_far = Math.min(min_so_far, i);
            int profit_on_selling_today = i - min_so_far;
            max_overall_profit = Math.max(max_overall_profit, profit_on_selling_today);
        }

        return max_overall_profit;

    }
}
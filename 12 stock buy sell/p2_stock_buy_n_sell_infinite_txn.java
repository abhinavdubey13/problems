import java.util.*;

/**
 *  https://www.geeksforgeeks.org/stock-buy-sell/
 * 
 * 1 transaction = (1 buy + 1 sell) operation
 * 
 * u are allowed any number of transactions , the only condition is :  buy should happen before selling
 * 
 * 
 * ie : only BSBS... this type of tranactions are allowed
 * 
 * BBSS : such overlapping txn not allowed
 * 
 */

/**
 * 
 * 
 * https://www.youtube.com/watch?v=HWJ9kIPpzXs&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=32&ab_channel=Pepcoding
 * 
 * 
 * collect profit at every +ive slope 
 * 
 * 
 * reset indices after collecting profit
 * 
 * (draw grapg and visualize)
 * 
 * 
 * 
 */

class p2_stock_buy_n_sell_infinite_txn {

    public static void main(String[] args) {

        int arr[] = { 10, 20, 15, 20 }; //expected : 15
        int profit = Solution.function(arr);
        System.out.println(profit);
    }

}

class Solution {
    static int function(int[] arr) {

        int overall_profit = 0;

        int n = arr.length;
        int buy_idx = 0;
        int sell_idx = 0;

        for (int i = 1; i < n; i++) {
            int curr = arr[i];
            int prev = arr[i - 1];

            //if today , price is more than yesterday : dont sell as of now 
            if (curr >= prev) {
                sell_idx++;
            } else {

                //collect profit
                overall_profit += arr[sell_idx] - arr[buy_idx];

                //reset the indices
                buy_idx = i;
                sell_idx = i;
            }

        }

        //include last profit
        overall_profit += arr[sell_idx] - arr[buy_idx];
        return overall_profit;

    }
}
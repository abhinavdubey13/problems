/**
 * problem is to check if using the given set(in the form of an array) ,  a given SUM is possible or not
 * 
 */

/**
 * x-axis = set elements
 * y-axis = sum to be formed
 * 
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom
 * 
 * this problem is similar to 0-1 knapsack
 * 
 * TC=(set-size . SUM)
 * SC=(set-size . SUM)
 * 
 */

class p3_subsetSum {

    public static void main(String[] args) {

        //false
        // int sum = 30;
        // int[] setToConsider = new int[] { 3, 34, 4, 12, 5, 2 };

        //true
        int sum = 15;
        int[] setToConsider = new int[] { 1, 3, 4, 11 };

        boolean answer = calulator(sum, setToConsider);
        System.out.println(answer);

    }

    static boolean calulator(int SUM, int setToConsider[]) {
        boolean[][] table = new boolean[setToConsider.length][SUM + 1];

        for (int curr_idx = 0; curr_idx < setToConsider.length; curr_idx++) {
            for (int curr_sum = 0; curr_sum <= SUM; curr_sum++) {

                //init 1st column : sum=0 is always possible
                if (curr_sum == 0) {
                    table[curr_idx][curr_sum] = true;
                    continue;
                }

                boolean without = (curr_idx - 1 >= 0) ? table[curr_idx - 1][curr_sum] : false;

                boolean with = (curr_idx - 1 >= 0 && curr_sum - setToConsider[curr_idx] >= 0)
                        ? table[curr_idx - 1][curr_sum - setToConsider[curr_idx]]
                        : false;

                table[curr_idx][curr_sum] = with || without;
            }
        }

        return table[setToConsider.length - 1][SUM];
    }
}
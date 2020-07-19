//problem is to check if using the given set ,  a given sum is possible or not

/**
 * x-axis = set elements
 * y-axis = sum to be formed
 * 
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom
 * 
 * this problem is similar to 0-1 knapsack
 * 
 */

class p3_subsetSum {

    public static void main(String[] args) {

        int sum = 30;
        int[] setToConsider = new int[] { 3, 34, 4, 12, 5, 2 };
        // int sum = 15;
        // int[] setToConsider = new int[] { 1, 3, 4, 11 };
        boolean answer = calulator(sum, setToConsider);
        System.out.println(answer);

    }

    static boolean calulator(int SUM, int setToConsider[]) {
        boolean[][] table = new boolean[setToConsider.length][SUM + 1];

        for (int currentElementIdx = 0; currentElementIdx < setToConsider.length; currentElementIdx++) {
            for (int sumToBeFormed = 0; sumToBeFormed <= SUM; sumToBeFormed++) {

                if (sumToBeFormed == 0) {
                    table[currentElementIdx][sumToBeFormed] = true;
                    continue;
                }

                if (currentElementIdx > 0 && setToConsider[currentElementIdx] > sumToBeFormed) {
                    table[currentElementIdx][sumToBeFormed] = table[currentElementIdx - 1][sumToBeFormed];
                }

                boolean withoutcurrentElementIdx = (currentElementIdx - 1 >= 0)
                        ? table[currentElementIdx - 1][sumToBeFormed]
                        : false;

                boolean withcurrentElementIdx = (currentElementIdx - 1 >= 0
                        && sumToBeFormed - setToConsider[currentElementIdx] >= 0)
                                ? table[currentElementIdx - 1][sumToBeFormed - setToConsider[currentElementIdx]]
                                : false;

                table[currentElementIdx][sumToBeFormed] = withoutcurrentElementIdx || withcurrentElementIdx;

            }
        }

        return table[setToConsider.length - 1][SUM];
    }
}
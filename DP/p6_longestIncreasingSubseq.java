
//given an array , find length of longest increasing subseq in the array

/**
 * dp-array = 1D
 * array-filling => i= from 1 to n  &&  for each i : j = fom 0  to i-1
 * 
 * init dp array to 1 in each cell , bcz considering only 1 element  , it will be an increasing subseq 
 * 
 * endIdx   : starts from 1 , and goes till last
 * startIdx : starts form 0 , goes till i-1
 * 
 */

class p6_longestIncreasingSubseq {

    public static void main(String[] args) {

        int[] arr = { 3, 4, -1, 0, 6, 2, 3 };
        int answer = calulator(arr);
        System.out.println(answer);

    }

    static int calulator(int[] arr) {
        int[] table = new int[arr.length];
        int max = -1;

        // initialization
        for (int i = 0; i < table.length; i++) {
            table[i] = 1;
        }

        int i = 1;
        int j = 0;
        while (i < table.length) {

            if (i == j) {
                i++;
                j = 0;
                continue;
            }
            if (arr[i] > arr[j]) {
                table[i] = (table[i] > 1 + table[j]) ? table[i] : 1 + table[j];
            }
            j++;
        }

        // using table for finding max
        for (int idx = 0; idx < table.length; idx++) {
            max = (table[idx] > max) ? table[idx] : max;
        }

        return max;
    }
}
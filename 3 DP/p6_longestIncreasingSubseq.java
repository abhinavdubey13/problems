
/**
 * given an int-array , find length of longest increasing subseq in the array
 * 
 * ==========
 * example :
 * ==========
 * arr =  { 3, 4, -1, 0, 6, 2, 3 };
 * 
 * 
 * size of longest-incr-subseq = 4
 * 
 * which is : (-1 , 0 , 2 ,3 )
 * 
 */

/**
 * dp-array = 1D
 * array-filling => i= from 1 to n  &&  for each i : j = fom 0  to i-1
 * 
 * init dp array to 1 in each cell , bcz considering only 1 element  , it will be an increasing subseq 
 * 
 * endIdx   : starts from 1 , and goes till last
 * startIdx : starts form 0 , goes till i-1
 * 
 * ====================
 * TC = O(n^2)
 * SC = O(n)
 * 
 */

class p6_longestIncreasingSubseq {

    public static void main(String[] args) {

        int[] arr = { 3, 4, -1, 0, 6, 2, 3 };
        int answer = calulator(arr);
        System.out.println(answer);

    }

    static int calulator(int[] arr) {

        int n = arr.length;
        int[] table = new int[arr.length];

        // initialization
        for (int i = 0; i < table.length; i++) {
            table[i] = 1;
        }

        //CORE - LOGIC
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    table[i] = Math.max(table[i], 1 + table[j]);
                }
            }
        }

        // using table for finding max
        int answer = -1;
        for (int i = 0; i < table.length; i++) {
            answer = Math.max(answer, table[i]);
        }

        return answer;
    }
}
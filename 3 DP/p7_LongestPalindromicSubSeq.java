
/**
 * given a string , find out the length of longest Palindromic sub seq in it
 * 
 * =========
 * example :
 * =========
 * 
 * str = agbxba
 * 
 * longest palindrom = abxba
 * length = 5
 * 
 * 
 * 
 * ==========================================
 *  NOTE : the approach of considering 
 *   1st : original string
 *   2nd : original string reversed
 *
 *   will NOT WORK , gives wrong answer
 * 
 * 
 */

/**
 * x-axis = start index of subseq
 * y-axis = end index of subseq
 * 
 * dp-array = 2D
 * array-filling = diagonally , considering length of subseq as 1  , then 2 , then 3 ....till length of subseq = length of input string
 * 
 * if str[startIdx]= str[endIdx]
 *      table[startIdx][endIdx] = 2 + table[startIdx+1][endIdx-1] 
 *      ie. 2 + diagonally left cell (2 bcz the matching character increase the length by 2)
 * 
 * else
 *      table[startIdx][endIdx] = MAX (left cell , below cell)    
 *      ie. considering length = (present_length_of_subSeq -1) and checking the lenght of palindrome in those subSeq
 * 
 * 
 * ================================
 * TC = O(n^2)
 * SC = O(n^2)
 * 
 */

class p7_LongestPalindromicSubSeq {

    public static void main(String[] args) {

        // String str = "agbxba"; // expected = 5
        String str = "zaxbbbbaz"; // expected = 8

        int answer = calulator(str);
        System.out.println(answer);
    }

    static int calulator(String str) {
        int[][] table = new int[str.length()][str.length()];

        // init diagonal cells : length of sub-seq = 1
        for (int start_idx = 0; start_idx < str.length(); start_idx++) {
            table[start_idx][start_idx] = 1;
        }

        int n = str.length();
        for (int currentLength = 2; currentLength <= str.length(); currentLength++) {

            for (int start_idx = 0; start_idx + currentLength - 1 < n; start_idx++) {

                int end_idx = start_idx + (currentLength - 1);

                if (str.charAt(start_idx) == str.charAt(end_idx)) {
                    table[start_idx][end_idx] = 2 + table[start_idx + 1][end_idx - 1];
                } else {
                    int a = table[start_idx][end_idx - 1]; //left
                    int b = table[start_idx + 1][end_idx]; //below
                    int c = table[start_idx + 1][end_idx - 1]; //diagonally left below

                    table[start_idx][end_idx] = Math.max(a, Math.max(b, c));
                }

            }
        }

        return table[0][str.length() - 1];
    }
}
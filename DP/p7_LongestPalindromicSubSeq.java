// given a string , find out the length of longest Palindromic sub seq in it

/**
 * x-axis = start index of subseq
 * y-axis = end index of subseq
 * 
 * dp-array = 2D
 * array-filling = diagonally , considering length of subseq as 1  , then 2 , then 3 ....till length of subseq = length of input string
 * 
 * if str[startIdx]= str[endIdx]
 *      table[startIdx][endIdx] = 2 + table[startIdx+1][endIdx-1]      ie. 2 + diagonally left cell (2 bcz the matching character increase the length by 2)
 * 
 * else
 *      table[startIdx][endIdx] = MAX (left cell , below cell)         ie. considering length = (present_length_of_subSeq -1) and checking the lenght of palindrome in those subSeq
 * 
 *  
 * 
 */

class p7_LongestPalindromicSubSeq {

    public static void main(String[] args) {

        String str = "agbxba"; // length = 6
        int answer = calulator(str);
        System.out.println(answer);
    }

    static int calulator(String str) {
        int[][] table = new int[str.length()][str.length()];

        // initialization of diagonal cells
        for (int i = 0; i < str.length(); i++) {
            table[i][i] = 1;
        }

        for (int currentLength = 2; currentLength <= str.length(); currentLength++) {
            int i = 0;
            int j = i + (currentLength - 1);

            while (j < str.length()) {
                if (str.charAt(i) == str.charAt(j)) {
                    table[i][j] = 2 + table[i + 1][j - 1];
                } else {
                    table[i][j] = Math.max(table[i][j - 1], table[i + 1][j]);
                }
                i++;
                j = i + (currentLength - 1);
            }
        }
        return table[0][str.length() - 1];
    }
}
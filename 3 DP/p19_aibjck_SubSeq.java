
import java.util.*;

/**
 * 
 * Given a string, find THE NUMBER OF SUB-SEQ of the form :  aibjck, 
 * 
 * i.e., it consists of i ’a’ characters, followed by j ’b’ characters, followed by k ’c’ characters 
 * where i,j,k >= 1
 * 
 * ==============
 * example :
 * =============
 * 
 * str = abcabc
 * 
 * possiblity : aabc , abbc ,abcc , abc (4 types of abc can be formed )
 * total = 7
 * 
 */

/**
 * dp-array = not req
 * 
 * scan the input array 
 * 
 * if (char[i]==a) , it has 3 choices 
 * `    1. to be part of prev sequence of a's
 *      2. not to be part of prev sequence of a's
 *      3. to form a seperate seq. of a's beginnig from itself
 * 
 * similarly for b and c as well
 * 
 * https://www.geeksforgeeks.org/number-subsequences-form-ai-bj-ck/
 * 
 * =============================================
 * TC = O(n)
 * SC = O(1)
 * 
 */

class p19_aibjck_SubSeq {

    public static void main(String[] args) {
        String input = "abcabc";
        int answer = calulator(input.toCharArray());
        System.out.println(answer);
    }

    static int calulator(char[] input) {
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] == 'a') {
                aCount = 1 + 2 * aCount;
            } else if (input[i] == 'b') {
                bCount = aCount + 2 * bCount;
            } else if (input[i] == 'c') {
                cCount = bCount + 2 * cCount;
            }
        }

        return cCount;

    }
}
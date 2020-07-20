/**
 * given N , representing the length of binary string 
 * 
 * count the total number of strings having NO consecutive 1's
 * 
 * 
 */

/**
 * 
 * DP : 1-d 2 such arrays required
 * 
 * to keep track of string ending with 0 and 1
 * 
 * ===================================
 * TC = O(N)
 * SC = O(N)
 * 
 * 
 * 
 * ==================================
 * EXPLAINATION :
 * 
 * total_string[i] = 2*string_ending_with_0[i-1]  + string_ending_with_1[i-1]
 * 
 * bcz the string which ends and zero and have either 0 or 1 appended to them and till be a valid string (so we multiply by 2)
 * but strings which already end with 1 have no option but to append a ZERO
 * 
 * 
 * string_ending_with_0[i] = string_ending_with_0[i-1]  + string_ending_with_1[i-1]
 * string_ending_with_1[i] = string_ending_with_0[i-1]  
 * 
 * 
 * 2*string_ending_with_0[i-1]  ==> half of these end with 1 and remaining half end with zero
 * 
 * so string_ending_with_0[i-1] is added to string_ending_with_0[i] and string_ending_with_1[i]
 * 
 * 
 */

public class p29_consecutive1NOTAllowed {

    public static void main(String[] args) {

        // int N = 2;
        int N = 3;
        // int N = 4;
        // int N = 5;
        int answer = calculator(N);
        System.out.println(answer);

    }

    static int calculator(int N) {

        int[] stringEndingWith_0 = new int[N + 1];
        int[] stringEndingWith_1 = new int[N + 1];

        //only 1 string which ends with 0 and has len = 1
        //only 1 string which ends with 1 and has len = 1
        stringEndingWith_0[1] = 1;
        stringEndingWith_1[1] = 1;

        for (int length = 2; length <= N; length++) {

            stringEndingWith_0[length] = stringEndingWith_0[length - 1] + stringEndingWith_1[length - 1];

            stringEndingWith_1[length] = stringEndingWith_0[length - 1];
        }

        return stringEndingWith_0[N] + stringEndingWith_1[N];

    }

}
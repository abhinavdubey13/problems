import java.util.*;

/**
 * 
 * 
 * ==========
 * example :
 * ==========
 *
 */

/**
 * ==========
 * APPROACH :
 * ==========
 * 
 * 
 * 
 * 
 * 
 * 
 * TC = O(n)
 * SC = O(n)
 * 
 */

class StringDetail {
    int num0;
    int num1;

    StringDetail() {
        this.num0 = 0;
        this.num1 = 0;
    }

    StringDetail(int n0, int n1) {
        this.num0 = n0;
        this.num1 = n1;
    }
}

public class x3_zeros_and_ones {

    public static void main(String[] args) {

        String[] strs = { "10", "0001", "111001", "1", "0" };

        int max_0 = 5;
        int max_1 = 3;

        int answer = calculator(strs, max_0, max_1);
        System.out.println(answer);
    }

    static boolean calculator(String[] strs , int max_0 , int max_1) {

    }

    static boolean get_str_details(String[] strs) {

    }

}
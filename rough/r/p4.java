import java.util.*;

class p4 {

    public static void main(String[] args) {

        String s = "abcd";

        String rev = Solution.solve(s);
        System.out.println(rev);

    }

}

class Solution {

    static String solve(String str) {
        // Your code goes here

        int n = str.length();

        if (n < 2) {
            return str;
        }

        int i = 0;
        int j = n - 1;

        char[] arr = str.toCharArray();
        while (i < j) {
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }

        return String.valueOf(arr);
    }

}

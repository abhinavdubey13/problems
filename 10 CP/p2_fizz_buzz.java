import java.util.*;

/**
 * 
 * leetcode id : 412
 * 
 * write a program that outputs the string representation of numbers from 1 to n.
 * 
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. 
 * 
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 * 
 */

/**
 * 
 *
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 */

class p2_fizz_buzz {

    public static void main(String[] args) {

        int n = 15;
        List<String> answer = Solution.function(n);
        for (String s : answer) {
            System.out.println(s);
        }

    }

}

class Solution {

    static List<String> function(int n) {

        List<String> ans = new LinkedList<>();

        int mul_3 = 3;
        int mul_5 = 5;

        for (int i = 1; i <= n; i++) {

            StringBuffer s = new StringBuffer("");

            if (i == mul_3) {
                s.append("Fizz");
                mul_3+=3;
            }

            if(i==mul_5){
                s.append("Buzz");
                mul_5+=5; 
            }

            if(s.toString().equals("")){
                s.append(String.valueOf(i));
            }

            ans.add(s.toString());

        }

        return ans;

    }

}
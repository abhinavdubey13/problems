
import java.util.*;


/**
 * 
 * You are given a number N. You have to find the MINIMUM number of operations required to form that number (from 0) .  
 * 
 * You can do only 2 operations :
 * 1. Double the number
 * 2. Add 1 to the number
 * 
 */

/**
 * dp-array = Not required , we follow greedy approach
 * 
 * concept : we go in reverse , ie we form 0 from the number
 * 
 * if current number is even , then half it
 * else subtract 1 form it
 * 
 */



class p17_minOperationToFormNumber {

    public static void main(String[] args) {
        int requiredNum = 8;
        int answer = calulator(requiredNum);
        System.out.println(answer);
    }

    static int calulator(int requiredNum) {
        int operations = 0;

        while (requiredNum != 0) {
            if (requiredNum % 2 == 0) {
                requiredNum /= 2;
            } else {
                requiredNum -= 1;
            }

            operations++;
        }

        return operations;

    }
}
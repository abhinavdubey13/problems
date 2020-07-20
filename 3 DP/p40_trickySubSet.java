
/**
 * =============
 * Problem : 
 * =============
 * N children are made to stand in a queue, where everyone is given a number Ai. 
 * Then the teacher writes a number S on a page and passes it to the first person. 
 * The first person adds all the numbers written on the paper ( for now only S is there ) and adds his number Ai to it and writes on the paper and passes to the second one. 
 * The second one does the same i.e. adds all the numbers on the paper ( S & (S+Ai) ) and adds his own number and passes it to next, and the process continues.
 * 
 * 
 * Given this series of numbers you have to determine whether a number X can be formed by adding some of the numbers from the given series or not. 
 *
 * ===========
 * Example : 
 * ===========
 * S=1 
 * number of students = 4 
 * target-value = 7
 * 
 * A[] = {1, 2, 4, 2}
 * 
 * 
 * sequence formed when all students write out = {1, 2, 5, 12, 22}
 * from this seq. we can form 7
 * =================================================
 * ANSWER = YES
 * =================================================
 * 
 */

/**
 * ===========
 * APPROACH :
 * ===========
 * 
 * dp :
 * 
 * step1 : 
 * step2 : 
 * step3 : 
 * 
 *
 * 
 */

import java.util.ArrayList;
import java.util.Collections;

public class p40_trickySubSet {
    public static void main(String[] args) {

        int initValue = 1;
        int[] studentsArr = { 1, 2, 4, 2 };
        int targetSum = 7;

        // int initValue = 100;
        // int[] studentsArr = { 51, 88 };
        // int targetSum = 500;

        boolean answer = calculator(initValue, studentsArr, targetSum);
        System.out.println(answer);

    }

    static boolean calculator(int initValue, int[] studentsArr, int targetSum) {

        int[] sequenceFormed = new int[studentsArr.length + 1];
        sequenceFormed[0] = initValue;
        int sumAtPresent = initValue;

        for (int i = 0; i < studentsArr.length; i++) {
            sequenceFormed[i + 1] = sumAtPresent + studentsArr[i];
            sumAtPresent += sequenceFormed[i + 1];
        }

        return checkSubsetSum(sequenceFormed, targetSum);
    }

    static boolean checkSubsetSum(int[] setInput, int targetSum) {
        boolean table[][] = new boolean[setInput.length + 1][targetSum + 1];

        // init first column 
        for (int i = 0; i <= setInput.length; i++) {
            table[i][0] = true;
        }

        // init first row 
        for (int i = 1; i <= targetSum; i++) {
            table[0][i] = false;
        }

        for (int i = 1; i <= setInput.length; i++) {
            for (int j = 1; j <= targetSum; j++) {

                boolean without_this_element = table[i - 1][j];
                boolean with_this_element = (j - setInput[i - 1] >= 0) ? table[i - 1][j - setInput[i - 1]] : false;

                table[i][j] = with_this_element || without_this_element;
            }
        }

        return table[setInput.length][targetSum];

    }

}
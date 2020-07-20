
/***
 * 
 * There are N stairs, and a person standing at the bottom wants to reach the top. 
 * The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top (order does not matter).
 * 
 * Note: Order does not matter means for n=4 {1 2 1},{2 1 1},{1 1 2} are considered same.
 * 
 */

/**
 * 
 * dp NOT required 
 * 
 * for logic behind the solution : https://stackoverflow.com/questions/62871148/count-ways-to-nth-stairorder-does-not-matter
 * 
 */

public class p37_countWaysToNthStaiOrderDoesNotMatter {
    public static void main(String[] args) {

        // int numberOfStarirs = 4;

        int numberOfStarirs = 6;

        int answer = calculator(numberOfStarirs);
        System.out.println(answer);

    }

    static int calculator(int numberOfStarirs) {
        return numberOfStarirs / 2 + 1;

    }
}
import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/sum-of-all-numbers-formed-having-4-atmost-x-times-5-atmost-y-times-and-6-atmost-z-times/
 * 
 * 
 * 
 * ============
 * example : 1
 * ============
 * 
 *
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 *
 * 
 * 
 * ===========
 * TC=O(n1.n2)
 * SC=O(n1.n2)
 * 
 * 
 * 
 */

class p54_number_formation_using_4_5_6 {

    public static void main(String[] args) {

        int x = 0;
        int y = 1;
        int z = 1;

        int answer = function_util(x, y, z);
        // System.out.println(answer);
    }

    static int function_util(int x, int y, int z) {

        Set<String> answer = new HashSet<>();

        List<String> nums = function(x, y, z, answer);

        answer.addAll(nums);

        for (String s : answer) {
            System.out.println(Integer.parseInt(s)-1);
        }

        return -1;
    }

    static List<String> function(int x, int y, int z, Set<String> answer) {
        if (x == 0 && y == 0 && z == 0) {
            List<String> str = new ArrayList<String>();
            str.add("");
            return str;
        }

        else if (x == 1 && y == 0 && z == 0) {
            List<String> str = new ArrayList<String>();
            str.add("4");
            return str;
        }

        else if (x == 0 && y == 1 && z == 0) {
            List<String> str = new ArrayList<String>();
            str.add("5");
            return str;
        }

        else if (x == 0 && y == 0 && z == 1) {
            List<String> str = new ArrayList<String>();
            str.add("6");
            return str;
        }

        List<String> nums = new ArrayList<>();
        if (x > 0) {
            List<String> rcvd = function(x - 1, y, z, answer);
            answer.addAll(rcvd);
            for (String r : rcvd) {
                nums.add("4" + r);
            }
        }

        if (y > 0) {
            List<String> rcvd = function(x, y - 1, z, answer);
            answer.addAll(rcvd);
            for (String r : rcvd) {
                nums.add("5" + r);
            }
        }

        if (z > 0) {
            List<String> rcvd = function(x, y, z - 1, answer);
            answer.addAll(rcvd);
            for (String r : rcvd) {
                nums.add("6" + r);
            }
        }

        return nums;
    }

}

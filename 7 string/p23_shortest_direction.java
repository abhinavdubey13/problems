import java.util.*;

/**
 * leetcode id : 
 * 
 * 
 * A person wants to go from origin to a particular location
 * 
 * he can move in only 4 directions(i.e East, West, North, South) but his friend gave him a long route, 
 * 
 * help him to find minimum Moves so that he can reach to the destination.
 * Note: You need to print the lexicographically sorted string. Assume the string will have only ‘E’ ‘N’ ‘S’ ‘W’ characters.
 * 
 *  
 * =========
 * example 
 * =========
 * i/p : SSSNEEEW
 * o/p : EESS
 * 
 * i/p : NESNWES
 * o/p : E
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
 * we maitain (x,y)  
 * 
 * get final (x,y) and the find the lexicographic string
 * 
 * 
 * ===========
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class p23_shortest_direction {

    public static void main(String[] args) {

        // String input = "SSSNEEEW"; //expected = EESS
        String input = "NESNWES"; //expected = E

        String answer = function(input);
        System.out.println(answer);
    }

    static String function(String input) {

        char[] arr = input.toCharArray();

        int x = 0;
        int y = 0;

        for (char c : arr) {
            if (c == 'N') {
                y += 1;
            } else if (c == 'E') {
                x += 1;
            } else if (c == 'S') {
                y -= 1;
            } else if (c == 'W') {
                x -= 1;
            }
        }

        // System.out.println(x + " " + y);
        StringBuffer answer = new StringBuffer();

        if (x > 0) {
            while (x != 0) {
                answer.append('E');
                x--;
            }
        }
        if (y > 0) {
            while (y != 0) {
                answer.append('N');
                y--;
            }

        }
        if (y < 0) {
            while (y != 0) {
                answer.append('S');
                y++;
            }

        }
        if (x < 0) {
            while (x != 0) {
                answer.append('W');
                x++;
            }

        }

        return answer.toString();
    }

}

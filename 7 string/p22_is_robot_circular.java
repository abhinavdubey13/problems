import java.util.*;

/**
 * leetcode id : 
 * 
 * 
 * Given a sequence of moves for a robot, check if the sequence is circular or not. A sequence of moves is circular if first and last positions of robot are same. A move can be on of the following.
 * G - Go one unit
 * L - Turn left (just turn , dont move)
 * R - Turn right  (just turn , dont move)
 * 
 *  
 * =========
 * example 
 * =========
 * i/p : GLGLGLG
 * o/p : circular
 * 
 * i/p : GLLG
 * o/p : circular
 * 
 * i/p : GGGL
 * o/p : not circular
 * 
 *  
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * we maitain a direction map 
 * 
 * when we encounter 'G' : we move wrt current direction
 * when we encounter 'L' or 'R' :  we change current direction
 * 
 * ================================
 * MAP notations : we have 8 cases
 * ================================
 * direction_map.put("0+L", "-0");
 * 
 * key : 0+L : means 
 *      current x = 0 (0 means we need not move in this direction when G comes)
 *      current y = +
 *      we encountered = L
 * 
 * so for this , our changed direction will be
 *      current x = -
 *      current y = 0
 * 
 * ============
 * TC = O(n)
 * SC = O(k)
 * 
 * 
 * 
 */

class Cordinates {
    int x;
    int y;

    Cordinates() {
        this.x = 0;
        this.y = 0;
    }

    Cordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class p22_is_robot_circular {

    public static void main(String[] args) {
        // String input = "GLGLGLG"; //expected = cricular
        // String input = "GLLG"; //expected = cricular
        String input = "GGGGL"; //expected = not cricular

        String answer = function(input);
        System.out.println(answer);
    }

    static String function(String input) {

        char[] arr = input.toCharArray();

        Map<String, String> direction_map = new HashMap<>();
        direction_map.put("0+L", "-0");
        direction_map.put("0+R", "+0");

        direction_map.put("0-L", "+0");
        direction_map.put("0-R", "-0");

        direction_map.put("+0L", "0+");
        direction_map.put("+0R", "0-");

        direction_map.put("-0L", "0-");
        direction_map.put("-0R", "0+");

        char curr_x = '0';
        char curr_y = '+';

        Cordinates curr_cord = new Cordinates(0, 0);

        for (char c : arr) {

            if (c == 'G') {

                switch (curr_x) {
                    case '0':
                        break;

                    case '+':
                        curr_cord.x += 1;
                        break;

                    case '-':
                        curr_cord.x -= 1;
                        break;
                }

                switch (curr_y) {
                    case '0':
                        break;

                    case '+':
                        curr_cord.y += 1;
                        break;

                    case '-':
                        curr_cord.y -= 1;
                        break;
                }

            }

            else if (c == 'L') {
                StringBuffer key = new StringBuffer();
                key.append(curr_x);
                key.append(curr_y);
                key.append('L');

                String value = direction_map.get(key.toString());
                curr_x = value.charAt(0);
                curr_y = value.charAt(1);
            }

            else if (c == 'R') {
                StringBuffer key = new StringBuffer();
                key.append(curr_x);
                key.append(curr_y);
                key.append('R');

                String value = direction_map.get(key.toString());
                curr_x = value.charAt(0);
                curr_y = value.charAt(1);
            }
        }

        if (curr_cord.x == 0 && curr_cord.y == 0) {
            return "circular";
        } else {
            return "NOT circular";
        }

    }

}

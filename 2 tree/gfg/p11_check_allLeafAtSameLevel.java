
import java.util.*;

/**
 * Given a Binary Tree, check if all leaves are at same level or not.
 */

/**
* approach : recursively check the level of all leaf nodes , and add the same to a set 
* if at last , set has only 1 entry : all leaf at same level  
* else : not at same level
* 
* TC - O(n)
* SC - O(height) 
*/

class p11_check_allLeafAtSameLevel extends HELPER {

    public static void main(String[] args) {

        //true
        ROOT = new node(10);
        ROOT.left = new node(8);
        ROOT.right = new node(2);
        ROOT.left.left = new node(3);
        ROOT.right.left = new node(3);
        ROOT.right.right = new node(15);

        //false
        // ROOT = new node(10);
        // ROOT.left = new node(8);
        // ROOT.right = new node(2);
        // ROOT.right.left = new node(3);
        // ROOT.right.right = new node(15);

        Set<Integer> set_of_ht = new HashSet<Integer>();
        int initLevel = 1;

        function(ROOT, set_of_ht, initLevel);

        if (set_of_ht.size() == 1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    static void function(node curretNode, Set set_of_ht, int level) {

        if (curretNode == null) {
            return;
        }

        if (isLeaf(curretNode)) {
            set_of_ht.add(level);
            return;
        }

        function(curretNode.left, set_of_ht, level + 1);
        function(curretNode.right, set_of_ht, level + 1);
    }

}
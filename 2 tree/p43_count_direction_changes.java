import java.util.*;

/**
 * 
 * given a binary tree , we have to find the number of direction changes required to get to a target-node from source-node
 * 
 * note : target-node must be in the LST or RST of source-node
 *  
 */

/**
 * 
 *
 * using recursion  
 * 
 * =================================
 * let total nodes in trees = n , m
 * 
 * TC = O(n)
 * SC = O(ht)
 *
 */

class HelpObj {
    boolean isFound;
    int turns;

    HelpObj() {
        isFound = false;
        turns = 0;
    }
}

class p43_count_direction_changes extends HELPER {

    public static void main(String[] args) {

        //left tree
        node ROOT = new node(1);
        ROOT.left = new node(2);
        ROOT.left.right = new node(5);
        ROOT.left.left = new node(4);
        ROOT.left.left.left = new node(8);

        ROOT.right = new node(3);
        ROOT.right.left = new node(6);
        ROOT.right.right = new node(7);
        ROOT.right.left.left = new node(9);
        ROOT.right.left.right = new node(10);

        node source;
        node target;

        source = ROOT;
        target = ROOT.right.left.right;

        // source = ROOT.right.left;
        // target = new node(78);//ROOT.right.left.right;

        function(source, target);
    }

    static void function(node source, node target) {

        HelpObj left = count_turns(source.left, target, "left", 0);
        HelpObj right = count_turns(source.right, target, "right", 0);

        if (left.isFound) {
            System.out.println("turns req = " + left.turns);
        } else if (right.isFound) {
            System.out.println("turns req = " + right.turns);
        } else {
            System.out.println(target.data + " is not in tree");
        }

    }

    static HelpObj count_turns(node current, node target, String curr_direction, int curr_turns) {

        HelpObj result = new HelpObj();

        if (current == null || target == null) {
            result.isFound = false;
            result.turns = 0;
            return result;
        }

        if (current == target) {
            result.isFound = true;
            result.turns = curr_turns;
            return result;
        }

        HelpObj left = null;
        HelpObj right = null;

        if (curr_direction == "left") {
            left = count_turns(current.left, target, "left", curr_turns);
            right = count_turns(current.right, target, "right", curr_turns + 1);
        } else if (curr_direction == "right") {
            left = count_turns(current.left, target, "left", curr_turns + 1);
            right = count_turns(current.right, target, "right", curr_turns);
        }

        if (left.isFound) {
            result = left;
        } else if (right.isFound) {
            result = right;
        } else {
            result.isFound = false;
            result.turns = 0;
        }

        return result;
    }

}
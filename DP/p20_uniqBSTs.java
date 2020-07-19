
//given number of nodes in tress , find number of BSTs possible
//BST property : inorder traversal , gives ascending order of node values

/**
 * concept : count the possible structure possible with n-nodes  , each structure will have only 1 BST possible 
 * concept : catalyn numbers
 * 
 * 
 * for nodes >=2 , do the following
 *  1. we make 1 node as the root node and 
 *  2. for remaining n-1 nodes , we distribute into left-sub-tree(LST) and RST (beginning with 0 nodes in LST and remaining in RST)
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;

class p20_uniqBSTs {

    public static void main(String[] args) {
        int numNodes = 5;
        int answer = calulator(numNodes);
        System.out.println(answer);
    }

    static int calulator(int numNodes) {
        int[] table = new int[numNodes + 1];
        table[0] = 1;
        table[1] = 1;

        for (int nodes = 2; nodes <= numNodes; nodes++) {
            for (int nodesOnLeft = 0; nodesOnLeft < nodes; nodesOnLeft++) {
                int nodesOnRight = nodes - nodesOnLeft - 1;
                table[nodes] += table[nodesOnLeft] * table[nodesOnRight];
            }
        }

        return table[numNodes];

    }
}
import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/
 * 
 * given root of a Tree  : T
 * and root of potential sub tree : S
 * 
 * check if S is subtree of T
 *
 * 
 * ==========
 * example :
 * ==========
 * 
 * i/p : 
 * o/p : 
 * 
 */

/**
 * ============
 * approach : 1
 * ============
 * 
 * using the fact (inorder+preorder) makes a tree uniq
 * 
 * check if preoder and inorder of S is a substring of T
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

public class p64_check_if_one_tree_is_subtree_of_another extends HELPER {

  public static void main(String[] args) {

    //potential sub-tree 
    node S;
    S = new node(1);
    S.left = new node(2);
    S.left.right = new node(4);
    S.right = new node(3);


    //potential super-tree
    node T;
    T = new node(5);
    T.left = new node(1);
    T.left.left = new node(2);
    T.left.left.right = new node(4);
    T.left.right = new node(3);
    T.right = new node(6);
    T.right.right = new node(7);


    System.out.println(function(T, S));


  }

  static boolean function(node T, node S) {

    StringBuffer inorder_T = new StringBuffer();
    StringBuffer inorder_S = new StringBuffer();

    StringBuffer preorder_T = new StringBuffer();
    StringBuffer preorder_S = new StringBuffer();

    get_inorder(T, inorder_T);
    get_inorder(S, inorder_S);

    get_preorder(T, preorder_T);
    get_preorder(S, preorder_S);

    boolean condition_1 = inorder_T.toString().contains(inorder_S.toString());
    boolean condition_2 = preorder_T.toString().contains(preorder_S.toString());

    return condition_1 && condition_2;
  }

  static void get_inorder(node curr, StringBuffer inorder) {
    if (curr == null) {
      return;
    }
    

    get_inorder(curr.left, inorder);
    inorder.append(curr.data);
    get_inorder(curr.right, inorder);
  }

  static void get_preorder(node curr, StringBuffer preoder) {
    if (curr == null) {
      return;
    }

    preoder.append(curr.data);
    get_preorder(curr.left, preoder);
    get_preorder(curr.right, preoder);
  }

}
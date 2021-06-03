import java.util.*;

/**
 *
 * https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
 * 
 * Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.
 * 
 * 
 */

/**
 * 
 * The idea is to create a graph of characters and then find topological sorting of the created graph. Following are the detailed steps.
 * 
 * 1) Create a graph g with number of vertices equal to the size of alphabet in the given alien language. 
 * For example, if the alphabet size is 5, then there can be 5 characters in words. 
 * Initially there are no edges in graph.
 * 
 * 2) Do following for every pair of adjacent words in given sorted array. 
 * a) Let the current pair of words be word1 and word2. 
 * One by one compare characters of both words and find the first mismatching characters. 
 * b) Create an edge in g from mismatching character of word1 to that of word2.
 * 
 * 3) Print topological sorting of the above created graph.
 * 
 * 
 * 
 * 
 * NOTE:
 * The above code doesn’t work when the input is not valid. 
 * For example {“aba”, “bba”, “aaa”} is not valid, because from first two words, 
 * we can deduce ‘a’ should appear before ‘b’, 
 * but from last two words, we can deduce ‘b’ should appear before ‘a’ which is not possible. 
 * Extend the above program to handle invalid inputs and generate the output as “Not valid”.
 * 
 * 
 *
 */

class x47_alien_dictinary {

    public static void main(String[] args) {

    }

}

class Solution {

    boolean function(int[] arr, int m) {
        return false;

    }

}
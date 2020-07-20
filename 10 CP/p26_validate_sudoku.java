import java.util.*;

/**
 * 
 * leetcode id : 36
 * 
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

 Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 *  
 */

/**
 * 
 * 
 * using hashing and hashsets/hashmaps
 * 
 * TC = 
 * SC = 
 * 
 */

class p26_validate_sudoku {

    public static void main(String[] args) {

        //expected : true
        // char[][] arr = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
        //         { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
        //         { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
        //         { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
        //         { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        //expected : false
        char[][] arr = { { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
                { '.', '4', '.', '3', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
                { '8', '.', '.', '.', '.', '.', '.', '2', '.' }, { '.', '.', '2', '.', '7', '.', '.', '.', '.' },
                { '.', '1', '5', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
                { '.', '2', '.', '9', '.', '.', '.', '.', '.' }, { '.', '.', '4', '.', '.', '.', '.', '.', '.' } };

        //print board
        // for (int i = 0; i < 9; i++) {
        //     for (int j = 0; j < 9; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        boolean answer = new Solution().function(arr);
        System.out.println(answer);
    }

}

class Solution {

    boolean function(char[][] arr) {

        Map<Integer, Set<Character>> row_map = new HashMap<>();
        Map<Integer, Set<Character>> col_map = new HashMap<>();
        Map<String, Set<Character>> sq_map = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            row_map.put(i, new HashSet<>());
            col_map.put(i, new HashSet<>());
        }

        sq_map.put("00", new HashSet<>());
        sq_map.put("01", new HashSet<>());
        sq_map.put("02", new HashSet<>());
        sq_map.put("10", new HashSet<>());
        sq_map.put("11", new HashSet<>());
        sq_map.put("12", new HashSet<>());
        sq_map.put("20", new HashSet<>());
        sq_map.put("21", new HashSet<>());
        sq_map.put("22", new HashSet<>());

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                char curr = arr[i][j];

                if (curr == '.') {
                    continue;
                }

                int si = i / 3;
                int sj = j / 3;
                String key = si + "" + sj;

                if (row_map.get(i).contains(curr) || col_map.get(j).contains(curr) || sq_map.get(key).contains(curr)) {
                    return false;
                }

                row_map.get(i).add(curr);
                col_map.get(j).add(curr);
                sq_map.get(key).add(curr);

            }
        }

        return true;

    }

}

class Solution_optimat {

    boolean function(char[][] arr) {

        Set<String> my_set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                char curr = arr[i][j];

                if (curr == '.') {
                    continue;
                }

                String row_code = "r" + i + curr;
                String col_code = "c" + j + curr;
                String box_code = "b" + (i / 3) + (j / 3) + curr;

                if (my_set.contains(row_code) || my_set.contains(col_code) || my_set.contains(box_code)) {
                    return false;
                }
                my_set.add(row_code);
                my_set.add(col_code);
                my_set.add(box_code);
            }
        }

        return true;

    }

}

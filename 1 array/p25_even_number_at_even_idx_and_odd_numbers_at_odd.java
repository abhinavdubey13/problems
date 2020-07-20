
/**
 * 
 * Given an array of size n containing equal number of odd and even numbers. 
 * The problem is to arrange the numbers in such a way that all the even numbers get the even index and odd numbers get the odd index. 
 * 
 * 
 * https://www.geeksforgeeks.org/even-numbers-even-index-odd-numbers-odd-index/
 * 
 * =========
 * example : 
 * =========
 * 
 * i/p : 3, 6, 12, 1, 5, 8
 * o/p : 6, 3, 12, 1, 8, 5
 * 
 */

/**
 * ===========
 * approach :
 * ===========
 * 
 * use 2 index-pointers , one for odd-indices , other for even
 * swap when we find odd number at even idx AND even number at odd index
 * 
 * 1. search an index which is even , but has odd value
 * 2. search an index which is odd , but has even value
 * 3. swap the 2 values
 * 4. if at any point , odd_idx or even_idx fall out of array , break
 * 
 * TC= O(n)
 * SC= O(1)
 * 
 */

class p25_even_number_at_even_idx_and_odd_numbers_at_odd {

    public static void main(String[] args) {
        int arr[] = { 3, 6, 12, 1, 5, 8 };

        function(arr);

        //printing
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void function(int arr[]) {

        int n = arr.length;
        int even_idx = 0;
        int odd_idx = 1;

        while (true) {

            // 1. search an index which is even , but has odd value
            while (even_idx < n && arr[even_idx] % 2 == 0) {
                even_idx += 2;
            }

            // 2. search an index which is even , but has odd value
            while (odd_idx < n && arr[odd_idx] % 2 == 1) {
                odd_idx += 2;
            }

            //if 2 pointers still in array
            if (even_idx < n && odd_idx < n) {
                int temp = arr[even_idx];
                arr[even_idx] = arr[odd_idx];
                arr[odd_idx] = temp;
            }

            //if atleast 1 idx >= n
            else {
                break;
            }

        }

    }

}
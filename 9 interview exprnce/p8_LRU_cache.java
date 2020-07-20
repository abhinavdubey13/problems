import java.util.*;

/**
 * 
 *
 * 
 */

/**
 * 
 * 
 * 
 * 
 * 
 */

class p8_LRU_cache {

    public static void main(String[] args) {

        // test case : 1
        // LRUCache cache = new LRUCache(2);
        // System.out.print(cache.get(2)); //expected : -1
        // cache.put(2, 6);
        // System.out.print(cache.get(1)); //expected : -1
        // cache.put(1, 5);
        // cache.put(1, 2);
        // System.out.print(cache.get(1)); //expected : 2
        // System.out.print(cache.get(2)); //expected : 6

        //test case : 2
        // LRUCache cache = new LRUCache(2);
        // cache.put(1, 1);
        // cache.put(2, 2);
        // System.out.print(cache.get(1)); //expected : 1
        // cache.put(3, 3);
        // System.out.print(cache.get(2)); //expected : -1
        // cache.put(4, 4);
        // System.out.print(cache.get(1)); //expected : -1
        // System.out.print(cache.get(3)); //expected : 3
        // System.out.print(cache.get(4)); //expected : 4

        /**
         * ["LRUCache",
        "put","put","put","put","put", : [10,13],[3,17],[6,11],[10,5],[9,10]
        "get","put","get","get","put", : [13],[2,19],[2],[3],[5,25]
        "get","put","put","put","get", : [8],[9,22],[5,5],[1,30],[11]
        "put","get","get","get","get", : [9,12],[7],[5],[8],[9]
        
        "put","put","get","get","get", : [4,30],[9,3],[9],[10],[10]
        "put","put","get","put","get", : [6,14],[3,1],[3],[10,11],[8]
        "put","get","get","get","put", : [2,14],[1],[5],[4],[11,4]
        "put","put","get","put","get", : [12,24],[5,18],[13],[7,23],[8]
        "get","put","put","get","put", : [12],[3,27],[2,12],[5],[2,9]
        "put","put","put","get","put", : [13,4],[8,18],[1,7],[6],[9,29],
        "put","get","put","put","get", : [8,21],[5],[6,30],[1,12],[10]
        "put","put","put","put","put", : [4,15],[7,22],[11,26],[8,17],[9,29]
        "get","put","put","get","put", : [5],[3,4],[11,30],[12],[4,29]
        "get","get","get","put","get", : [3],[9],[6],[3,4],[1]
        "get","put","put","put","put", : [10],[3,29],[10,28],[1,20],[11,13]
        "get","put","put","put","put", : [3],[3,12],[3,8],[10,9],[3,26]
        "get","get","get","put","put", : [8],[7],[5],[13,17],[2,27]
        "put","get","put","put","put", : [11,15],[12],[9,19],[2,15],[3,16]
        "get","put","put","put","get", : [1],[12,17],[9,1],[6,19],[4]
        "get","get","put","put","put", : [5],[5],[8,1],[11,7],[5,2]
        "put","get","put","put","put", : [9,28],[1],[2,2],[7,4],[4,22]
        "put","put","put","put"]       : [7,24],[9,26],[13,28],[11,26]]
        
         */

        //expected 
        //-1,19,17,-1,-1,-1,5,-1,12,3,5,5,1,-1,30,5,30,-1,-1,24,18,-1,18,-1,18,-1,4,29,30,12,-1,29,17,22,18,-1,20,-1,18,18,20

        //actual 
        //-1,19,17,-1,-1,-1,5,-1,12,3,-1,-1,1,-1,30,5,30,-1,-1,24,18,-1,18,-1,-1,-1,4,29,30,12,-1,29,17,22,-1,-1,20,-1,-1,-1,20

        // test case : 3
        LRUCache cache = new LRUCache(10);

        cache.put(10, 13);
        cache.put(3, 17);
        cache.put(6, 11);
        cache.put(10, 5);
        cache.put(9, 10);

        System.out.print(cache.get(13) + " "); //expected : 1
        cache.put(2, 19);
        System.out.print(cache.get(2) + " "); //expected : -1
        System.out.print(cache.get(3) + " "); //expected : -1
        cache.put(5, 25);

        System.out.print(cache.get(8) + " "); //expected : -1
        cache.put(9, 22);
        cache.put(5, 5);
        cache.put(1, 30);
        System.out.print(cache.get(11) + " "); //expected : 3

        cache.put(9, 12);
        System.out.print(cache.get(7) + " "); //expected : -1
        System.out.print(cache.get(5) + " "); //expected : -1
        System.out.print(cache.get(8) + " "); //expected : -1
        System.out.print(cache.get(9) + " "); //expected : 3

        cache.put(4, 30);
        cache.put(9, 3);
        System.out.print(cache.get(9) + " "); //expected : -1
        System.out.print(cache.get(10) + " "); //expected : -1
        System.out.print(cache.get(10) + " "); //expected : 3

        System.out.println();

    }

}

class LRUCache {

    private Deque<Integer> dq;

    private HashMap<Integer, Integer> hmap;

    private int CACHE_SIZE;

    LRUCache(int cache_capacity) {
        CACHE_SIZE = cache_capacity;
        dq = new LinkedList<>();
        hmap = new HashMap<>();
    }

    // This method works in O(1)
    public int get(int key) {

        if (hmap.get(key) != null) {
            dq.remove(key);
            dq.offerLast(key);
            return hmap.get(key);
        } else {
            return -1;
        }

    }

    // This method works in O(1)
    public void put(int key, int value) {

        //if previously existing key is re-put again : no need to check overflow here
        if (hmap.containsKey(key)) {
            hmap.put(key, value);
            dq.remove(key);
            dq.offerLast(key);

        }

        //if new key is coming
        else {
            //if overflow
            if (dq.size() == CACHE_SIZE) {
                int removed = dq.pollFirst();
                hmap.remove(removed);
                hmap.put(key, value);
                dq.offerLast(key);

            }

            //cache has empty slot left
            else {
                hmap.put(key, value);
                dq.offerLast(key);
            }

        }

    }

}
import java.util.*;

/**
 * 
 * 
 * 
 */

class xyz {

    public static void main(String[] args) {

        LRU<String> cache = new LRU(5);

        cache.add(1, "1");
        cache.add(2, "2");
        cache.add(3, "3");
        

        System.out.println(cache.get(4));
        System.out.println(cache.get(3));

    }

}

class LRU<T> {

    int SIZE;
    Map<Integer, T> hmap;
    LinkedHashSet<Integer> q;

    LRU(int n) {
        this.SIZE = n;
        hmap = new HashMap<>();
        q = new LinkedHashSet<>();
    }

    void add(int key, T val) {
        if (q.size() == SIZE) {
            // int removed = q. (removed);
            Iterator it = q.iterator();
            Integer removed = (Integer)it.next();
            hmap.remove(removed);

        }

        hmap.put(key, val);
        q.add(key);
    }

    T get(int key) {
        if (q.contains(key)) {
            T value = hmap.get(key);
            q.remove(key);
            q.add(key);
            return value;

        } else {
            return null;
        }

    }

}

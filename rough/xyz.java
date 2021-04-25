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
        cache.add(4, "4");
        cache.add(5, "5");

        System.out.println(cache.get(1));

        cache.add(6, "6");

        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        System.out.println(cache.get(4));

        cache.add(6, "new 6");

        System.out.println(cache.get(6));
        System.out.println(cache.get(3));

    }

}

interface Cache<T> {

    void add(int key, T val);

    T get(int key);

}

class LRU<T> implements Cache {

    int SIZE;
    Map<Integer, T> hmap;
    LinkedHashSet<Integer> q;

    LRU(int n) {
        this.SIZE = n;
        hmap = new HashMap<>();
        q = new LinkedHashSet<>();
    }

    void add(int key, T val) {

        if (hmap.containsKey(key)) {
            hmap.put(key, val);
            q.remove(key);
            q.add(key);
        }

        else if (q.size() == SIZE) {
            Iterator it = q.iterator();
            Integer removed = (Integer) it.next();
            hmap.remove(removed);
            q.remove(removed);
        }

        hmap.put(key, val);
        q.add(key);
    }

    public T get(int key) {
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

class LIFO<T> implements Cache {

    int SIZE;
    Map<Integer, T> hmap;
    LinkedHashSet<Integer> q;

    LRU(int n) {
        this.SIZE = n;
        hmap = new HashMap<>();
        q = new LinkedHashSet<>();
    }

    void add(int key, T val) {

        if (hmap.containsKey(key)) {
            hmap.put(key, val);
            q.remove(key);
            q.add(key);
        }

        else if (q.size() == SIZE) {
            Iterator it = q.iterator();
            Integer removed = (Integer) it.next();
            hmap.remove(removed);
            q.remove(removed);
        }

        hmap.put(key, val);
        q.add(key);
    }

    public T get(int key) {
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

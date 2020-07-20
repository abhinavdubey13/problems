import java.util.*;

/**
 * 
 * https://www.youtube.com/watch?v=wU6udHRIkcc&ab_channel=AbdulBari
 * 
 * https://www.youtube.com/watch?v=kaBX2s3pYO4&ab_channel=TECHDOSE
 * 
 * 
 * why do we change ranks only if unioning 2 trees of same height
 * https://stackoverflow.com/questions/18081539/disjoint-set-forests-why-should-the-rank-be-increased-by-one-when-the-find-of#:~:text=Why%20almost%3F,than%20indicated%20by%20its%20rank.
 * 
 * bcz rank is basically the height and not the size of the tree
 * 
 * We want to keep trees short, so keeping track of the height of every tree helps us do that. 
 * When unioning two trees of different height, we make the root of the shorter tree a child of the root of the taller tree. 
 * Importantly, this does not change the height of the taller tree. That is, the rank of the taller tree does not change.
 * 
 * However, when unioning two trees of the same height, we make one root the child of the other, 
 * and this increases the height of that overall tree by one, so we increase the rank of that root by one.
 * 
 * 
 * 
 */

class DSU {

    public static void main(String[] args) {

        int n = 5;//number of nodes = 5 : 0,1,2,3,4
        DSU_implementation dsu = new DSU_implementation(n);

        //union node 0,2 : ie. they belong to same component
        dsu.union(0, 2);

        //union node 4,2 : ie. they belong to same component
        dsu.union(4, 2);

        //union node 3,1 : ie. they belong to same component
        dsu.union(3, 1);

        if (dsu.find(4) == dsu.find(0)) {
            System.out.println("same component");
        } else {
            System.out.println("different component");
        }

        if (dsu.find(1) == dsu.find(0)) {
            System.out.println("same component");
        } else {
            System.out.println("different component");
        }

    }

}

class DSU_implementation {

    int[] rank;
    int[] parent;
    int n;

    DSU_implementation(int n) {
        this.n = n;
        this.rank = new int[n];
        this.parent = new int[n];
        initialize();
    }

    void initialize() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0; //height is 0 initially
        }
    }

    int find(int x) {
        if (parent[x] == x) {
            return parent[x];
        } else {
            int far_parent = find(parent[x]);
            parent[x] = far_parent;
            return parent[x];
        }
    }

    //return true if union possible : x,y belong to different sets
    //if x,y are in same set already : return false
    boolean union(int x, int y) {

        int px = find(x);
        int py = find(y);

        if (px == py) {
            return false;
        }

        if (rank[py] < rank[py]) {
            parent[py] = px;
        } else if (rank[px] < rank[py]) {
            parent[px] = py;
        } else {
            parent[py] = px; //or we can do the other way also
            rank[px]++; //rank only increases if rank were equal
        }

        return true;

    }

}

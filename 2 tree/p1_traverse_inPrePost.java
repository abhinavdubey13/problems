
class p1_traverse_inPrePost extends HELPER {

    static void inOrderTrav(node n) {
        if (n != null) {
            inOrderTrav(n.left);
            System.out.print(n.data + " ");
            inOrderTrav(n.right);
        }
    }

    static void preOrderTrav(node n) {
        if (n != null) {
            System.out.print(n.data + " ");
            preOrderTrav(n.left);
            preOrderTrav(n.right);
        }
    }

    static void postOrderTrav(node n) {
        if (n != null) {
            postOrderTrav(n.left);
            postOrderTrav(n.right);
            System.out.print(n.data + " ");
        }
    }

    public static void main(String[] args) {

        //case-1
        // node ROOT = new node(1);
        // ROOT.left = new node(2);
        // ROOT.right = new node(3);

         //case-1
        // node ROOT = new node(12);
        // ROOT.left = new node(222);
        // ROOT.right = new node(343);

        inOrderTrav(ROOT);
        System.out.println();
        preOrderTrav(ROOT);
        System.out.println();
        postOrderTrav(ROOT);

    }

}
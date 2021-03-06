import java.util.*;

/**
 * 
 * given infinite supply of some boxes (each has 3 dimensions) , find the max height we can get by placing a box on top of other box
 * 
 * u are free to take any dimension as L , B  , H
 * 
 *  NOTE : box A can go over box B only if : (length and width of A ) < (l,b of B)
 * 
 * 
 */

/**
 * 
 * dp-array = 1D
 * 
 * this problem uses longest-increasing-subSequence concept
 * 
 * step-1 : from the given set of boxes , we first find all permutations of l,b,h (such that L>B , to have 1,2,3 and 2,1,3 as same combination)
 * step-2 : sort the above cominations in decreasing order of base-area
 * step-3 : use longest-increasing-subSequence approach to fill dp array
 * 
 * ==========================
 * let number of boxes = n
 * TC = O(n^2)
 * SC = O(n)
 * 
 * 
 * 
 */

class Box implements Comparable<Box> {
    public int height;
    public int width;
    public int length;

    Box(int l, int w, int h) {
        this.length = l;
        this.width = w;
        this.height = h;
    }

    int getArea() {
        return (this.length * this.width);
    }

    // sort decresing order of base area
    @Override
    public int compareTo(Box b) {
        int area1 = this.getArea();
        int area2 = b.getArea();
        return -(area1 - area2);
    }
}

class p26_boxStacking {

    public static void main(String[] args) {

        Box[] boxes = new Box[] { new Box(1, 2, 4), new Box(2, 3, 5) };
        // Box[] boxes = new Box[] { 
        //     new Box(4, 6, 7), 
        //     new Box(1, 2, 3), 
        //     new Box(4, 5, 6), 
        //     new Box(10, 12, 32) 
        // };

        int answer = calulator(boxes);
        System.out.println(answer);
    }

    static int calulator(Box[] boxes) {

        ArrayList<Box> possibleBoxes = new ArrayList<Box>();

        for (int i = 0; i < boxes.length; i++) {
            int L = boxes[i].length;
            int W = boxes[i].width;
            int H = boxes[i].height;

            // length must be greater than width (to avoid <1,2,X> and <2,1,X> as 2 seperate
            // combinations)
            if (L > W) {
                possibleBoxes.add(new Box(L, W, H));
            } else {
                possibleBoxes.add(new Box(W, L, H));
            }

            if (L > H) {
                possibleBoxes.add(new Box(L, H, W));
            } else {
                possibleBoxes.add(new Box(H, L, W));
            }

            if (W > H) {
                possibleBoxes.add(new Box(W, H, L));
            } else {
                possibleBoxes.add(new Box(H, W, L));
            }
        }

        // sort decresing order of base area
        Collections.sort(possibleBoxes);

        // for (Box b : possibleBoxes) {
        // System.out.println(b.length + " " + b.width + " " + b.height);
        // }

        int[] table = new int[possibleBoxes.size()];

        // initialize table , consider only 1 box is available
        for (int i = 0; i < possibleBoxes.size(); i++) {
            table[i] = possibleBoxes.get(i).height;
        }

        // now using main logic
        for (int i = 1; i < possibleBoxes.size(); i++) {
            for (int j = 0; j < i; j++) {

                Box topBox = possibleBoxes.get(i);
                Box belowBox = possibleBoxes.get(j);

                boolean areaCompatible = (topBox.getArea() < belowBox.getArea()) ? true : false;
                boolean dimensionCompatible = (topBox.length < belowBox.length && topBox.width < belowBox.width) ? true
                        : false;

                if (areaCompatible && dimensionCompatible) {
                    table[i] = Math.max(topBox.height + table[j], table[i]);
                }
            }
        }

        return table[possibleBoxes.size() - 1];
    }
}
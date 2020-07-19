//given some number of floors and eggs , find the attempts it would take IN THE WORST CASE to find the floor from which an egg will break
//note : if an egg breaks from floor number X , it would break form higher floors as well

/**
 * 
 * dp-array = 2D
 * array-filling = new concept 
 * 
 * consider F floors and E eggs
 * concept : if we throw an egg from K'th floor , it has 2 choices 
 * 
 * choice-1 :  it breaks (in this case we will have #floors left = K-1 , and #eggs to user = E-1)
 * choice-2 :  it does NOT breaks (in this case we will have #floors left = F-K , and #eggs to user = E)
 * 
 * thus, we use the above , such that K runs from 1st floor till last floor, each is case , and we need to find MIN of all cases
 * 
 */

class p10_eggDrop {

    public static void main(String[] args) {

        int floors = 4;
        int eggs = 2;
        int answer = calulator(floors, eggs);
        System.out.println(answer);

    }

    static int calulator(int totalFloors, int eggs) {
        int[][] table = new int[eggs + 1][totalFloors + 1];

        for (int currentEggs = 0; currentEggs <= eggs; currentEggs++) {
            for (int currentFloor = 0; currentFloor <= totalFloors; currentFloor++) {

                if (currentEggs == 0 || currentFloor == 0) {
                    table[currentEggs][currentFloor] = 0;
                    continue;
                }

                if (currentEggs == 1) {
                    table[currentEggs][currentFloor] = currentFloor;
                    continue;
                }

                if (currentFloor == 1) {
                    table[currentEggs][currentFloor] = 1;
                    continue;
                }

                int minAttempts = -1;
                table[currentEggs][currentFloor] = 10000;
                for (int i = 1; i <= currentFloor; i++) {
                    minAttempts = 1 + Math.max(table[currentEggs - 1][i - 1], table[currentEggs][currentFloor - i]);

                    if (minAttempts < table[currentEggs][currentFloor]) {
                        table[currentEggs][currentFloor] = minAttempts;
                    }
                }

            }
        }

        return table[eggs][totalFloors];
    }
}
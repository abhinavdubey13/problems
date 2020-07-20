
/**
 * given some number of floors and eggs , 
 * 
 * find the attempts it would take IN THE WORST CASE to find the floor from which an egg will break
 * 
 * note : if an egg breaks from floor number X , it would break form higher floors as well
 */

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
 * thus, we use the above , such that K runs from 1st floor till last floor
 * 
 * =====================================================
 * answer-for-each-floor(k) = Math.min(set of all MAX)
 * =====================================================
 * 
 * =========================
 * TC = O(eggs . floors  . floor)   = cubic
 * SC = O(eggs . floors)
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

        for (int curr_eggs = 0; curr_eggs <= eggs; curr_eggs++) {
            for (int curr_floor = 0; curr_floor <= totalFloors; curr_floor++) {

                //if no-egg or no-floor , we can not make an attempt
                if (curr_eggs == 0 || curr_floor == 0) {
                    table[curr_eggs][curr_floor] = 0;
                    continue;
                }

                //if 1 egg : then we need to drop from each floor one-by-one
                if (curr_eggs == 1) {
                    table[curr_eggs][curr_floor] = curr_floor;
                    continue;
                }

                //if #floor=1 : #attempts = 1 , regardless of number of eggs
                if (curr_floor == 1) {
                    table[curr_eggs][curr_floor] = 1;
                    continue;
                }

                table[curr_eggs][curr_floor] = Integer.MAX_VALUE;

                for (int i = 1; i <= curr_floor; i++) {
                    
                    int if_egg_breaks = table[curr_eggs - 1][i - 1];
                    int if_egg_not_breaks = table[curr_eggs][curr_floor - i];
                    int minAttempts = 1 + Math.max(if_egg_breaks, if_egg_not_breaks);

                    table[curr_eggs][curr_floor] = Math.min(minAttempts, table[curr_eggs][curr_floor]);
                }
            }
        }

        return table[eggs][totalFloors];
    }

}
import java.util.*;

/**
 * 
 * leetcode id : 690
 * 
 * You are given a data structure of employee information, 
 * which includes the employee's unique id, their importance value and their direct subordinates' id.
 * 
 * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. 
 * They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], 
 * and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. 
 * Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.
 * 
 * Now given the employee information of a company, and an employee id, 
 * you need to return the total importance value of this employee and all their subordinates.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * Output: 11
 * explanation:
 * 
 * Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. 
 * They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 * 
 * 
 */

/**
 * 
 * 
 * =============
 * APPROACH : 
 * =============
 * 
 * dfs and hashmap
 * 
 * convert employee list to hashmap first
 * 
 * then do dfs
 * 
 * 
 *
 * 
 * 
 * 
 */

class Employee {
    int id;
    int importance;
    List<Integer> subordinates;

    Employee(int id, int imp, List<Integer> sub) {
        this.id = id;
        this.importance = imp;
        this.subordinates = sub;
    }
};

class x16_employee_importance {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        List<Integer> sub1 = new ArrayList<>(Arrays.asList(2, 3));
        employees.add(new Employee(1, 5, sub1));

        List<Integer> sub2 = new ArrayList<>(Arrays.asList(3));
        employees.add(new Employee(2, 3, sub2));

        List<Integer> sub3 = new ArrayList<>(Arrays.asList());
        employees.add(new Employee(3, 3, sub3));

        int start_id = 1;

        int answer = new Solution().function(employees, start_id);
        System.out.println(answer);

    }

}

class MapHelper {
    int importance;
    List<Integer> subordinates;

    MapHelper(int imp, List<Integer> subs) {
        this.importance = imp;
        this.subordinates = subs;
    }
}

class Solution {

    int ANSWER;

    int function(List<Employee> employees, int start_id) {

        ANSWER = 0;

        Map<Integer, MapHelper> map = new HashMap<>();

        for (Employee e : employees) {
            map.put(e.id, new MapHelper(e.importance, e.subordinates));
        }

        if (map.size() == 0) {
            return 0;
        }

        else if (map.size() == 1 && start_id == employees.get(0).id) {
            return employees.get(0).importance;
        }

        Set<Integer> vis = new HashSet<>();
        dfs(map, start_id, vis);
        return ANSWER;
    }

    void dfs(Map<Integer, MapHelper> map, int curr, Set<Integer> vis) {

        vis.add(curr);
        ANSWER += map.get(curr).importance;

        for (Integer sub : map.get(curr).subordinates) {
            if (!vis.contains(sub)) {
                dfs(map, sub, vis);
            }
        }

    }

}
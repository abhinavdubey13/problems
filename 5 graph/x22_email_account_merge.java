import java.util.*;

/**
 * 
 * leetcode id : 721
 * 
 * Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, 
 * and the rest of the elements are emails representing emails of the account.
 * 
 * Now, we would like to merge these accounts. 
 * Two accounts definitely belong to the same person if there is some common email to both accounts. 
 * Note that even if two accounts have the same name, they may belong to different people as people could have the same name. 
 * A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 * 
 * After merging the accounts, return the accounts in the following format: 
 * the first element of each account is the name, 
 * and the rest of the elements are emails in sorted order. 
 * 
 * The accounts themselves can be returned in any order.
 * 
 * 
 * 
 * ==========
 * example : 
 * ==========
 * 
 * Input: 
 * accounts = 
 * [
 *  ["John","johnsmith@mail.com","john_newyork@mail.com"],
 *  ["John","johnsmith@mail.com","john00@mail.com"],
 *  ["Mary","mary@mail.com"],
 *  ["John","johnnybravo@mail.com"]
 * ]
 * 
 * Output: 
 * [
 *  ["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],
 *  ["Mary","mary@mail.com"],
 *  ["John","johnnybravo@mail.com"]
 * ]
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
 * using DSU
 * 
 * 
 * group all related emails together using DSU
 * 
 * then assign the owner to that grup of emails
 * 
 * https://leetcode.com/problems/accounts-merge/discuss/109157/JavaC%2B%2B-Union-Find
 * 
 * 
 *
 * 
 */

class x22_email_account_merge {

    public static void main(String[] args) {

    }

}

class Solution {

    List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, String> owner = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        Map<String, TreeSet<String>> grouped_union = new HashMap<>();

        List<List<String>> answer = new ArrayList<>();

        for (List<String> account : accounts) {
            String user = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                owner.put(account.get(i), user); //all emails in a list belongs to the same user
                parent.put(account.get(i), account.get(i)); //initially , every email is parent of itself
            }
        }

        //finding union
        for (List<String> account : accounts) {
            String p = find(account.get(1), parent);
            for (int i = 2; i < account.size(); i++) {
                String old_parent = find(account.get(i), parent);
                parent.put(old_parent, p);
            }
        }

        //club all email with same parent , in treeset
        for (List<String> account : accounts) {
            String p = find(account.get(1), parent);
            if (!grouped_union.containsKey(p)) {
                grouped_union.put(p, new TreeSet<>());
            }
            for (int i = 1; i < account.size(); i++) {
                grouped_union.get(p).add(account.get(i));
            }
        }

        for (String p : grouped_union.keySet()) {
            List<String> sorted_emails = new ArrayList<>(grouped_union.get(p));

            //add user at the 0th index
            sorted_emails.add(0, owner.get(p));

            answer.add(sorted_emails);
        }

        return answer;

    }

    String find(String s, Map<String, String> parent) {
        String p = parent.get(s);
        if (p.equals(s)) {
            return s;
        } else {
            return find(p, parent);
        }
    }

}

package GeneralAssignment;/*
 * Created by Linfeng Li on 08/30/21
 * University of Illinois Chicago
 */

import java.util.*;

public class longestSubarrayCheck {
    boolean longestSubarrayCheck(int[] a, int[] b, int[] c) {
        Set<Integer> set = new HashSet<>();
        for (int cur : c) {
            set.add(cur);
        }
        List<Integer> newB = new ArrayList<>();

        for (int j : b) {
            if (!set.contains(j)) {
                return false;
            } else {
                newB.add(j);
            }
        }
        return find(a, set, newB);
    }

    // find max length sub-array that with only elements in set
    private boolean find(int[] a, Set<Integer> set, List<Integer> newB) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = i; j < a.length; j++) {
                if (set.contains(a[j])) {
                    cur.add(a[j]);
                } else {
                    break;
                }
            }
            max = Math.max(max, cur.size());
            if (cur.size() < newB.size()) {
                continue;
            }
            if (cur.size() == max) {
                if (cur.equals(newB)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        longestSubarrayCheck main = new longestSubarrayCheck();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);

    }
}
// Company Name | Stage (Phone, Onsite, OA) | Question name
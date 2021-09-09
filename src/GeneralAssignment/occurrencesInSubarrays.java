package GeneralAssignment;

import java.util.*;

/**
 * Created by Linfeng Li on 09/03/21
 * University of Illinois Chicago
 */
public class occurrencesInSubarrays {

    class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    class MyComparator implements Comparator<Integer> {
        final Map<Integer, Integer> map;

        public MyComparator(Map<Integer, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 < o2) {
                return -1;
            } else if (o1.equals(o2)) {
                return map.get(o1).compareTo(map.get(o2));
            }
            return 1;
        }
    }

    int[] occurrencesInSubarrays(int[] arr, int m) {
        int[] ans = new int[arr.length - m + 1];
        int index = 0;
        Map<Integer, Pair> map = new HashMap<>();


        for (int i = 0; i < m; i++) {
            map.merge(arr[i], 1, Integer::sum);
        }
        ans[index++] = findMax(map);
        for (int i = m; i < arr.length; i++) {
            Integer count = map.get(arr[i - m]);
            if (count != null) {
                if (count == 1) {
                    map.remove(arr[i - m]);
                } else {
                    map.put(arr[i - m], count - 1);
                }
            }
            map.merge(arr[i], 1, Integer::sum);
            ans[index++] = findMax(map);
        }
        return ans;
    }

    private int findMax(Map<Integer, Integer> map) {
        int maxKey = Integer.MAX_VALUE;
        int maxValue = 0;
        System.out.println(map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValue) {
                maxKey = Math.min(maxKey, entry.getKey());
            } else if (entry.getValue() > maxValue) {
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        occurrencesInSubarrays o = new occurrencesInSubarrays();
        System.out.println(Arrays.toString(o.occurrencesInSubarrays(
                new int[]{5, 5, 7, 1, 3, 5, 5, 3, 3, 1, 1}, 5)));
    }

//    Input:
//    arr: [5, 5, 7, 1, 3, 5, 5, 3, 3, 1, 1]
//    m: 5
//    Output:
//            [2, 2, 2, 2, 3, 2, 2]
//    Expected Output: [2, 2, 2, 2, 3, 2, 2]
}

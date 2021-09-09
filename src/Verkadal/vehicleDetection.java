package Verkadal;/*
 * Created by Linfeng Li on 08/31/21
 * University of Illinois Chicago
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class vehicleDetection {
    int[] vehicleDetection(int[][] input) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] ints : input) {
            for (int anInt : ints) {
                map.merge(anInt, 1, Integer::sum);
            }
        }
        int size = input.length;
        List<Integer> list = new ArrayList<>();
        for (int num : input[0]) {
            if (map.get(num) == size) {
                list.add(num);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

}

package GeneralAssignment;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Linfeng Li on 09/02/21
 * University of Illinois Chicago
 */
public class mostFrequentDigits {
    int[] mostFrequentDigits(int[] a) {
        int[] memo = new int[10];

        for (int num : a) {
            while (num > 0) {
                memo[num % 10]++;
                num /= 10;
            }
        }
        int max = 0;
        int count = 0;
        for (int num: memo) {
            if (num == max) {
                count++;
            } else if (num > max) {
                count = 1;
                max = num;
            }
        }
        int[] ans = new int[count];
        int index = 0;
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] == max) {
                ans[index++] = i;
            }
        }
        return ans;
    }


}

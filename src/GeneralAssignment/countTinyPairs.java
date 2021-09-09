package GeneralAssignment;/*
 * Created by Linfeng Li on 08/30/21
 * University of Illinois Chicago
 */

public class countTinyPairs {
    int countTinyPairs(int[] a, int[] b, int k) {
        int left = 0;
        int right = a.length - 1;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int digit = 1;
            int cur = b[right];
            while (cur > 0) {
                cur /= 10;
                digit *= 10;
            }
            int sum = (a[left] * digit) + b[right];
            if (sum < k) {
                count++;
            }
            left++;
            right--;
        }
        return count;
    }

    public static void main(String[] args) {
        countTinyPairs count = new countTinyPairs();
        System.out.println(count.countTinyPairs(new int[] {16, 1, 4, 2, 14}, new int[] {7, 11, 2, 0, 15}, 743));
    }
}

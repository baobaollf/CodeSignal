package GeneralAssignment;/*
 * Created by Linfeng Li on 08/30/21
 * University of Illinois Chicago
 */

public class isZigzag {
    int[] isZigzag(int[] numbers) {
        int[] ans = new int[numbers.length - 2];
        int index = 0;
        for (int i = 1; i < numbers.length - 1; i++) {
            if (numbers[i - 1] < numbers[i] && numbers[i] > numbers[i + 1]) {
                ans[index++] = 1;
            } else if (numbers[i - 1] > numbers[i] && numbers[i] < numbers[i + 1]) {
                ans[index++] = 1;
            } else {
                ans[index++] = 0;
            }
        }
        return ans;
    }

}

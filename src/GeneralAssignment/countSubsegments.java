package GeneralAssignment;

import java.util.Arrays;

/**
 * Created by Linfeng Li on 09/02/21
 * University of Illinois Chicago
 */
public class countSubsegments {
    long countSubsegments(int[] arr) {
        long ans = 0;
        int size = arr.length;
        long first = 0;
        for (int i = 0; i < size; i++) {
            first += arr[i];
            long second = 0;
            for (int j = i + 1; j < size; j++) {
                second += arr[j];
                long third = 0;
                for (int k = j + 1; k < size; k++) {
                    third += arr[k];
                    System.out.println(first + " " + second + " " + third);
                    if (first <= second && second  <= third && k == size - 1) {
                        ans++;
                        System.out.println("added");
                        break;
                    }

                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        return ans;
    }

    public static void main(String[] args) {
        countSubsegments countSubsegments = new countSubsegments();
        System.out.println(countSubsegments.countSubsegments(new int[]{1, 2, 2, 2, 5, 0}));
    }
}

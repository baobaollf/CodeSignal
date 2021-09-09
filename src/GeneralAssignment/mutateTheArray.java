package GeneralAssignment;

/**
 * Created by Linfeng Li on 09/02/21
 * University of Illinois Chicago
 */
public class mutateTheArray {
    int[] mutateTheArray(int n, int[] a) {

        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            if (i - 1 >= 0) {
                sum += a[i - 1];
            }
            if (i + 1 < n) {
                sum += a[i + 1];
            }
            sum += a[i];
            b[i] = sum;
        }
        return b;

    }

}

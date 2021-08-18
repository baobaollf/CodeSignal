package Arrays;

import java.util.HashSet;
import java.util.Set;

public class firstDuplicate {
    int firstDuplicate(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (!set.contains(a[i])) {
                set.add(a[i]);
                continue;
            }
            return a[i];
        }
        return -1;
    }

}

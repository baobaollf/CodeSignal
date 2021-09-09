package GeneralAssignment;/*
 * Created by Linfeng Li on 08/30/21
 * University of Illinois Chicago
 */

import java.util.HashMap;
import java.util.Map;

public class mergeStrings {
    String mergeStrings(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> one = new HashMap<>();
        Map<Character, Integer> two = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            one.merge(c, 1, Integer::sum);
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            two.merge(c, 1, Integer::sum);
        }


        int i = 0;
        int j = 0;

        while (i < s1.length() && j < s2.length()) {
            char a = s1.charAt(i);
            char b = s2.charAt(j);

            if (one.get(a) < two.get(b)) {
                sb.append(a);
                i++;
            } else if (one.get(a) > two.get(b)) {
                sb.append(b);
                j++;
            } else {
                if (a < b) {
                    sb.append(a);
                    i++;
                } else if (a > b) {
                    sb.append(b);
                    j++;
                } else {
                    sb.append(a);
                    i++;
                }
            }
        }

        while (i < s1.length()) {
            sb.append(s1.charAt(i++));
        }

        while (j < s2.length()) {
            sb.append(s2.charAt(j++));
        }
        return sb.toString();
    }

}

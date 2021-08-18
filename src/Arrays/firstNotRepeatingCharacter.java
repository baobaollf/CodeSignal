package Arrays;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class firstNotRepeatingCharacter {
    // Space: O(n)
    // Time: O(n)
    char firstNotRepeatingCharacter(String s) {
        char[] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                int count = map.get(array[i]);
                map.put(array[i], count + 1);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                return array[i];
            }
        }
        return '_';
    }

}

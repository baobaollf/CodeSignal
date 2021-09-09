package GeneralAssignment;/*
 * Created by Linfeng Li on 08/30/21
 * University of Illinois Chicago
 */

import java.util.HashMap;
import java.util.Map;

public class maximalPalindrome {
    String maximalPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }

        String firstHalf = "", lastHalf = "";
        boolean seenOdd = false;
        char firstOddChar = 0;
        for (int i = 0; i < 26; i++) {
            char c = (char)(i + 'a');
            if (map.containsKey(c)) {
                String ss = "";
                for (int j = 0; j < map.get(c) / 2; j++) {
                    ss += c;
                }
                if (map.get(c) % 2 != 0 && !seenOdd) {
                    seenOdd = true;
                    firstOddChar = c;
                }
                firstHalf = firstHalf + ss;
                lastHalf = ss + lastHalf;
            }
        }

        return (seenOdd) ?
                (firstHalf + firstOddChar + lastHalf) :
                (firstHalf + lastHalf);
    }

}

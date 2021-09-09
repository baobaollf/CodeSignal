package Verkadal;/*
 * Created by Linfeng Li on 08/31/21
 * University of Illinois Chicago
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class verkadaIPAddressFinder {
    String[] verkadaIPAddressFinder(String str) {
        if (str.length() < 3 || str.length() > 12) {
            return new String[1];
        }
        return convert(str);
    }

    String[] convert(String s) {
        List<String> list = new ArrayList<>();
        int size = s.length();
        String temp = s;

        for (int i = 1; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    temp = temp.substring(0, k) + "." + temp.substring(k);
                    temp = temp.substring(0, j) + "." + temp.substring(j);
                    temp = temp.substring(0, i) + "." + temp.substring(i);
                    if (valid(temp)) {
                        list.add(temp);
                    }
                    temp = s;
                }
            }
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    boolean valid(String ip) {
        String a[] = ip.split("[.]");
        for (String s : a) {
            int i = Integer.parseInt(s);
            if (s.length() > 3 || i < 0 || i > 255) {
                return false;
            }
            if (s.length() > 1 && i == 0)
                return false;
            if (s.length() > 1 && i != 0
                    && s.charAt(0) == '0')
                return false;
        }

        return true;
    }
}

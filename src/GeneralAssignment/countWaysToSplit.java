package GeneralAssignment;/*
 * Created by Linfeng Li on 08/30/21
 * University of Illinois Chicago
 */

public class countWaysToSplit {
    int countWaysToSplit(String str) {
        int len = str.length();
        int count = 0;
        for (int i = 1; i <= len - 2; i++) {
            for (int j = i + 1; j <= len - 1; j++) {
//              Separate the String into three parts with different index range, each lenght is at least 1
//                    String a = str.substring(0, i); // [0, i - 1]
//                    String b = str.substring(i, j); // [i, j - 1]
//                    String c = str.substring(j, len); // [j, len - 1]
                String ab = str.substring(0, j); // this is [0, i - 1] + [i, j - 1] = [0, j - 1];
                String bc = str.substring(i, len); // this [i, j - 1] + [j, len - 1] = [i, len - 1];
                String ca = str.substring(j, len) + str.substring(0, i); // this is [j, len - 1] + [0, i - 1]
                if (!(ab.equals(bc) || bc.equals(ca) || ca.equals(ab))) { // check if the three concatenation are the same, if not, add it to the count
                    count++;
                }
            }
        }
        return count;
    }

}

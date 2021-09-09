package GeneralAssignment;/*
 * Created by Linfeng Li on 08/30/21
 * University of Illinois Chicago
 */

public class eraseOneDigit {
    boolean eraseOneDigit(String firstnum, String secondnum, String thirdnum) {
        int two = stringToInt(secondnum, false);
        int three = stringToInt(thirdnum, false);
        int tempOne = stringToInt(firstnum, false);
        if (tempOne + two == three) {
            return true;
        }

        for (int i = 0; i < firstnum.length(); i++) {
            StringBuilder sb = new StringBuilder(firstnum);
            sb.deleteCharAt(i);
            int one = stringToInt(sb.toString(), true);
            if (one != -1 && one + two == three) {
                return true;
            }
        }
        return false;

    }

    private int stringToInt(String toCharArray,  boolean first) {
        System.out.println("input is " + toCharArray);
        int count = 0;

        for (char c : toCharArray.toCharArray()) {
            if (first && c == '0' && toCharArray.length() != 1) {
                return -1;
            } else {
                first = false;
            }
            count *= 10;
            count += (c - '0');
        }
        System.out.println(count);
        return count;
    }

}

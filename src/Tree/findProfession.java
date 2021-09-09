package Tree;

import java.util.LinkedList;
import java.util.List;

public class findProfession {
    // works but to slow
//    String findProfession(int level, int pos) {
//        String[] one = new String[1];
//        one[0] = "Engineer";
//        String[] two = new String[one.length * 2];
//        for (int i = 0; i < level - 1; i++) {
//            for (int j = 0; j < one.length; j++) {
//                if (one[j].equals("Engineer")) {
//                    two[j * 2] = "Engineer";
//                    two[(j * 2) + 1] = "Doctor";
//                } else {
//                    two[j * 2] = "Doctor";
//                    two[(j * 2) + 1] = "Engineer";
//                }
//                if (i == level - 1 && (j * 2) + 1 >= pos - 1) {
//                    return one[pos - 1];
//                }
//            }
//            one = two;
//            two = new String[one.length * 2];
//        }
//        return one[pos - 1];
//    }

    String findProfession(int level, int pos) {
        boolean flipped = false;

        while (level > 1) {
            if (pos % 2 == 0) {
                flipped = !flipped;
            }
            pos = (pos + 1) / 2;
            level--;
        }
        return flipped ? "Doctor" : "Engineer";
    }

//                E
//        E               D
//    E       D       D       E
//  E   D   D   E   D   E   E   D
// E D D E D E E D D E E D E D D E
//
// 5 7 = E
// 5 9

}

import java.util.HashMap;
import java.util.Map;

public class SpaceX {
    // CodeSignal Company Challenge #2
    String packetDescrambler(int[] seq, char[] fragmentData, int n) {
        Map<Integer, Map<Character, Integer>> map = new HashMap<>();

        for (int i = 0; i < seq.length; i++) {
            if (!map.containsKey(seq[i])) {
                map.put(seq[i], new HashMap<>());
                map.get(seq[i]).put(fragmentData[i], 1);
            } else {
                if (!map.get(seq[i]).containsKey(fragmentData[i])) {
                    map.get(seq[i]).put(fragmentData[i], 1);
                } else {
                    int count = map.get(seq[i]).get(fragmentData[i]);
                    map.get(seq[i]).put(fragmentData[i], count + 1);
                }
            }
        }
        int size = map.size();
        char[] array = new char[size];
        for (Map.Entry<Integer, Map<Character, Integer>> m : map.entrySet()) {
            char c = findMajorityChar(m.getValue(), n);
            if (c == 0) {
                return "";
            }
            if (m.getKey() >= array.length) {
                return "";
            }
            if (m.getKey() != size - 1 && c == '#') {
                return "";
            }
            array[m.getKey()] = c;
        }
        if (array[array.length - 1] != '#') {
            return "";
        }
        return new String(array);
    }

    private char findMajorityChar(Map<Character, Integer> map, int n) {
        char c = 0;
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            if (m.getValue() > (n / 2)) {
                c = m.getKey();
            }
        }
        return c;
    }


    public static void main(String[] args) {
        SpaceX spaceX = new SpaceX();
        int[] seq = new int[]{1, 1, 0, 0, 0, 2, 2, 2};
        char[] fragmentData = new char[]{'+', '+', 'A', 'A', 'B', '#', '#', '#'};
        System.out.println(spaceX.packetDescrambler(seq, fragmentData, 3));
    }
}

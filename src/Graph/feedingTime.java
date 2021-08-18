package Graph;

import java.util.*;

public class feedingTime {
    int feedingTime(String[][] classes) {
        int min = 0;
        List<Set<String>> list = new ArrayList<>();
        for (int i = 0; i < classes.length; i++) {
            Set<String> set = new HashSet<>(Arrays.asList(classes[i]));
            list.add(set);
        }
        int[] result = new int[]{-1};
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < classes.length; i++) {
            dfs(list, visited, i, result);
        }
        return result[0];

    }

    private void dfs(List<Set<String>> list, Set<Integer> visited, int i, int[] result) {
        for (int j = 0; j < list.get(i).size(); j++) {

        }

        if (visited.size() == list.size()) {
            result[0] += 1;
        }
    }

}

package Graph;

import java.util.*;

public class singlePointOfFailure {
    // time: O(n^2)
    // space: O(n)
    int singlePointOfFailure(int[][] connections) {
        int count = 0;
        for (int i = 0; i < connections.length; i++) {
            for (int j = i + 1; j < connections.length; j++) {
                if (connections[i][j] == 1) {
                    connections[i][j] = 0;
                    connections[j][i] = 0;
                    if (!bfs(connections, i)) {
                        count++;
                    }
                    connections[i][j] = 1;
                    connections[j][i] = 1;
                }
            }
        }
        return count;
    }

    private boolean bfs(int[][] connections, int i) {
        Deque<Integer> queue = new LinkedList<>();
        queue.offerLast(i);

        Set<Integer> set = new HashSet<>();
        set.add(i);

        while (!queue.isEmpty()) {
            int cur = queue.pollFirst();
            for (int j = 0; j < connections.length; j++) {
                if (connections[cur][j] == 1 && !set.contains(j)) {
                    set.add(j);
                    queue.offerLast(j);
                }
            }
        }
        return set.size() == connections.length;
    }


    // return true means that we can visit all the nodes
    // false means that we hit a point of failure
    private boolean dfs(int[][] connections, boolean[] visited) {
        for (int i = 0; i < connections.length; i++) {
            visited[i] = true;
            if (dfs(connections, visited, i)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    private boolean dfs(int[][] connections, boolean[] visited, int i) {
        for (int x = 0; x < connections.length; x++) {
            if (allVisited(visited)) {
                return true;
            }
            if (!visited[x]) {
                if (connections[i][x] == 1) {
                    visited[x] = true;
                    if (dfs(connections, visited, x)) {
                        return true;
                    }
                    visited[x] = false;
                }
            }
        }
        return false;
    }

    private boolean allVisited(boolean[] visited) {
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] connections = new int[][] {
                new int[] {0,1,1,1,0,0},
                new int[] {1,0,1,0,0,0},
                new int[] {1,1,0,0,0,0},
                new int[] {1,0,0,0,1,1},
                new int[] {0,0,0,1,0,0},
                new int[] {0,0,0,1,0,0},
        };
//        int[][] connections = new int[][] {
//                new int[] {0, 1},
//                new int[] {1, 0}
//        };
        singlePointOfFailure singlePointOfFailure = new singlePointOfFailure();
        System.out.println(singlePointOfFailure.singlePointOfFailure(connections));
    }

}

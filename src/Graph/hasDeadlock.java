package Graph;

public class hasDeadlock {
    boolean hasDeadlock(int[][] connections) {
        // DFS
        boolean[][] visited = new boolean[connections.length][connections.length];
        for (int i = 0; i < connections.length; i++) {
            if (dfs(connections, visited, i)) {
                return true;
            }
        }
        return false;

    }

    private boolean dfs(int[][] connections, boolean[][] visited, int i) {
        for (int x = 0; x < connections[i].length; x++) {
            if (visited[i][x]) {
                return true;
            }
            visited[i][x] = true;
            if (dfs(connections, visited, connections[i][x])) {
                return true;
            }
            visited[i][x] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        hasDeadlock hasDeadlock = new hasDeadlock();
//        int[][] con = new int[][]{
//                new int[]{1},
//                new int[]{2},
//                new int[]{3, 4},
//                new int[]{4},
//                new int[]{0},
//        };

        int[][] con = new int[][]{
                new int[]{1, 2},
                new int[]{2},
                new int[]{},
                new int[]{4},
                new int[]{3},
        };
        System.out.println(hasDeadlock.hasDeadlock(con));
    }

}

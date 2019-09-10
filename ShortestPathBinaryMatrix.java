class ShortestPathBinaryMatrix {
    // 1091
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid.length == 0) {
            return 0;
        }
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int depth = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0});
        visited[0][0] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("queue size: " + size);
            depth++;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == grid.length - 1 && curr[1] == grid[0].length - 1) {
                    return depth;
                }
                for (int[] next : getNext(curr, grid)) {
                    if (!visited[next[0]][next[1]] && grid[next[0]][next[1]] == 0) {
                        queue.add(next);
                        visited[next[0]][next[1]] = true;
                    }
                }
            }
        }
        return -1;
    }

    private List<int[]> getNext(int[] curr, int[][] grid) {
        List<int[]> nexts = new ArrayList<>();
        int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int curr_x = curr[0];
        int curr_y = curr[1];
        for (int i = 0; i < dx.length; i++) {
            int x = curr_x + dx[i];
            int y = curr_y + dy[i];
            if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 0) {
                nexts.add(new int[] {x, y});
            }
        }
        return nexts;
    }
}
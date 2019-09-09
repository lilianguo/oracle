class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[][] path =  new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(path[i], Integer.MAX_VALUE);
        }
        path[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(grid[0][0]);
        int[][] directions = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}};
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 8; i++) {
                int x = curr[0] + directions[i][0];
                int y = curr[1] + directions[i][1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '0') {
                    path[x][y] = Math.min(path[x][y], path[curr[0]][curr[1]] + 1);
                    queue.offer(new int[] {x, y});
                }
            }
        }
        return path[grid.length -1][grid[0].length - 1] == Integer.MAX_VALUE ? -1 : ath[grid.length -1][grid[0].length - 1];
    }
}
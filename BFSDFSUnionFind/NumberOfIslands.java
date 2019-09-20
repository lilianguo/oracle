class NumberOfIslands {
    // 200 
    /*
    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
    You may assume all four edges of the grid are all surrounded by water.

    Example 1:

    Input:
    11110
    11010
    11000
    00000

    Output: 1
    Example 2:

    Input:
    11000
    11000
    00100
    00011

    Output: 3
    */
    // bfs traverse each point, mark all adjacent as 1 island per traverse
    // thus number of island  = number of bfs done
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 ) {
            return 0;
        }
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    markIsland(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void markIsland(char[][] grid, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        int[] dx = new int[] {1, 0, -1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int xx = curr[0] + dx[dir];
                int yy = curr[1] + dy[dir];
                if (isValid(xx, yy, grid) && !visited[xx][yy] && grid[xx][yy] == '1') {
                    queue.add(new int[] {xx, yy});
                    visited[xx][yy] = true;
                }
            }
            //System.out.println("queue.size() : " + queue.size());
        }
    }

    private boolean isValid(int x, int y, char[][] grid) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            return true;
        }
        return false;
    }
}
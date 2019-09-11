import java.util.Queue;

class NumberOfIslands {
    // 200 
    /*
    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
    You may assume all four edges of the grid are all surrounded by water.
    */
    // bfs traverse each point, mark all adjacent as 1 island per traverse
    // thus number of island  = number of bfs done
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int num = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1'){
                    System.out.println("i is "+ i);
                    System.out.println("j is "+ j);
                    markIsland(grid, visited, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    private void markIsland(char[][] grid, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            x = curr[0];
            y = curr[1];
            for (int i = 0 ; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                System.out.println("nx : " + nx);
                System.out.println("ny :" + ny);
                if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && !visited[nx][ny] && grid[nx][ny] == '1') {
                    queue.add(new int[] {nx, ny});
                    System.out.println("nx : " + nx);
                    System.out.println("ny :" + ny);
                    visited[nx][ny] = true;
                }
            }
            System.out.println("queue size :" + queue.size());
        }
        System.out.println("++++++++++++++++");
    }
}
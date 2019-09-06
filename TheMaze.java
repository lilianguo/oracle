class TheMaze{
    // Time complexity : O(mn). Complete traversal of maze will be done in the worst case. 
    // Here, m and n refers to the number of rows and coloumns of the maze.
    // Space complexity : O(mn). visited array of size m*nm∗n is used and queuequeue size can grow upto m*n
    // in worst case.
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>(); 
        queue.offer(start);
        int[] dir_x = {1, 0, -1, 0};
        int[] dir_y = {0, 1, 0, -1};
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int x = curr[0];
                int y = curr[1];
                while(x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir_x[i];
                    y += dir_y[i];
                }
                x -= dir_x[i];
                y -= dir_y[i];
                if (!visited[x][y]) {
                    visited[x][y] = true;
                    queue.offer(new int[] {x,y});
                }
            }
        }
        return false;
    }
}
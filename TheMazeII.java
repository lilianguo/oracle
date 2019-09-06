import java.util.Queue;

class TheMazeII {
    // DFS solution
    // space O(mn)
    // time O(mn*max(m,n)): Complete traversal of maze will be done in the worst case. 
    // Here, m and n refers to the number of rows and columns of the maze. 
    // Further, for every current node chosen, we can travel upto a maximum depth of max(m,n) in any direction.
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        dfs(maze, start, distance);
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }

    private void dfs(int[][] maze, int[] start, int[][] distance) {
        int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}};
        for (int[] dir : dirs) {
            int x = start[0] + dir[0];
            int y = start[1] + dir[1];
            int count = 0;
            // 最后一个循环的时候，x y 已经走到不合法的位置了，需要退回来一个才是合法的
            // count 因为初始化为0了所以出while的时候还是合法的。（进入每个direction先加了1， 这样count其实是1， 但是初始化为0了）
            while(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
                count++;
            }
            if (distance[start[0]][start[1]] + count < distance[x- dir[0]][y - dir[1]]) {
                distance[x- dir[0]][y - dir[1]] = distance[start[0]][start[1]] + count;
                dfs(maze, new int[] {x- dir[0], y - dir[1]}, distance);
            }

        }
    }
}
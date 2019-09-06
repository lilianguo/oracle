class TheMazeIII {
    // 返回值不对，需要返回路径
    public String findShortestWay(int[][] maze, int[] ball, int[] destination) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        dfs(maze, start, distance);
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }

    private void dfs(int[][] maze, int[] start, int[] destination, int[][] distance) {
        int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}};
        for (int[] dir : dirs) {
            int x = start[0] + dir[0];
            int y = start[1] + dir[1];
            int desx = destination[0];
            int desy = destination[1];
            int count = 0;
            // 最后一个循环的时候，x y 已经走到不合法的位置了，需要退回来一个才是合法的
            // count 因为初始化为0了所以出while的时候还是合法的。（进入每个direction先加了1， 这样count其实是1， 但是初始化为0了）
            while(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0 
                    && x != desx && y != desy){
                x += dir[0];
                y += dir[1];
                count++;
            }
            if (distance[start[0]][start[1]] + count < distance[x- dir[0]][y - dir[1]]) {
                distance[x- dir[0]][y - dir[1]] = distance[start[0]][start[1]] + count;
                dfs(maze, new int[] {x- dir[0], y - dir[1]}, destination, distance);
            }

        }
    }
}
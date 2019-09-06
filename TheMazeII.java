import java.util.Queue;

class TheMazeII {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Position> queue = new PriorityQueue<Position>((p1, p2) -> (p1.distance - p2.distance));
        queue.add(new Position(start[0], start[1], 0));
        int[] dir_x = {1, 0, -1, 0};
        int[] dir_y = {0, 1, 0, -1};
        while(!queue.isEmpty()) {
            Position curr = queue.poll();
            int x = curr.x;
            int y = curr.y;
            if (x == destination[0] && y == destination[1]) {
                return curr.distance;
            }
            if (visited[x][y]) {
                continue;
            }
            visited[x][x] = true;
            for (int i = 0; i < 4; i++) {
                int nx = curr.x;
                int ny = curr.y;
                int len = curr.distance;
                while(nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 0) {
                    nx += dir_x[i];
                    ny += dir_y[i];
                    len++;
                }
                nx -= dir_x[i];
                ny -= dir_y[i];
                len--;
                queue.add(new Position(nx, ny, len));
                
            }
        }
        return -1;
    }

    class Position {
        int x;
        int y;
        int distance;
        public Position(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
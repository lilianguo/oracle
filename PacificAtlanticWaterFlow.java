class PacificAtlanticWaterFlow {
    // 从边框往里面bfs,pacific出发，能到达的都是pacfic true， atlantic出发，能到达的都是atlantic true, 
    // 如果 pacific atlantic都为true, 则添加到答案
    // bfs from ocean, find the place it could reach to going up, overlap would be the answer
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pq = new LinkedList<>();
        Queue<int[]> aq = new LinkedList<>();
        for (int i = 0; i < m; i ++) {
            pacific[i][0] = true;
            pq.add(new int[] {i, 0});
            atlantic[i][n - 1] = true;
            aq.add(new int[] {i, n - 1});
        }
        for (int j = 0; j < n; j++) {
            pacific[0][j] = true;
            pq.add(new int[] {0, j});
            atlantic[m - 1][j] = true;
            aq.add(new int[] {m - 1, j});
        }

        bfs(matrix, pq, pacific);
        bfs(matrix, aq, atlantic);
        // O(n^2)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(new ArrayList<>(list));
                }
            }
        }
        return res;
    }

    private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] canReach) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x =  curr[0];
            int y = curr[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < matrix.length && ny < matrix[0].length && !canReach[nx][ny] && matrix[nx][ny] >= matrix[x][y] ) {
                    queue.offer(new int[] {nx, ny});
                    canReach[nx][ny] = true;
                }
            }
        }
        return;
    }
}
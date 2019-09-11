class NumberOfIslandsII {
    // 305 
    // union find, 变相 merge island
    /*
    A 2d grid map of m rows and n columns is initially filled with water. 
    We may perform an addLand operation which turns the water at position (row, col) into a land. 
    Given a list of positions to operate, count the number of islands after each addLand operation. 
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
    You may assume all four edges of the grid are all surrounded by water.
    */
    
    // add path compression in find, updating the father for each node for faster find next time
    // deleted the print 
    // time ok this time
    
    private int[] father = null;
    private int find(int x) {
        if (father[x] == x) {
            return x;
        }
        int ancestor = father[x];
        while(ancestor != father[ancestor]) {
            ancestor = father[ancestor];
        }
        int fa = x;
        while (fa != father[fa]) {
            int tmp = father[fa];
            father[fa] = ancestor;
            fa = tmp;
        }
        return ancestor;
    }
    private void union(int x, int y) {
        int rootA = find(x);
        int rootB = find(y);
        if (rootA != rootB) {
            father[rootA] = rootB;
            size--;
        }
    }
    int size = 0;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int[][] isIsland = new int[m][n];
        if (positions == null || positions.length == 0) {
            return res;
        }

        father = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                father[i*n + j] = i*n + j;
            }
        }
        int[] dx = new int[] {1, 0, -1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            if (isIsland[x][y] == 1) {
                res.add(size);
                continue;
            }
            isIsland[x][y] = 1;
            size++;
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && isIsland[nx][ny] == 1) {
                    union(x * n + y, nx * n + ny);
                }
            }
            res.add(size);
        }
        return res;
    }
    
}
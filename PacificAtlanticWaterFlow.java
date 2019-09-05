class PacificAtlanticWaterFlow {
    //https://leetcode.com/problems/pacific-atlantic-water-flow/discuss/90828/Simple-java-dfs-solution
    class ResultType {
        boolean foundPacific;
        boolean foundAtlantic;
        public ResultType(boolean foundPacific, boolean foundAtlantic) {
            this.foundPacific = foundPacific;
            this.foundAtlantic = foundAtlantic;
        }
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean[][] both = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                ResultType result = dfs(matrix, i, j, visited, both);
                visited[i][j] = false;
                if (result.foundAtlantic && result.foundPacific) {
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    res.add(point);
                }
            }
        }
        return res;
    }

    private ResultType dfs(int[][] matrix, int i, int j, boolean[][] visited, boolean[][] both) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean foundPacific = false;
        boolean foundAtlantic = false;
        if (both[i][j]) {
            return new ResultType(true, true);
        }

        for (int dir = 0; dir < 4; dir++) {
            int x = i + dx[dir];
            int y = j + dy[dir];
            if (isAtlantic(matrix, x, y)) {
                foundAtlantic = true;
                continue;
            }
            if (isPacific(matrix, x, y)) {
                foundPacific = true;
                continue;
            }
            if (visited[x][y]) {
                continue;
            }

            if (matrix[i][j] > matrix[x][y]) {
                visited[x][y] = true;
                ResultType result = dfs(matrix, x, y, visited, both);
                visited[x][y] = false;
                if (result.foundAtlantic == true) {
                    foundAtlantic = true;
                }
                if (result.foundPacific == true) {
                    foundPacific = true;
                }
            }
        }
        if (foundAtlantic && foundPacific) {
            both[x][y] = true;
        }
        return new ResultType(foundPacific, foundAtlantic);
    }

    private isAtlantic(int[][] matrix, int x, int y) {
        return x == matrix.length || y == matrix[0].length;
    }

    private isPacific (int[][] matrix, int x, int y) {
        return x == -1 || y == -1;
    }
}
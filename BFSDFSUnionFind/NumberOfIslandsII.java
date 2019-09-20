class NumberOfIslandsII {

    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        UnionFind uf = new UnionFind(m*n);
        boolean[][] isIsland = new boolean[m][n];
        int[] dx = new int[] {1, 0, -1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        for (int[] position : positions) {
            if (isIsland) {
                res.add(uf.count);
            } else {
                isIsland[position[0]][position[1]] = true;
                uf.count++;
                for (int i = 0; i < 4; i++) {
                    int x = position[0] + dx[i];
                    int y = position[1] + dy[i];
                    if (x >= 0 && x < m && y >= 0 && y < n && isIsland[x][y]) {
                        uf.union(x * n + y, position[0] * n + position[1]);
                    }
                }
                res.add(uf.count);
            }
        }
    }
        return res; 
    }
}

class UnionFind {
    int[] father;
    int count;
    public UnionFind(int size) {
        father = new int[size];
        count = 0;
        for (int i = 0; i < size; i++) {
            father[i] = i;
        }
    }

    public void union (int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            father[rootA] = rootB;
            count--;
        }
    }

    private int find (int index) {
        if (father[index] == index) {
            return index;
        }
        int ancestor  = father[index];
        while(ancestor != father[ancestor]) {
            ancestor = father[ancestor];
        }

        int fa = index;
        while(fa != father[fa]) {
            int tmp = father[fa];
            father[fa] = ancestor;
            fa = tmp;
        }
        return ancestor;
    }
}
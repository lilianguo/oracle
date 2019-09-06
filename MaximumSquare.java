class MaximalSquare {
    // space O(mn)
    // time O(mn)
    // example
    /*
    1 0 1 0 0 
    1 0 1 1 1
    1 1 1 1 1 
    1 0 0 1 0
    */
    // dp 转移方程： dp[i][j] 表示右下角为 i,j的最小矩阵边长
    // 如果当前点为 1 的话， 它等于 （dp[左边] dp[上边] dp[左上] 的最小值）  + 1
    // take 点 (2,3) as example
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] maxiCount = new int[matrix.length][matrix[0].length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            maxiCount[i][0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(max, maxiCount[i][0]);
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    maxiCount[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } 
                if (i > 0 && j > 0 && matrix[i][j] == '1'){
                    maxiCount[i][j] = Math.min(maxiCount[i - 1][j - 1], Math.min(maxiCount[i - 1][j], maxiCount[i][j - 1])) + 1;
                }
                max = Math.max(maxiCount[i][j], max);
            }
        }
        return max;
    }
}

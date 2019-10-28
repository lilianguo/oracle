/*
221. Maximal Square
Medium

1698

41

Favorite

Share
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
*/
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
        if (matrix == null || matrix.length ==0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(dp[i][0], max);
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                }
                if (i > 0 && j > 0 && matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max*max;
    }
}

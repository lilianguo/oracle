class CoinChangeII {
    // 相同coin可无限次使用
    // time O(mn);
    // space O(n)
    public int change(int amount, int[] coins) {
        // https://www.youtube.com/watch?time_continue=78&v=jaNZ83Q3QGc
        // https://zhuanlan.zhihu.com/p/36210712
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]]; 
            }
        }
        return dp[amount];
    }


    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coints[i]];
            }
        }
        return dp[amount];
    }
}
class JumpGameII {
    // 45
    /*
    Given an array of non-negative integers, you are initially positioned at the first index of the array.
    Each element in the array represents your maximum jump length at that position.
    Your goal is to reach the last index in the minimum number of jumps.
    */
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (dp[j] + 1 < dp[i] && nums[j] + j >= i) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        return dp[nums.length - 1];
    }
}
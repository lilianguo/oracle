// 188. Best Time to Buy and Sell Stock IV
/*
Say you have an array for which the i-th element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example 1:

Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
*/
class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        if (k > n/2) {
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                maxProfit += prices[i] - prices[i - 1] > 0 ? prices[i] - prices[i - 1] : 0;
            }
            return maxProfit;
        }

        int[][] mustsell = new int[n + 1][n + 1]; // mustSell[i][j] 表示前i天，至多进行j次交易，第i天必须sell的最大获益
        int[][] globalbest = new int[n + 1][n + 1]; // globalbest[i][j] 表示前i天，至多进行j次交易，第i天可以不sell的最大获益

        mustsell[0][0] = globalbest[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            mustsell[0][i] = globalbest[0][i] = 0;
        }

        for (int i = 1; i < n; i++) {
            int gainorlose = prices[i] - prices[i - 1];
            mustsell[i][0] = 0;
            for (int j = 1; j <= k; j++) {
                mustsell[i][j] = Math.max(globalbest[(i - 1)][j - 1] + gainorlose, 
                                        mustsell[(i - 1)][j] + gainorlose);
                globalbest[i][j] = Math.max(globalbest[(i - 1)][j], mustsell[i][j]);
            }
        }
        return globalbest[(n - 1)][k];
    }

    // 滚动数组压缩空间
    public int maxProfitII(int k, int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        if (k > n/2) {
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                maxProfit += prices[i] - prices[i - 1] > 0 ? prices[i] - prices[i - 1] : 0;
            }
            return maxProfit;
        }

        int[] mustsell = new int[n + 1]; // mustSell[i][j] 表示前i天，至多进行j次交易，第i天必须sell的最大获益
        int[] globalbest = new int[n + 1]; // globalbest[i][j] 表示前i天，至多进行j次交易，第i天可以不sell的最大获益

        mustsell[0] = globalbest[0] = 0;
        for (int i = 1; i <= k; i++) {
            mustsell[i] = globalbest[i] = 0;
        }

        for (int i = 1; i < n; i++) {
            int gainorlose = prices[i] - prices[i - 1];
            mustsell[0] = 0;
            for (int j = 1; j <= k; j++) {
                mustsell[j] = Math.max(globalbest[j - 1] + gainorlose, 
                                        mustsell[j] + gainorlose);
                globalbest[j] = Math.max(globalbest[j], mustsell[j]);
            }
        }
        return globalbest[k];
        
    }
}
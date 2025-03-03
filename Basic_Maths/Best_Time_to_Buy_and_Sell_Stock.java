class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        int i = 0, j = 1;
        while (i < n && j < n) {
            if (prices[i] >= prices[j]) i = j;
            else maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            j++;
        }
        return maxProfit;
    }
}
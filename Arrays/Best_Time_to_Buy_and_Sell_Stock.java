class Solution {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                max = min;
            }
            if (prices[i] > max) max = prices[i];
            ans = Math.max(ans, max - min);
        }

        return ans;
    }
}
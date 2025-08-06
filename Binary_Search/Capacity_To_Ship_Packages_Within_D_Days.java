class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 1, high = 500;
        int temp = 0;
        for (int weight : weights) {
            low = Math.max(low, weight);
            temp += weight;
        }
        high = temp;

        while (low < high) {
            int mid = low + ((high - low) / 2);

            if (helper(weights, days, mid)) high = mid;
            else low = mid + 1;
        }

        return low;
    }

    public boolean helper(int[] weights, int days, int weight) {
        int sum = weights[0];
        int ans = 0;
        for (int i = 1; i < weights.length; i++) {
            if ((sum + weights[i]) > weight) {
                ans += (Math.ceil((double)sum / (double) weight));
                sum =  weights[i];
            }
            else sum += weights[i];
        }
        ans += (Math.ceil((double)sum / (double) weight));

        if (ans <= days) return true;
        else return false;
        
    }
}
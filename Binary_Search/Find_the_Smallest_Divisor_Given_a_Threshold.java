class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = (int) 1e6;
        int ans = 0;

        while (low < high) {
            int mid = low + ((high - low) / 2);
            int sum = 0;

            for (int num : nums) {
                sum += Math.ceil((double)num / (double) mid);
            }
            
            if (sum <= threshold) high = ans = mid;
            else low = mid + 1;
        }

        return ans;
    }
}
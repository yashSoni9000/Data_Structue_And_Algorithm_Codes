class Solution {
    public int maxProduct(int[] nums) {
        // return sol1(nums);

        return sol2(nums);
    }

    public int sol2(int[] nums) {
        int prefix = 1, suffix = 1;
        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix = nums[i] * prefix;
            suffix = nums[n - i - 1] * suffix;

            ans = Math.max(ans, Math.max(prefix, suffix));
        }

        return ans;
    }

    public int sol1(int[] nums) {
        int iMin = nums[0], iMax = nums[0], ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = iMin;
                iMin = iMax;
                iMax = temp;
            }

            iMin = Math.min(nums[i], nums[i] * iMin);
            iMax = Math.max(nums[i], nums[i] * iMax);

            ans = Math.max(ans, iMax);
        }
        return ans;
    }
}
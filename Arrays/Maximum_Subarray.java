class Solution {
    public int maxSubArray(int[] nums) {
        // int ans = Integer.MIN_VALUE;
        // for (int i = 0; i < nums.length; i++) {
        //     int count = 0;
        //     for (int j = i; j < nums.length; j++) {
        //         count += nums[j];
        //         ans = Math.max(count, ans);
        //     }
        // }

        // return ans;

        long sum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i] + sum;
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) sum = 0;
        }

        return (int) maxSum;
    }
}
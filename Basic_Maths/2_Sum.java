class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;

        // naive approach with n^2 complexity
        // naiveApproach(nums, ans, n);

        // optimal Approach
        optimalApproach(nums, ans, n);
    }

    public int[] optimalApproach(int[] nums, int[] ans, int n, int target) {
        int i = 0, j = 1;
        boolean isNegative = target < 0 ? true : false;
        for (int i = 0; i < n; i++) {
            if (isNegative) {
                if (nums[i] < target) {
                    
                }
            }
        }
    }

    public int[] naiveApproach(int[] nums, int[] ans, int n, int target) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
}
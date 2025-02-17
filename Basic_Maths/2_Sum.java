class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;

        // naive approach with n^2 complexity
        // return naiveApproach(nums, ans, n, target);

        // optimal Approach
        return optimalApproach(nums, ans, n, target);
    }

    public int[] optimalApproach(int[] nums, int[] ans, int n, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int diff = target - nums[i];
            if (mp.containsKey(diff)) {
                return new int[] {mp.get(diff), i};
            }
            mp.put(nums[i], i);
        }
        return new int[]{};
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
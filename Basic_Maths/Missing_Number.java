class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        // navie approach
        // return naiveApproach(nums, n);

        // subOptimal Approach
        return subOptimalApproach(nums, n);
        
        // optimal approach
        // return optimalApproach(nums, n);
    }

    public int optimalApproach(int[] nums, int n) {
        int sumOfN = (n * (n + 1)) / 2;
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += nums[i];
        }
        return sumOfN - currSum;
    }

    public int subOptimalApproach(int[] nums, int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans ^= i;
        }

        for (int i = 0; i < n; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    public int naiveApproach(int[] nums, int n) {
        int[] arr = new int[n + 1];
        int ans = 0;
        for (int i : nums) {
            arr[i]++;
        }

        for (int i = 0; i < n + 1; i++) {
            if (arr[i] == 0) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
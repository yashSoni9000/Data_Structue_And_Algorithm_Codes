class Solution {
    public int[] rearrangeArray(int[] nums) {
        // return naiveApproach(nums);

        return optimalSolution(nums);
    }

    public int[] optimalSolution(int[] nums) {
        int even = 0, odd = 1;
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                ans[odd] = nums[i];
                odd += 2; 
            }
            else {
                ans[even] = nums[i];
                even += 2;
            }
        }

        return ans;
    }

    public int[] naiveApproach(int[] nums) {
        int n = nums.length;
        int[] neg = new int[n / 2];
        int[] pos = new int[n / 2];
        int i = 0, j = 0;

        for (int num : nums) {
            if (num < 0) neg[i++] = num;
            else pos[j++] = num;
        }

        for (i = 0, j = 0; i < pos.length; i++) {
            nums[j++] = pos[i];
            nums[j++] = neg[i];
        }

        return nums;
    }
}
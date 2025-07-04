class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) return;

        // Step 1: Find the first pair from right where nums[i-1] < nums[i]
        int i = n - 1;
        while (i > 0 && nums[i-1] >= nums[i]) {
            i--;
        }

        // Step 2: If such a pair is found, find the smallest number on the right side
        // that is greater than nums[i-1] and swap them
        if (i > 0) {
            int j = n - 1;
            while (j >= i && nums[j] <= nums[i-1]) {
                j--;
            }
            swap(nums, i-1, j);
        }

        // Step 3: Reverse the subarray from i to the end
        reverse(nums, i, n-1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
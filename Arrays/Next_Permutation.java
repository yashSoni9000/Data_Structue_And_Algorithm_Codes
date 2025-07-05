class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 1) return;
        int i = n - 1, j = n - 1;
        
        while (i > 0 && (nums[i] <= nums[i - 1])) i--;
        if (i == 0) {
            reverse(0, n - 1, nums);
            return;
        }
        while (j != i && (nums[j] <= nums[i - 1])) j--;

        swap(j, i - 1, nums);
        reverse(i, n - 1, nums);
    }

    public void reverse(int start, int end, int[] nums) {
        while (start <= end) swap(start++, end--, nums);
    }

    public void swap(int first, int second, int[] nums) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
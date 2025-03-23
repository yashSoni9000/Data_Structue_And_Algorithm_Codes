class Solution {
    public int findMin(int[] nums) {
        int n = nums.length - 1;
        int low = 0, high = n;
        int ans = 0;

        while (low < high) {
            int mid = low + ((high - low) / 2);

            if (nums[mid] >= nums[0]) {
                if (nums[n] < nums[mid]) low = mid + 1;
                else high = mid;
            }
            else {
                if (nums[0] > nums[mid]) high = mid;
                else low = mid + 1;
            }
        }
        ans = nums[low];

        return ans;
    }
}
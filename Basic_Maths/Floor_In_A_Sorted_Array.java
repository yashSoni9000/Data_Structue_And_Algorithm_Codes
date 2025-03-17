class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                ans = mid;
                break;
            }
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }

        return ans;
    }
}
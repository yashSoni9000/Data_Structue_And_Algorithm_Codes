class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + ((high - low + 1) / 2);
            if (nums[mid] <= target) low = mid;
            else high = mid - 1;
        }

        if (nums[low] >= target) return low;
        else return low + 1;
        
    }
}
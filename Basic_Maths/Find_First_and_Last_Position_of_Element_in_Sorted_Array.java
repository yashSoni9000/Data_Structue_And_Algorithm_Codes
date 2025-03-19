class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return new int[]{-1, -1};

        int low = 0, high = n - 1;
        int first = -1, last = -1;

        while (low < high) {
            int mid = low + ((high - low + 1) / 2);
            if (nums[mid] <= target) low = mid;
            else high = mid - 1;
        }
        
        if (nums[low] == target) last = low;

        low = 0;
        high = n - 1;

        while (low < high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] >= target) high = mid;
            else {
                low = mid + 1;
            }
        }
 
        if (nums[high] == target) first = high;

        return new int[]{first, last};
    }
}
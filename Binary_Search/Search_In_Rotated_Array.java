class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length - 1;
        int low = 0, high = n;
        int pivot = 0;

        while (low < high) {
            int mid = low + ((high - low) / 2);

            if(nums[mid] > nums[n]) low = mid + 1;
            else high = mid;
        }
        pivot = low;

        low = 0;
        high = n;

        
        while (low <= high) {
            int mid = low + ((high - low + 1) / 2);
            
            int curr = (mid + pivot) % nums.length;
            if (nums[curr] == target) return curr;
            if(nums[curr] < target) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }
}
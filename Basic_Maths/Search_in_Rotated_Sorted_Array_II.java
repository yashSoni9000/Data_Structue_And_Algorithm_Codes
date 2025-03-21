class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length - 1;
        int low = 0, high = n;

        // while (low < high) {
        //     int mid = low + ((high - low) / 2);

        //     if (nums[mid] >= nums[n]) low = mid + 1;
        //     else high = mid; 
        // }

        // int pivot = high;

        // low = 0;
        // high = n;

        // // while (low < high) {
        // //     int mid = low + ((high - low) / 2);

        // //     if (nums[mid] >= nums[pivot]) high = mid;
        // //     else low = mid + 1;
        // // }

        // // pivot = high;

        // while (low <= high) {
        //     int mid = low + ((high - low + 1) / 2);
        //     int curr = (mid + pivot) % nums.length;

        //     if (nums[curr] == target) return true;
        //     else if (nums[curr] < target) low = mid + 1;
        //     else high = mid - 1;
        // }

        return optimal(nums, target);
    }

    public boolean optimal(int[] nums, int target) {
        int n = nums.length - 1;
        int low = 0, high = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (target == nums[mid]) return true;

            if (nums[low] < nums[mid]) {
                if (nums[low] <= target && nums[mid] > target) high = mid - 1;
                else low = mid + 1;
            }
            else if (nums[low] == nums[mid]) low++;
            else {
                if (nums[mid] < target && nums[high] >= target) low = mid + 1;
                else high = mid - 1;
            }
        }

        return false;
    }
}
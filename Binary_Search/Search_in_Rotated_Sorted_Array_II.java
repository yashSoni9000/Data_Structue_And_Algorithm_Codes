class Solution {
    public boolean search(int[] nums, int target) {
        return anotherSolution(nums, target);

        // return optimal(nums, target);
    }

    public boolean anotherSolution(int[] nums, int target) {
        int n = nums.length - 1;
        int low = 0, high = n;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (nums[mid] == target) return true;

            if (nums[mid] == nums[low] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target <= nums[mid]) high = mid - 1;
                else low = mid + 1;
            }
            else {
                if (target >= nums[mid] && target <= nums[n]) low = mid + 1;
                else high = mid - 1;
            }
        }

        return false;
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
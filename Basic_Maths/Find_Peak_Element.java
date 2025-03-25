class Solution {
    public int findPeakElement(int[] nums) {
        // return solution(nums);

        return coolerSolution(nums);
    }

    public int coolerSolution(int[] nums) {
        int n = nums.length - 1;
        if (n == 0) return 0;

        int low = 0, high = n;
        int ans = 0;

        while (low < high) {
            int mid1 = low + ((high - low) / 2);
            int mid2  = mid1 + 1;

            if (nums[mid1] < nums[mid2]) low = mid2;
            else high = mid1;
        }

        return low;
    }

    public int solution(int[] nums) {
        int n = nums.length - 1;
        if (n == 0) return 0;

        int low = 0, high = n;
        int ans = 0;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if ((mid == n && nums[mid - 1] < nums[mid]) || (mid == 0 && nums[mid + 1] < nums[mid]) || (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1])) {
                ans = mid;
                break;
            }

            if (nums[mid] < nums[mid + 1]) low = mid + 1;
            else high = mid - 1;
        }

        return ans;
    }
}
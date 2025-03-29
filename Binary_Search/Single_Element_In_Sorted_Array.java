class Solution {
    public int singleNonDuplicate(int[] nums) {
        // return naiveApproach(nums);

        return coolerApproach(nums);
    }

    public int coolerApproach(int[] nums) {
        int n = nums.length - 1;
        int low = 0, high = n;

        while (low < high) {
            int mid = low + ((high - low) / 2);
            
            if ((mid % 2) == 1) mid--;

            if (nums[mid] != nums[mid + 1]) high = mid;
            else low = mid + 2;
        }

        return nums[low];
    }

    public int naiveApproach(int[] nums) {
        int n = nums.length - 1;
        if (n == 0) return nums[0];
        int low = 0, high = n;
        int ans = 0;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if ((mid == 0 && nums[mid] != nums[mid + 1]) || ((mid == n && nums[mid] != nums[mid - 1])) || ((nums[mid] != nums[mid + 1]) && (nums[mid] != nums[mid - 1]))) {
                ans = nums[mid];
                break;
            }

            if (nums[mid] == nums[mid + 1]) {
                if ((n - mid + 1) % 2 == 0) high = mid - 1;
                else low = mid;
            }
            else if (nums[mid] == nums[mid - 1]) {
                if ((mid - low + 1) % 2 == 0) low = mid + 1;
                else high = mid;
            }
        }

        return ans;
    }
}
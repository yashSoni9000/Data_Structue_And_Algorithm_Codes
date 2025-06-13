class Solution {
    public boolean check(int[] nums) {
        int len = nums.length;
        int prev = len - 1;
        int curr = 0, flag = 0;

        for (int i = 0; i < len; i++) {
            if (nums[prev] > nums[curr]) flag++;
            if (flag > 1) return false;
            prev = (prev + 1) % len;
            curr++;
        }

        return true; // Return true if flag <= 1
    }
}
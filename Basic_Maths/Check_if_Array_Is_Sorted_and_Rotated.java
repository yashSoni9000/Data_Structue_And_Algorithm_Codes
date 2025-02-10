class Solution {
    public boolean check(int[] nums) {
        if (nums.length == 1) return true;

        // naive approach wrong answer
        // int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] > max) max = nums[i];
        //     if (nums[i] < min) min = nums[i];
        // }

        // for (int i = 0; i < nums.length - 1; i++) {
        //     if (nums[i] > nums[i + 1] && (nums[i] != max || nums[i + 1] != min)) return false;
        // }

        // return true;

        // optimal approach correct answer
        int count = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) count++;
            if (count > 1) return false;
        }
        return true;
    }
}
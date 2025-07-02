class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] neg = new int[n / 2];
        int[] pos = new int[n / 2];
        int i = 0, j = 0;

        for (int num : nums) {
            if (num < 0) neg[i++] = num;
            else pos[j++] = num;
        }

        for (i = 0, j = 0; i < pos.length; i++) {
            nums[j++] = pos[i];
            nums[j++] = neg[i];
        }

        return nums;
    }
}
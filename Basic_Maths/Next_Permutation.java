class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int breakPoint = n - 2;

        // finding index with decreasing from right to get a break point
        while (breakPoint >= 0 && nums[breakPoint] >= nums[breakPoint + 1] ) breakPoint--;

        if (breakPoint >= 0) {
            int nextBreakPoint = n - 1; 

            // finding smallest largest index number after break point
            while (nums[breakPoint] >= nums[nextBreakPoint]) nextBreakPoint--;

            // swap 2 numbers
            swap(nums, breakPoint, nextBreakPoint);
        }
        
        // reverse numbers after break point till end of array to get our answer
        reverse(nums, breakPoint + 1, n - 1);
    }

    public void reverse(int[] nums, int first, int last) {
        while (first <= last) {
            swap(nums, first++, last--);
        }
    }

    public void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
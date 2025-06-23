class Solution {
    public void sortColors(int[] nums) {
        // subOptimalSolution(nums);

        optimalSolution(nums);
    }
    public void subOptimalSolution(int[] nums) {
        int[] ans = new int[3];
        for (int i = 0; i < nums.length; i++) ans[nums[i]]++;

        int j = 0;        
        for(int i = 0; i < 3; i++) {
            while(ans[i] != 0){
                nums[j++] = i;
                ans[i]--;
            }
        }
    }

    public void optimalSolution(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) swap(low++, mid++, nums);
            else if (nums[mid] == 2) swap(mid, high--, nums);
            else mid++;
        }
    }
    public void swap(int low, int high, int[] nums) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }
}
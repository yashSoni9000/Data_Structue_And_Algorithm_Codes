class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        
        // naive solution
        // naiveSolution(nums, k);

        // storing in array solution
        // if (length > 1) {
        //     arraySolution(nums, k, length - 1);
        // }

        // sub optimal solution with O(n) SC and O(n) TC
        subOptimalSolution(nums, k, length);

        // optimal solution with O(1) SC and O(n) TC
        // optimalSolution(nums, k, length - 1);
    }

    // optimal solution
    public void optimalSolution(int[] nums, int k, int length) {
        reverse(nums, 0, length);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length);
    }

    // optimal solution reverse array
    public void reverse(int[] nums , int low, int high) {
        while (low <= high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }

    // sub optimal solution
    public void subOptimalSolution(int[] nums, int k, int length) {
        int[] rotate = new int[length];
        for (int i = 0; i < length; i++) {
            rotate[(i + k) % length] = nums[i];
        }

        for (int i = 0; i < length; i++) {
            nums[i] = rotate[i];
        }
    }

    // array solution
    public void arraySolution(int[] nums, int k, int length) {
        int[] helpArr = new int[k];
        
        int j = 0;
        for (int i = length - k + 1; i <= length; i++) {
            helpArr[j++] = nums[i];
        }
        
        for (int i = length; i >=  k; i--){
            nums[i] = nums[i - k];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = helpArr[i];
        }
    }

    // naive solution
    public void naiveSolution(int[] nums, int k, int length) {
        for (int j = 0; j < k; j++){
            int last = nums[length - 1];
            for (int i = length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = last;
        }
    }
}
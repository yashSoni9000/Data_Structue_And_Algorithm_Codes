class Solution {
    public int[] selectionSort(int[] nums) {
      for (int i = 0; i < nums.length - 1; i++) {
        int min = nums[i + 1], index = i + 1;
        for (int j = i + 1; j < nums.length; j++) {
          if (nums[j] < min) {
            min = nums[j];
            index = j;
          }
        }
        if (nums[i] > min) {
          int temp = nums[i];
          nums[i] = nums[index];
          nums[index] = temp;
        }
      }
      return nums;
    }
  }
  
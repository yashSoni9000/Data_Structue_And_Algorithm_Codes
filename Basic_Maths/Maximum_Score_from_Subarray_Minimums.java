class Solution {
    // Function to find pair with maximum sum
    public int pairWithMaxSum(int nums[]) {
        // Your code goes here
        int maxSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int first = nums[i];
            int second = nums[i + 1];
            if (first + second > maxSum) maxSum = first + second;
        }
        
        return maxSum;
    }
}
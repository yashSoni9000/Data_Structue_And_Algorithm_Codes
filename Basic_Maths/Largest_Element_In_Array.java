class Solution {
    public static int largest(int[] arr) {
        // code here
        int ans = Integer.MIN_VALUE;
        
        // Iterative approach
        // for (int i = 0; i < arr.length; i++) {
        //     if (arr[i] > ans) ans = arr[i];
        // }
        
        // Using Recursion here
        return large(arr, ans, 0);
        
        // Using Inbuilt sorting here
        // Arrays.sort(arr);
        // return arr[arr.length -1];
    }
    
    // using recursion
    public static int large(int[] arr, int ans, int index) {
        
        if (index == arr.length) return ans;
        
        if (arr[index] > ans) ans = arr[index];
        
        return large(arr, ans, index + 1);
    }
}

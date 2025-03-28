class Solution {

    static int findFloor(int[] arr, int x) {
        // write code here
        int n = arr.length;
        int low = 0, high = n - 1;
        
        while (low < high) {
            int mid = low + ((high - low + 1) / 2);
            
            if (arr[mid] <= x) low = mid;
            else high = mid - 1;
        }
        
        return (arr[low] <= x) ? low : -1;
    }
}

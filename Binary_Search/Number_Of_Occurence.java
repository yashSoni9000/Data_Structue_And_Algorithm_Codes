class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int n = arr.length -1;
        int low = 0, high = n;
        int start = -1, end = -1;
        int ans = 0;
        
        while (low < high) {
            int mid = low + ((high - low + 1) / 2);
            if (arr[mid] <= target) low = mid;
            else high = mid - 1;
        }
        
        if (arr[low] == target) end = low;
        low = 0;
        high = n;
        
        while (low < high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] >= target) high = mid;
            else low = mid + 1;
        }
        
        start = high;
        
        return (end == -1) ? 0 : (end - start + 1);
    }
}
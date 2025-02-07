class Solution {
    static boolean searchInSorted(int arr[], int k) {
        // Your code here
        int low = 0, high = arr.length - 1;
        // boolean ans = false;
        // while (low <= high) {
            
        //     int mid = low + (high - low) / 2;
            
        //     if (arr[mid] == k){
        //         ans = true;
        //         break;
        //     }
        //     else if(arr[mid] < k) low = mid + 1;
        //     else high = mid - 1;
        // }
        
        return binarySearch(arr, low, high, k);
    }
    
    // recursive approach
    static boolean binarySearch(int[] arr, int low, int high, int k) {
        
        if (low > high) return false;
            
        int mid = low + (high - low) / 2;
        
        if ( arr[mid] == k) return true;
        else if (arr[mid] < k) return binarySearch(arr, mid + 1, high, k);
        else return binarySearch(arr, low, mid - 1, k);
    }
}
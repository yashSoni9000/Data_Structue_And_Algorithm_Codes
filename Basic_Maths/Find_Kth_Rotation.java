class Solution {
    public int findKRotation(List<Integer> arr) {
        // Code here
        int n = arr.size() - 1;
        int low = 0, high = n;
        
        while (low < high) {
            int mid = low + ((high - low) / 2);
            
            if (arr.get(mid) > arr.get(n)) low = mid + 1;
            else high = mid;
        }
        
        return low;
    }
}
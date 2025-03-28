class Solution {
    public int nthRoot(int n, int m) {
        // code here
        int low = 1, high = m;
        
        while (low <= high) {
            int mid = low + ((high - low ) / 2);
            long ans = 1;
            
            for (int i = 0; i < n; i++) {
                if (ans > (Long.MAX_VALUE / mid)) break;
                ans *= mid;
            }
                        
            if (ans == m) return mid;
            else if (ans > m) high = mid - 1;
            else low = mid + 1;
        }
        
        return -1;
    }
}
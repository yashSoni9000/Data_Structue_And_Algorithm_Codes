class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        // return naiveApproach(a, b, k);

        return optimalApproach(a, b, k);
    }

    public int naiveApproach(int[] a, int[] b, int k) {
        int aLen = a.length, bLen = b.length;
        
        int firstPtr = 0, secondPtr = 0;
        int count = 0, ans = 0;
        
        while (firstPtr < aLen && secondPtr <bLen) {
            count++;
            if (a[firstPtr] < b[secondPtr]) {
                if (count == k) {
                    ans = a[firstPtr];
                    break;
                }
                firstPtr++;
            }
            else {
                if (count == k) {
                    ans = b[secondPtr];
                    break;
                }
                secondPtr++;
            }
        }
        
        while (firstPtr < aLen) {
            count++;
            if (count > k) break;
            if (count == k) {
                ans = a[firstPtr];
                break;
            }
            firstPtr++;
        }
        while (secondPtr < bLen) {
            count++;
            if (count > k) break;
            if (count == k) {
                ans = b[secondPtr];
                break;
            }
            secondPtr++;
        }
        
        return ans;
    }

    public int optimalApproach(int[] a, int[] b, int k) {
        int n1 = a.length;
        int n2 = b.length;
        
        if (n1 > n2) return kthElement(b, a, k);
        
        int low = Math.max(0, k - n2), high = Math.min(k, n1);
        
        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = k - mid1;
            
            int l1 = (mid1 - 1) >= 0 ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 - 1) >= 0 ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = mid1 < n1 ? a[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < n2 ? b[mid2] : Integer.MAX_VALUE;
            
            if (l1 <= r2 && l2 <= r1) return Math.max(l1, l2);
            else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        
        return 0;
    }
}
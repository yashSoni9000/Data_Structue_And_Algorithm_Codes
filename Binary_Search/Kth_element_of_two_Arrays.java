class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
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
}
class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long nn = (long) n;
        if (nn < 0) nn = -nn;
        
        while (nn > 0) {
            if ((nn & 1) == 1) ans *= x;
            x *= x;
            nn >>= 1;
        }
        
        return n < 0 ? 1.0 / ans : ans;
    }
}
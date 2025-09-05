class Solution {
    public double myPow(double x, int n) {
        long num = n;

        if (n < 0) {
            x = 1 / x;
            num = -n;
        }

        return pow(x, num);
    }

    public double pow(double x, long n) {
        if (n == 0) return 1;

        if (n % 2 == 0) return pow(x * x, n / 2);
        return x * pow(x * x, n / 2);
        
    }
}
class Solution {
    long MOD = 1_000_000_007L;

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2; 
        long odd = n / 2;        

        return (int)((pows(5, even) * pows(4, odd)) % MOD);
    }

    public long pows(long x, long n) {
        if (n == 0) return 1;

        long half = pows((x * x) % MOD, n / 2);
        if (n % 2 == 0) {
            return half;
        }
        
        return (half * x) % MOD;
    }
}
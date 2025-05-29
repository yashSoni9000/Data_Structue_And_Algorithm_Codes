class Solution {
    long MOD = 1_000_000_007L;

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;

        return (int) ((pows(5, even) % MOD) * (pows(4, odd) % MOD) % MOD);
    }

    public long pows(long x, long n) {
        if(n == 0) return 1;

        if (n % 2 == 0) return pows((x * x) % MOD, n / 2);

        return (pows((x * x) % MOD, n / 2) * x) % MOD;
    }
}
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        return naiveSolution(bloomDay, m, k);
    }

    public int naiveSolution(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if (((long) m * k) > n)
            return -1;

        int low = 1, high = 1000000000;

        while (low < high) {
            int mid = low + ((high - low) / 2);
            if (helper(bloomDay, m, k, mid)) high = mid;
            else low = mid + 1;
        }

        return low;
    }
    public boolean helper(int[] bloomDay, int m, int k, int day) {
        int count = 0;
        int ans = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) count++;
            else {
                ans += (count / k);
                count = 0;
            }
        }
        ans += (count / k);
        if (ans >= m) return true;
        else return false;
    }
}
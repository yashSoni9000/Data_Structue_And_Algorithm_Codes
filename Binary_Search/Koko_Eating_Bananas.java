class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        return naiveSolution(piles, h);

        // return optimalSolution(piles, h);
    }

    // public int optimalSolution(int[] piles, int h) {
    // }

    public int naiveSolution(int[] piles, int h) {
        int low = 1, high = 1000000000;
        int minAns = high;

        while (low < high) {
            int ans = 0;
            int mid = low + ((high - low) / 2);

            for (int pile : piles) ans += Math.ceil((double)pile / (double)mid);

            if (ans <= h) {
                minAns = mid;
                high = mid;
            }
            else low = mid + 1;
        }


        return minAns;
    }
}
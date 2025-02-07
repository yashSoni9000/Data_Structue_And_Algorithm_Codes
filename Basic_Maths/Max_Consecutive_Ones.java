class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currConsFreq = 0, maxConsFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currConsFreq++;

                // just checking when freq increases || striver method
                maxConsFreq = Math.max(currConsFreq, maxConsFreq);
            } 
            else {
                // my method || tedious
                // if (currConsFreq > maxConsFreq) maxConsFreq = currConsFreq;
                currConsFreq = 0;
            }
            // leetcoder's method || but checked every time
            maxConsFreq = Math.max(currConsFreq, maxConsFreq);
        }

        // my method || tedious
        // if (currConsFreq > maxConsFreq) maxConsFreq = currConsFreq;

        // not even need to do this as well as ans we will get from loop will be final
        // maxConsFreq = Math.max(currConsFreq, maxConsFreq);
        return maxConsFreq;
    }
}

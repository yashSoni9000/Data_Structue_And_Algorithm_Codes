class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        int ans = 0;

        for (int num : nums) hs.add(num);

        for (int curr : hs) {
            if (!hs.contains(curr - 1)) {
                int temp = curr + 1,  count = 1;
                while (hs.contains(temp)) {
                    count++;
                    temp++;
                }
                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
}
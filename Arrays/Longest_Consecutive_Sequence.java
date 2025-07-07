class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        Set<Integer> hs = new HashSet<>();
        int ans = 0;

        for (int num : nums) hs.add(num);

        for (int curr : hs) {
            if (!hs.contains(curr - 1)) {
                int count = 0;
                int next = curr;

                while (hs.contains(next)) {
                    count++;
                    next++;
                }
                ans = Math.max(count, ans);
            }
        }

        return ans;
    }
}
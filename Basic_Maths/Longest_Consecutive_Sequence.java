class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Map<Integer,Integer> mp = new HashMap<>();

        for (int num : nums) {
            if (!mp.containsKey(num)) {
                int left = (mp.containsKey(num - 1) ? mp.get(num - 1) : 0);
                int right = (mp.containsKey(num + 1) ? mp.get(num + 1) : 0);

                int sum = left + right + 1;
                mp.put(num, sum);

                ans = Math.max(ans, sum);

                mp.put(num - left, sum);
                mp.put(num + right, sum);
            }
        }
        return ans;
    }
}
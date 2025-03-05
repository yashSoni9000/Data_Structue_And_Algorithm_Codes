class Solution {
    public int longestConsecutive(int[] nums) {
        // return subOptimal(nums);

        return optimal(nums);
    }

    public int optimal(int[] nums) {
        int ans = 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums) hs.add(num);

        for (int num : nums) {
            if (!hs.contains(num - 1)) {
                int temp = ++num;
                int freq = 1;
                while (hs.contains(temp++)) freq++;

                ans = Math.max(ans, freq);
            }
        }

        return ans;
    }

    public int subOptimal(int[] nums) {
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
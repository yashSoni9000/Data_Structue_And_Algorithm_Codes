class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int half = n / 2;
        
        // takes O(n) SC
        // return myApproach(nums, half, n);

        // takes O(1) SC with O(n) TC
        return optimalApproach(nums ,n);
    }

    public int optimalApproach(int[] nums ,int n) {
        int count = 0, candidate = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            if (candidate == nums[i]) count++;
            else count--;
        }
        return candidate;
    }

    public int myApproach(int[] nums, int half, int n) {
        int ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (mp.containsKey(nums[i])) {
                mp.put(nums[i], mp.get(nums[i])+ 1);
            }
            else mp.put(nums[i], 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int freq = (int) entry.getValue();
            if (freq > half) {
                ans = (int) entry.getKey();
                break;
            }
        }
        return ans;
        
    }
}

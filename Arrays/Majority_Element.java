class Solution {
    public int majorityElement(int[] nums) {
        // return subOptimalSolution(nums);

        return optimalSolution(nums);
    }

    public int subOptimalSolution(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = nums.length, ans = 0;

        for (int num : nums) {
            int temp = mp.getOrDefault(num, 0);
            // System.out.println(temp);
            mp.put(num, ++temp);
        }

        for(Map.Entry<Integer, Integer> me : mp.entrySet()) {
            System.out.println(me.getValue());
            if (me.getValue() > n / 2) {
                ans = me.getKey();
                break;
            }
        }

        return ans;
    }

    public int optimalSolution(int[] nums) {
        int ans = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) ans = nums[i];
            if (nums[i] == ans) count++;
            else count--;
        }
        return ans;
    }
}
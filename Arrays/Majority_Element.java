class Solution {
    public int majorityElement(int[] nums) {
        return subOptimalSolution(nums);
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
}
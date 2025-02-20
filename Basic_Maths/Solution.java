import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int half = n / 2;
        
        return myApproach(nums, half, n);
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
        
        for (Map.Entry entry : mp.entrySet()) {
            int freq = (int) entry.getValue();
            if (freq > half) {
                ans = (int) entry.getKey();
                break;
            }
        }
        return ans;
    }
}

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // sub optimal with O(N) SC
        // return subOptimal(nums);

        // optimal solution with O(1) SC
        return optimal(nums);
    }

    // optimal solution
    public List<Integer> optimal(int[] nums) {
        int major = nums.length / 3;
        List<Integer> ans = new ArrayList<>();
        int ele1 = Integer.MIN_VALUE, ele1Cnt = 0, ele2 = Integer.MIN_VALUE, ele2Cnt = 0;

        for (int num : nums) {
            if (ele1 == num) ele1Cnt++;
            else if (ele2 == num) ele2Cnt++;
            else if (ele1Cnt == 0) {
                ele1 = num;
                ele1Cnt++;
            }
            else if (ele2Cnt == 0) {
                ele2 = num;
                ele2Cnt++;
            }
            else {
                ele1Cnt--;
                ele2Cnt--;
            }
        }   

        ele1Cnt = 0;
        ele2Cnt = 0;

        for (int num : nums) {
            if (num == ele1) ele1Cnt++;
            else if (num == ele2) ele2Cnt++;
        }  

        if (ele1Cnt > major) ans.add(ele1);
        if (ele2Cnt > major) ans.add(ele2);   

        return ans;
    }

    // sub Optimal solution
    public List<Integer> subOptimal(int[] nums) {
        int major = nums.length / 3;
        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            int count = mp.getOrDefault(num, 0);
            mp.put(num, count + 1);
        }

        for (Map.Entry ele : mp.entrySet()) {
            int freq = (int) ele.getValue();
            if (freq > major) {
                ans.add((int) ele.getKey());
            }
        } 

        return ans;
    }
}
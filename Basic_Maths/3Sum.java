class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        // sub optimal solution with lots of sorting
        // return subOptimal(nums, n);

        // most optimal with only 1 sorting
        return optimal(nums, n);
    }

    public List<List<Integer>> optimal(int[] nums, int n) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) j++;
                else if (sum > 0) k--;
                else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);

                    ans.add(temp);

                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> subOptimal(int[] nums, int n) {
        HashSet<List<Integer>> hs = new HashSet<>();

        for (int i = 0; i < n; i ++) {
            Set<Integer> mp = new HashSet<>();
            for (int j = (i + 1); j < n; j++) {
                int diff = -(nums[i] + nums[j]);
                if (mp.contains(diff)) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(diff);
                    curr.add(nums[j]);

                    Collections.sort(curr);
                    hs.add(curr);
                }
                mp.add(nums[j]);
            }
        }
        ArrayList<List<Integer>> ans = new ArrayList<>(hs);
        return ans;
    }
}
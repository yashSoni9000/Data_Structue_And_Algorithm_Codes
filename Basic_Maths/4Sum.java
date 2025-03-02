class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> ans = new HashSet<>();
        
        int n = nums.length;

        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            for (int l = i + 1; l < n; l++) {

                int j = l + 1;
                int k = n - 1;
                while (j < k) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < target)
                        j++;
                    else if (sum > target)
                        k--;
                    else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);

                        ans.add(temp);

                        j++;
                        k--;
                    }
                }
            }
        }

        List<List<Integer>> finalAns = new ArrayList<>(ans);
        return finalAns;
    }
}
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> ans = new HashSet<>();
        
        int n = nums.length;

        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            for (int l = i + 1; l < n; l++) {
                // if (l > 0 && nums[l] == nums[l - 1])
                //     continue;

                int j = l + 1;
                int k = n - 1;
                    // System.out.println(nums[i] + " " + nums[l] + " " + nums[j] + " " + nums[k] + " ");
                while (j < k) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    // System.out.println(sum);
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
                        // while (j < k && nums[j] == nums[j - 1])
                        //     j++;
                        // while (j < k && nums[k] == nums[k + 1])
                        //     k--;
                    }
                }
            }
        }

        List<List<Integer>> finalAns = new ArrayList<>(ans);
        return finalAns;
    }
}
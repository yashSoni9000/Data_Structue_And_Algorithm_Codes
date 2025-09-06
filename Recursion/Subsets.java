class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        helper(ans, temp, nums, 0);

        return ans;
    }

    public void helper(List<List<Integer>> ans, List<Integer> temp, int[] nums, int start) {
        if (start == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[start]);
        helper(ans, temp, nums, start + 1);
        temp.remove(temp.size() - 1);

        helper(ans, temp, nums, start + 1);
        
    }
}
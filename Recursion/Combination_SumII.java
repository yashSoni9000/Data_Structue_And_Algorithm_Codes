class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(ans, new ArrayList<>(), candidates, target, 0);

        return ans;
    }

    public void helper(List<List<Integer>> ans, List<Integer> nums, int[] candidates, int target, int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(nums));
            return;
        }

        // If the sum is negative or we have exhausted the candidates, return
        if (target < 0 || index == candidates.length) return; 

        // Include the current candidate
        nums.add(candidates[index]);

        // Recursively call with updated sum and next index
        helper(ans, nums, candidates, target - candidates[index], index + 1);

        // Backtrack by removing the last added candidate
        nums.remove(nums.size() - 1);

        // Skip duplicates: move to the next different candidate
        int next = index + 1;
        while (next < candidates.length && candidates[next] == candidates[index]) {
            next++;
        }
        if (next < candidates.length) {
            helper(ans, nums, candidates, target, next);
        }
    }
}
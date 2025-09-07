class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);

        helper(ans, new ArrayList<>(), candidates, target, 0);

        return ans;
    }
    

    public void helper(List<List<Integer>> ans, List<Integer> temp, int[] candidates, int target, int index) {
        if (target < 0) return;
        else if (target == 0) ans.add(new ArrayList<>(temp));
        else {
            for (int i = index; i < candidates.length; i++) {
                temp.add(candidates[i]);
                helper(ans, temp, candidates, target - candidates[i], i);
                temp.remove(temp.size() - 1);
                
            }
        }
    }
}
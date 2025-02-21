class Solution {
    public ArrayList<Integer> leaders(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        int currentMax = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = (n - 1); i >=0; i--) {
            if (arr[i] > currentMax) {
                ans.add(arr[i]);
                currentMax = arr[i];
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
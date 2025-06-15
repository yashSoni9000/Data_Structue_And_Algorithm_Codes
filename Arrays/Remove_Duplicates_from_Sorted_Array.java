class Solution {
    public int removeDuplicates(int[] arr) {
        int ans = 1, index = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i - 1]){
                ans++;
                arr[++index] = arr[i];
            }
        }
        
        return ans;
    }
}
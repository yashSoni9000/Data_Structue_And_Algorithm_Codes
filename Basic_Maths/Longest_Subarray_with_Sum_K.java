class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
         int length = 0, sum = 0;
         Map<Integer, Integer> mp = new HashMap<>();
         for (int i = 0; i < arr.length; i++) {
             sum += arr[i];
             
             if (sum == k){
                 length = i + 1;
                 continue;
             }
             
             int diff = sum - k;
             
             if (mp.containsKey(diff)) {
                 length = Math.max(i - mp.get(diff), length);
             }
             
             if (!mp.containsKey(sum)) mp.put(sum, i);
         }
         return length;
    }
}

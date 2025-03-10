class Solution {
    int maxLen(int arr[]) {
        // code here
        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0, length = 0;
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            if (sum == 0) {
                length = i + 1;
                continue;
            }
            
            int diff = sum;
            
            if (mp.containsKey(diff)) {
                length = Math.max(i - mp.get(diff), length);
            }
            
            if (!mp.containsKey(sum)) mp.put(sum, i);
        }
        
        return length;
    }
}
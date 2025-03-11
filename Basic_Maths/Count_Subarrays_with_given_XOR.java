class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int sum = 0, length = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!mp.containsKey(sum)) mp.put(sum, 1);
            else mp.put(sum, mp.get(sum) + 1);
            
            sum ^= arr[i];
            
            int diff = (sum ^ k);
            
            if (mp.containsKey(diff)) length += mp.get(diff);
        }
        
        return length;
    }
}
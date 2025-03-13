class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        
        // hashmap approach with TC O(n) but SC is (n) as well
        // return mapApproach(arr);
        
        // math solution TC O(n) SC O(1)
        return mathApproach(arr);
    }
    
    ArrayList<Integer> mathApproach(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        long n = arr.length;
        long repeating = 0, missing = 0;
        long sum =(n * (n + 1)) / 2;
        long sqSum =(n * (n + 1) * ((2 * n) + 1)) / 6;
        
        long currSum = 0, currSqSum = 0;
        
        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            currSqSum += (long) ((long) arr[i] * (long) arr[i]);
        }
        
        long sumDiff = currSum - sum;
        long sqSumDiff = currSqSum - sqSum;
        
        sqSumDiff /= sumDiff;
        
        repeating = (sqSumDiff + sumDiff) / 2;
        missing = sumDiff - repeating;
        
        ans.add((int) repeating);
        ans.add((int) -missing);
        
        return ans;
    }
    
    ArrayList<Integer> mapApproach(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int len = arr.length;
        int[] map = new int[len + 1];
        int repeating = 0, missing = 0;
        
        for (int num : arr) map[num]++;
        
        for (int i = 1; i < len + 1; i++) {
            if (map[i] == 2) repeating = i;
            if (map[i] == 0) missing = i;
        }
        
        ans.add(repeating);
        ans.add(missing);
        
        return ans;
    }
}
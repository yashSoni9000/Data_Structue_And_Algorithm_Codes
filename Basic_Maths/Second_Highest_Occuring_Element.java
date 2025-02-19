class Solution {
    public int secondMostFrequentElement(int[] nums) {
     int maxFreq = -1, sNum = Integer.MAX_VALUE, maxNum = Integer.MAX_VALUE, sMaxFreq = -1;
     int maxElement = 0;
     for (int i = 0; i < nums.length; i++) {
      if (nums[i] > maxElement) maxElement = nums[i];
     }
     int[] freq = new int[maxElement + 1];
     for (int i = 0; i < nums.length; i++) {
      freq[nums[i]]++;
     }

     for (int i = 0; i < freq.length; i++) {
      if (freq[i] != 0) {
        if (freq[i] > maxFreq) {
          sNum = maxNum;
          sMaxFreq = maxFreq;
          maxFreq = freq[i];
          maxNum = i;
        }
        else if (freq[i] > sMaxFreq && freq[i] != maxFreq) {
          sNum = i;
          sMaxFreq = freq[i];
        }
      }
     }
     return (sNum == Integer.MAX_VALUE ? -1 : sNum);
    }
}


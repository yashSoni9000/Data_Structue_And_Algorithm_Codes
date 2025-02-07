class Solution {
    public int getSecondLargest(int[] arr) {
      int max = Integer.MIN_VALUE, sMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                sMax = max;
                max = arr[i];
            }
            if (arr[i] < max && arr[i] > sMax) sMax = arr[i];
        }
        return (sMax == Integer.MIN_VALUE) ? -1 : sMax;
    }
}
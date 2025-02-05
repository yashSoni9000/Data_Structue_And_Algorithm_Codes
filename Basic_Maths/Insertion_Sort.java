class Solution {
    // Please change the array in-place
    public void insertionSort(int arr[]) {
        // code here
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i + 1;
            // int sortedIndex = i;
            while ((index > 0) && (arr[index] < arr[index - 1])){
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }
}